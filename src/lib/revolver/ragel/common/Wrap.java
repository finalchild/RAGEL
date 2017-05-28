package lib.revolver.ragel.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Wrap<T> {
	private static final Wrap<?> EMPTY = new Wrap<>();
	private T value = null;

	private Wrap() {
		this.value = null;
	}

	private Wrap(T value) {
		Validators.requireNonNull(value, "Wrap cannot accept null value");
		this.value = Objects.requireNonNull(value);
	}

	@NotNull
	public T get() {
		if (value == null) {
			throw new NoSuchElementException("No value present");
		}
		return value;
	}

	@NotNull
	public T orElse(@Nullable T object) {
		return orElseGet(() -> object);
	}

	@NotNull
	public T orElseGet(@NotNull Supplier<T> supplier) {
		Validators.requireNonNull(supplier, "Object supplier cannot be a null");
		return isEmpty() ? supplier.get() : get();
	}

	@NotNull
	public <X extends Throwable> T orElseThrow(@NotNull Supplier<? extends X> supplier) throws X {
		Validators.requireNonNull(supplier, "Exception supplier cannot be a null");
		if (isPresent()) {
			return get();
		}
		throw supplier.get();
	}

	@NotNull
	public <U> Wrap<U> map(@NotNull Function<T, U> mapper) {
		Validators.requireNonNull(mapper, "Mapper cannot be a null");
		return ofNullable(isEmpty() ? null : mapper.apply(value));
	}

	@Contract(pure = true)
	public boolean isPresent() {
		return !isEmpty();
	}

	@NotNull
	public Wrap<T> ifPresent(@NotNull Consumer<T> consumer) {
		Validators.requireNonNull(consumer, "Consumer cannot be a null");
		if (isPresent()) {
			consumer.accept(value);
		}
		return this;
	}

	@NotNull
	public Wrap<T> filter(@NotNull Predicate<T> filter) {
		Validators.requireNonNull(filter, "Filter cannot be a null");
		return isPresent() && filter.test(get()) ? this : empty();
	}

	@Contract(pure = true)
	public boolean isEmpty() {
		return value == null;
	}

	public Wrap<T> set(T obj) {
		this.value = obj;
		return this;
	}

	@Contract(pure = true)
	@SuppressWarnings("unchecked")
	public static <T> Wrap<T> empty() {
		return (Wrap<T>) EMPTY;
	}

	@Contract("null -> !null")
	public static <T> Wrap<T> ofNullable(@Nullable T obj) {
		return obj == null ? empty() : of(obj);
	}

	@NotNull
	public static <T> Wrap<T> of(@NotNull T obj) {
		return new Wrap<>(obj);
	}


	@Override
	public String toString() {
		return isPresent() ? "Wrap[" + value.toString() + "]" : "Wrap.empty";
	}
}

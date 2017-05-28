package lib.revolver.ragel.chaining;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Chainer<T extends U, U> {
	private U instance;

	private Chainer(U instance) {
		this.instance = instance;
	}

	@Contract(pure = true)
	@SuppressWarnings("unchecked")
	public T self() {
		try {
			return (T) instance;
		} catch (ClassCastException e) {
			throw new IllegalStateException("Generic T ");
		}
	}

	@NotNull
	@Contract("null -> fail")
	public static <T extends U, U> Chainer<T, U> create(U object) {
		if (object == null) {
			throw new IllegalArgumentException("Object must not empty");
		}
		return new Chainer<>(object);
	}
}

package lib.revolver.ragel.common.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class IntegerValue implements RationalValue<IntegerValue> {
	public static final IntegerValue ZERO = new IntegerValue(BigInteger.ZERO);
	public static final IntegerValue ONE = new IntegerValue(BigInteger.ONE);
	private final BigInteger handle;
	private final BigDecimal decimal;

	IntegerValue(@NotNull BigInteger handle) {
		this.handle = handle;
		decimal = new BigDecimal(this.handle);
	}

	@Override
	public Fraction toFraction() {
		return new Fraction(this, NaturalValue.ONE);
	}

	public IntegerValue plus(@NotNull Value value) {
		return new IntegerValue(handle.add(value.toBigInteger()));
	}

	public IntegerValue minus(@NotNull Value value) {
		return new IntegerValue(handle.subtract(value.toBigInteger()));
	}

	public IntegerValue multiply(@NotNull Value value) {
		return new IntegerValue(handle.multiply(value.toBigInteger()));
	}

	public IntegerValue div(@NotNull Value value) {
		return new IntegerValue(handle.divide(value.toBigInteger()));
	}

	public DecimalValue divideReal(@NotNull Value value) {
		return new DecimalValue(decimal.divide(value.toBigDecimal()));
	}

	public IntegerValue remainder(@NotNull Value value) {
		return new IntegerValue(handle.remainder(value.toBigInteger()));
	}

	public NaturalValue toNatural() {
		if (this.smallerThan(ONE)) {
			throw new IllegalStateException("The value is smaller than 1");
		}
		return new NaturalValue(handle);
	}

	@NotNull
	public NaturalValue abs() {
		return smallerThan(ONE) ? Maths.getNatural(handle) : toNatural();
	}

	public int compareTo(@NotNull Value value) {
		return handle.compareTo(value.toBigInteger());
	}

	@Override
	public BigDecimal toBigDecimal() {
		return decimal;
	}

	@Override
	public String toString() {
		return handle.toString();
	}
}
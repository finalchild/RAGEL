package lib.revolver.ragel.common.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class DecimalValue implements RationalValue<DecimalValue> {
	private final BigDecimal handle;

	DecimalValue(@NotNull BigDecimal handle) {
		this.handle = handle;
	}

	@Override
	public Fraction toFraction() {
		BigDecimal scaleTen = BigDecimal.TEN.pow(handle.stripTrailingZeros()
		                                               .remainder(BigDecimal.ONE)
		                                               .movePointRight(handle.scale())
		                                               .abs()
		                                               .toString()
		                                               .length());
		return new Fraction(Maths.getInt(handle.multiply(scaleTen).toBigInteger()),
		                    Maths.getNatural(scaleTen.toBigInteger())).reduction();
	}

	public IntegerValue toIntValue() {
		return Maths.getInt(handle.toBigInteger());
	}

	public DecimalValue plus(@NotNull Value value) {
		return new DecimalValue(handle.add(value.toBigDecimal()));
	}

	public DecimalValue minus(@NotNull Value value) {
		return new DecimalValue(handle.subtract(value.toBigDecimal()));
	}

	public DecimalValue multiply(@NotNull Value value) {
		return new DecimalValue(handle.multiply(value.toBigDecimal()));
	}

	public DecimalValue div(@NotNull Value value) {
		return new DecimalValue(handle.divide(value.toBigDecimal()));
	}

	public DecimalValue remainder(@NotNull Value value) {
		return new DecimalValue(handle.remainder(value.toBigDecimal()));
	}

	public int compareTo(@NotNull Value value) {
		return handle.compareTo(value.toBigDecimal());
	}

	@Override
	public BigDecimal toBigDecimal() {
		return handle;
	}

	@Override
	public String toString() {
		return handle.toString();
	}
}

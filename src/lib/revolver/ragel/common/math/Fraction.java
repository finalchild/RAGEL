package lib.revolver.ragel.common.math;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

public final class Fraction implements RationalValue<Fraction> {
	private final IntegerValue numerator; //분자
	private final NaturalValue denominator; //분모

	public Fraction(@NotNull IntegerValue numerator, @NotNull NaturalValue denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Contract(pure = true)
	public IntegerValue numerator() {
		return numerator;
	}

	@Contract(pure = true)
	public NaturalValue denominator() {
		return denominator;
	}

	public DecimalValue toDecimal() {
		return numerator.divideReal(denominator);
	}

	@Override
	public Fraction toFraction() {
		return this;
	}

	@Override
	public BigDecimal toBigDecimal() {
		return toDecimal().toBigDecimal();
	}

	@Override
	public Fraction plus(Value v) {
		Fraction result = this;
		if (v instanceof RationalValue) {
			Fraction[] rcd = reductionCommonDenominator(this, ((RationalValue) v).toFraction());
			result = new Fraction(rcd[0].numerator().plus(rcd[1].numerator()), rcd[1].denominator());
		}
		return result;
	}

	@Override
	public Fraction minus(Value v) {
		Fraction result = this;
		if (v instanceof RationalValue) {
			Fraction[] rcd = reductionCommonDenominator(this, ((RationalValue) v).toFraction());
			result = new Fraction(rcd[0].numerator().minus(rcd[1].numerator()), rcd[1].denominator());
		}
		return result;
	}

	@Override
	public Fraction remainder(Value v) {
		return null;
	}

	@Override
	public int compareTo(Value value) {
		return toDecimal().compareTo(value);
	}

	@NotNull
	public Fraction multiply(@NotNull Value i) {
		return new Fraction(numerator.multiply(i), denominator);
	}

	@NotNull
	private Fraction raise(@NotNull Value i) {
		return new Fraction(numerator.multiply(i), denominator.multiply(i).abs());
	}

	@NotNull
	public Fraction div(@NotNull Value i) {
		return new Fraction(numerator.div(i), denominator);
	}


	@NotNull
	private Fraction reduce(@NotNull Value i) {
		return new Fraction(numerator.div(i), denominator.div(i).abs());
	}

	@NotNull
	public Fraction reduction() {
		return reduce(Maths.gcd(numerator, denominator));
	}

	public static Fraction[] reductionCommonDenominator(@NotNull Fraction... fractions) {
		NaturalValue lcm = Maths.lcm(Arrays.stream(fractions).map(Fraction::denominator).toArray(IntegerValue[]::new));
		Fraction[] result = new Fraction[fractions.length];
		for (int i = 0; i < fractions.length; i++) {
			result[i] = fractions[i].raise(lcm.div(fractions[i].denominator()));
		}
		return result;
	}

	@NotNull
	@Override
	public String toString() {
		return numerator() + "/" + denominator() + " (" + toDecimal() + ")";
	}
}
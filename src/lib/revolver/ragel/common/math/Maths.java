package lib.revolver.ragel.common.math;

import lib.revolver.ragel.common.Validators;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Maths {
	@NotNull
	@Contract("null -> fail")
	public static NaturalValue getNatural(@NotNull BigInteger i) {
		Validators.requireNonNull(i, "Value must not be a null");
		return new NaturalValue(i);
	}

	@NotNull
	public static NaturalValue getNatural(long i) {
		return getNatural(new BigInteger(String.valueOf(i)));
	}

	@NotNull
	public static NaturalValue getNatural(int i) {
		return getNatural(new BigInteger(String.valueOf(i)));
	}

	@NotNull
	@Contract("null -> fail")
	public static IntegerValue getInt(@NotNull BigInteger i) {
		Validators.requireNonNull(i, "Value must not be a null");
		return new IntegerValue(i);
	}

	@NotNull
	public static IntegerValue getInt(long i) {
		return getInt(new BigInteger(String.valueOf(i)));
	}

	@NotNull
	public static IntegerValue getInt(int i) {
		return getInt(new BigInteger(String.valueOf(i)));
	}

	@NotNull
	@Contract("null -> fail")
	public static DecimalValue getDecimal(@NotNull BigDecimal i) {
		Validators.requireNonNull(i, "Value must not be a null");
		return new DecimalValue(i);
	}

	@NotNull
	public static DecimalValue getDecimal(long i) {
		return getDecimal(new BigDecimal(i));
	}

	@NotNull
	public static DecimalValue getDecimal(int i) {
		return getDecimal(new BigDecimal(i));
	}

	@NotNull
	public static DecimalValue getDecimal(double i) {
		return getDecimal(new BigDecimal(String.valueOf(i)));
	}

	@NotNull
	public static DecimalValue getDecimal(float i) {
		return getDecimal(new BigDecimal(String.valueOf(i)));
	}

	public static int gcd(int... ints) {
		Validators.requireSize(ints, "Argument length must bigger than 1", 2);
		int result = gcd(ints[0], ints[1]);
		for (int i = 2; i < ints.length; i++) {
			result = gcd(result, ints[i]);
		}
		return result;
	}

	@Contract(pure = true)
	private static int gcd(int p, int q) {
		if (p < q) {
			int tmp = p;
			p = q;
			q = tmp;
		}
		while (q != 0) {
			int tmp = p % q;
			p = q;
			q = tmp;
		}
		return p;
	}

	public static NaturalValue gcd(IntegerValue... values) {
		Validators.requireSize(values, "Argument length must bigger than 1", 2);
		return gcd(toNaturalValues(values));
	}

	public static NaturalValue gcd(NaturalValue... values) {
		Validators.requireSize(values, "Argument length must bigger than 1", 2);
		NaturalValue result = gcd(values[0], values[1]);
		for (int i = 2; i < values.length; i++) {
			result = gcd(result, values[i]);
		}
		return result;
	}

	private static NaturalValue[] toNaturalValues(IntegerValue[] values) {
		NaturalValue[] nvalues = new NaturalValue[values.length];
		for (int i = values.length - 1; i >= 0; i--) {
			nvalues[i] = values[i].toNatural();
		}
		return nvalues;
	}

	public static NaturalValue lcm(IntegerValue... values) {
		Validators.requireSize(values, "Argument length must bigger than 1", 2);
		return lcm(toNaturalValues(values));
	}

	public static NaturalValue lcm(NaturalValue... values) {
		Validators.requireSize(values, "Argument length must bigger than 1", 2);
		NaturalValue result = lcm(values[0], values[1]);
		for (int i = 2; i < values.length; i++) {
			result = lcm(result, values[i]);
		}
		return result;
	}

	@NotNull
	@Contract(pure = true)
	private static NaturalValue lcm(NaturalValue p, IntegerValue q) {
		return p.multiply(q).div(gcd(p, q)).abs();
	}


	@Contract(pure = true)
	private static NaturalValue gcd(NaturalValue p, IntegerValue q) {
		if (p.smallerThan(q)) {
			NaturalValue tmp = p;
			p = q.toNatural();
			q = tmp;
		}
		while (!q.smallerThan(IntegerValue.ONE)) {
			IntegerValue tmp = p.remainder(q);
			p = q.toNatural();
			q = tmp;
		}
		return p;
	}
}
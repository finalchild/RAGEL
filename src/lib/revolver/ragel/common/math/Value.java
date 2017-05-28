package lib.revolver.ragel.common.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Value<T extends Value> {
	BigDecimal toBigDecimal();

	default BigInteger toBigInteger() {
		return toBigDecimal().toBigInteger();
	}

	default double toDouble() {
		return toBigDecimal().doubleValue();
	}

	default long toLong() {
		return toBigDecimal().longValue();
	}

	default int toInt() {
		return toBigDecimal().intValue();
	}

	T plus(Value v);

	T minus(Value v);

	T multiply(Value v);

	T div(Value v);

	T remainder(Value v);

	int compareTo(Value value);

	default T plus(long v) {
		return plus(Maths.getInt(v));
	}

	default T minus(long v) {
		return minus(Maths.getInt(v));
	}

	default T multiply(long v) {
		return multiply(Maths.getInt(v));
	}

	default T div(long v) {
		return div(Maths.getInt(v));
	}

	default T remainder(long v) {
		return remainder(Maths.getInt(v));
	}

	default int compareTo(long v) {
		return compareTo(Maths.getInt(v));
	}


	default T plus(int v) {
		return plus(Maths.getInt(v));
	}

	default T minus(int v) {
		return minus(Maths.getInt(v));
	}

	default T multiply(int v) {
		return multiply(Maths.getInt(v));
	}

	default T div(int v) {
		return div(Maths.getInt(v));
	}

	default T remainder(int v) {
		return remainder(Maths.getInt(v));
	}

	default int compareTo(int v) {
		return compareTo(Maths.getInt(v));
	}

	default T plus(double v) {
		return plus(Maths.getDecimal(v));
	}

	default T minus(double v) {
		return minus(Maths.getDecimal(v));
	}

	default T multiply(double v) {
		return multiply(Maths.getDecimal(v));
	}

	default T div(double v) {
		return div(Maths.getDecimal(v));
	}

	default T remainder(double v) {
		return remainder(Maths.getDecimal(v));
	}

	default int compareTo(double v) {
		return compareTo(Maths.getDecimal(v));
	}

	default boolean smallerThan(Value value) {
		return compareTo(value) < 0;
	}

	default boolean biggerThan(Value value) {
		return compareTo(value) > 0;
	}

	default boolean equals(Value value) {
		return compareTo(value) == 0;
	}
}
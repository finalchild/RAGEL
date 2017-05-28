package lib.revolver.ragel.common.math;

public interface RationalValue<T extends RationalValue> extends Value<T> {
	Fraction toFraction();
}
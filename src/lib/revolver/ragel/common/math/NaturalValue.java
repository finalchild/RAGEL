package lib.revolver.ragel.common.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class NaturalValue extends IntegerValue {
	public static final NaturalValue ZERO = new NaturalValue(BigInteger.ZERO);
	public static final NaturalValue ONE = new NaturalValue(BigInteger.ONE);

	public NaturalValue(@NotNull BigInteger handle) {
		super(handle);
		if (handle.compareTo(BigInteger.ZERO) < 0) {
			throw new IllegalArgumentException("Argument must bigger than 0");
		}
	}
}
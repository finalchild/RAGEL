package lib.revolver.ragel.common;

import lib.revolver.ragel.util.ArrayUtil;
import org.jetbrains.annotations.Contract;

import java.util.Collection;

public final class Validators {
	@Contract("null, _ -> fail")
	public static void requireNonNull(Object o, String msg) {
		if (o == null) {
			throw new ValidationError(msg);
		}
	}

	public static void requireNonZero(int o, String msg) {
		if (o != 0) {
			throw new ValidationError(msg);
		}
	}

	@Contract("!null, _ -> fail")
	public static void requireNull(Object o, String msg) {
		if (o != null) {
			throw new ValidationError(msg);
		}
	}

	@Contract("null, _, _ -> fail")
	public static void requireSize(Object[] o, String msg, int len) {
		if (o == null || o.length < len) {
			throw new ValidationError(msg);
		}
	}

	public static void requireSize(byte[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(short[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(int[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(long[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(float[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(double[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(boolean[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireSize(char[] o, String msg, int len) {
		requireSize(ArrayUtil.boxed(o), msg, len);
	}

	public static void requireNotEmpty(Object[] o, String msg) {
		requireSize(o, msg, 1);
	}

	public static void requireNotEmpty(byte[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(short[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(int[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(long[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(float[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(double[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(boolean[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	public static void requireNotEmpty(char[] o, String msg) {
		requireNotEmpty(ArrayUtil.boxed(o), msg);
	}

	@Contract("null, _ -> fail")
	public static void requireNotEmpty(Collection<?> o, String msg) {
		if (o == null || o.size() <= 0) {
			throw new ValidationError(msg);
		}
	}
}
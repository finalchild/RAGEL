package lib.revolver.ragel.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public final class ArrayUtil {
	@Contract(value = "null -> !null", pure = true)
	public static Boolean[] boxed(@Nullable boolean[] data) {
		if (data == null) { return new Boolean[0]; }
		Boolean[] result = new Boolean[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Byte[] boxed(@Nullable byte[] data) {
		if (data == null) { return new Byte[0]; }
		Byte[] result = new Byte[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Short[] boxed(@Nullable short[] data) {
		if (data == null) { return new Short[0]; }
		Short[] result = new Short[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Character[] boxed(@Nullable char[] data) {
		if (data == null) { return new Character[0]; }
		Character[] result = new Character[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Integer[] boxed(@Nullable int[] data) {
		if (data == null) { return new Integer[0]; }
		Integer[] result = new Integer[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Long[] boxed(@Nullable long[] data) {
		if (data == null) { return new Long[0]; }
		Long[] result = new Long[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Float[] boxed(@Nullable float[] data) {
		if (data == null) { return new Float[0]; }
		Float[] result = new Float[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static Double[] boxed(@Nullable double[] data) {
		if (data == null) { return new Double[0]; }
		Double[] result = new Double[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static boolean[] unboxed(@Nullable Boolean[] data) {
		if (data == null) { return new boolean[0]; }
		boolean[] result = new boolean[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static byte[] unboxed(@Nullable Byte[] data) {
		if (data == null) { return new byte[0]; }
		byte[] result = new byte[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static short[] unboxed(@Nullable Short[] data) {
		if (data == null) { return new short[0]; }
		short[] result = new short[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static char[] unboxed(@Nullable Character[] data) {
		if (data == null) { return new char[0]; }
		char[] result = new char[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static int[] unboxed(@Nullable Integer[] data) {
		if (data == null) { return new int[0]; }
		int[] result = new int[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static long[] unboxed(@Nullable Long[] data) {
		if (data == null) { return new long[0]; }
		long[] result = new long[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static float[] unboxed(@Nullable Float[] data) {
		if (data == null) { return new float[0]; }
		float[] result = new float[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}

	@Contract(value = "null -> !null", pure = true)
	public static double[] unboxed(@Nullable Double[] data) {
		if (data == null) { return new double[0]; }
		double[] result = new double[data.length];
		for (int i = data.length - 1; i > 0; i--) {
			result[i] = data[i];
		}
		return result;
	}
}
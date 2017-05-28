package lib.revolver.ragel.common.escape;

public interface Escaper {
	Escaper JAVA_BACKSLASH = new JavaBackslashEscaper();

	String escape(String str);
}
package lib.revolver.ragel.common.escape;

public class JavaBackslashEscaper implements Escaper {
	JavaBackslashEscaper() {
	}

	@Override
	public String escape(String str) {
		return str.replace("\r", "\\r")
		          .replace("\t", "\\t")
		          .replace("\f", "\\f")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n");
	}
}

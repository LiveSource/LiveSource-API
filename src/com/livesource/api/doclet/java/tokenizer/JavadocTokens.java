package com.livesource.api.doclet.java.tokenizer;

public enum JavadocTokens {

	STAR("*"), STAR_REGULAR_EXPRESSION("\\*"), AT("@"), JAVADOC_INIT("/**"), JAVADOC_INIT_REGULAR_EXPRESSION(
			"/\\*"), JAVADOC_END("*/"), JAVADOC_END_REGULAR_EXPRESSION("\\*/"), COMMENT(
			"//"), CAR_RETURN_CHAR("\r"), LINE_END("\n");

	public final String name;

	JavadocTokens() {
		this(null);
	}

	JavadocTokens(String name) {
		this.name = name;
	}

}

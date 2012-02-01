package com.livesource.api.doclet.java.tokenizer;

/**
 * An interface that defines codes for Java source tokens returned from lexical
 * analysis.
 * 
 * <p>
 * <b>This is NOT part of any API suppored by Sun Microsystems. If you write
 * code that depends on this, you do so at your own risk. This code and its
 * internal interfaces are subject to change or deletion without notice.</b>
 */
public enum JavaTokens {
	EOF, ERROR, IDENTIFIER, ABSTRACT("abstract"), ASSERT("assert"), BOOLEAN(
			"boolean"), BREAK("break"), BYTE("byte"), CASE("case"), CATCH(
			"catch"), CHAR("char"), CLASS("class"), CONST("const"), CONTINUE(
			"continue"), DEFAULT("default"), DO("do"), DOUBLE("double"), ELSE(
			"else"), ENUM("enum"), EXTENDS("extends"), FINAL("final"), FINALLY(
			"finally"), FLOAT("float"), FOR("for"), GOTO("goto"), IF("if"), IMPLEMENTS(
			"implements"), IMPORT("import"), INSTANCEOF("instanceof"), INT(
			"int"), INTERFACE("interface"), LONG("long"), NATIVE("native"), NEW(
			"new"), PACKAGE("package"), PRIVATE("private"), PROTECTED(
			"protected"), PUBLIC("public"), RETURN("return"), SHORT("short"), STATIC(
			"static"), STRICTFP("strictfp"), SUPER("super"), SWITCH("switch"), SYNCHRONIZED(
			"synchronized"), THIS("this"), THROW("throw"), THROWS("throws"), TRANSIENT(
			"transient"), TRY("try"), VOID("void"), VOLATILE("volatile"), WHILE(
			"while"), INTLITERAL, LONGLITERAL, FLOATLITERAL, DOUBLELITERAL, CHARLITERAL, STRINGLITERAL, TRUE(
			"true"), FALSE("false"), NULL("null"), LPAREN("("), RPAREN(")"), LBRACE(
			"{"), RBRACE("}"), LBRACKET("["), RBRACKET("]"), SEMI(";"), COMMA(
			","), DOT("."), ELLIPSIS("..."), EQ("="), GT(">"), LT("<"), BANG(
			"!"), TILDE("~"), QUES("?"), COLON(":"), EQEQ("=="), LTEQ("<="), GTEQ(
			">="), BANGEQ("!="), AMPAMP("&&"), BARBAR("||"), PLUSPLUS("++"), SUBSUB(
			"--"), PLUS("+"), SUB("-"), STAR("*"), SLASH("/"), AMP("&"), BAR(
			"|"), CARET("^"), PERCENT("%"), LTLT("<<"), GTGT(">>"), GTGTGT(
			">>>"), PLUSEQ("+="), SUBEQ("-="), STAREQ("*="), SLASHEQ("/="), AMPEQ(
			"&="), BAREQ("|="), CARETEQ("^="), PERCENTEQ("%="), LTLTEQ("<<="), GTGTEQ(
			">>="), GTGTGTEQ(">>>="), MONKEYS_AT("@");

	JavaTokens() {
		this(null);
	}

	JavaTokens(String name) {
		this.name = name;
	}

	public final String name;
}
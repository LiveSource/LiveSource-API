package com.livesource.api.doclet.java.tokenizer;

import java.util.ArrayList;

public class TokenizeComments {

	public TokenizeComments(String classSource, ArrayList<String> tokenArray) {

		splitSource(tokenArray, classSource,
				JavadocTokens.JAVADOC_INIT_REGULAR_EXPRESSION.name,
				JavadocTokens.JAVADOC_INIT.name, JavadocTokens.JAVADOC_END.name);

		Object[] splitArray = tokenArray.toArray();

		tokenArray.clear();

		for (int i = 0; i < splitArray.length; i++) {

			String tokenJavadoc = (String) splitArray[i];

			splitSource(tokenArray, tokenJavadoc, JavadocTokens.COMMENT.name,
					JavadocTokens.LINE_END.name);
		}

	}

	private void splitSource(ArrayList<String> tokenArray, String tokenString,
			String tokenInitial, String tokenEnd) {

		splitSource(tokenArray, tokenString, tokenInitial, tokenInitial,
				tokenEnd);
	}

	private void splitSource(ArrayList<String> tokenArray, String tokenString,
			String tokenInitialRegularExpression, String tokenInitial,
			String tokenEnd) {

		String[] splitArray = tokenString.split(tokenInitialRegularExpression);

		tokenArray.add(splitArray[0]);

		for (int i = 1; i < splitArray.length; i++) {

			String nextToken = tokenInitial + splitArray[i];

			int positionEnd = nextToken.indexOf(tokenEnd);

			String currentToken = nextToken.substring(0, positionEnd);

			tokenArray.add(currentToken + tokenEnd);

			nextToken = nextToken.substring(positionEnd + tokenEnd.length());

			splitSource(tokenArray, nextToken, tokenInitialRegularExpression,
					tokenInitial, tokenEnd);
		}
	}

}
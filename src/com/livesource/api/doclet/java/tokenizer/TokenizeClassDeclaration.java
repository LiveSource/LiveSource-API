package com.livesource.api.doclet.java.tokenizer;

import java.util.ArrayList;

public class TokenizeClassDeclaration {

	public static void getClassArrayIndex(ArrayList<String> tokenArray) {

		ArrayList<String> tokenArrayAux = (ArrayList<String>) tokenArray
				.clone();

		tokenArray.clear();

		boolean isCommand = true;

		for (int i = 0; i < tokenArrayAux.size(); i++) {

			String nextToken = tokenArrayAux.get(i);

			if (isCommand
					&& !nextToken.startsWith(JavadocTokens.JAVADOC_INIT.name)
					&& !nextToken.startsWith(JavadocTokens.COMMENT.name)) {

				isCommand = tokenizeCommands(tokenArray, nextToken);

			} else {

				tokenArray.add(nextToken);
			}
		}
	}

	private static boolean tokenizeCommands(ArrayList<String> tokenArray,
			String nextToken) {

		boolean isCommand = true;

		int nextLinePositionEnd = nextToken.indexOf(JavaTokens.SEMI.name);

		int classTokenPosition = getClassTokenPosition(nextToken);

		if ((nextLinePositionEnd != -1)
				&& (classTokenPosition >= 0 && nextLinePositionEnd < classTokenPosition)) {

			tokenArray.add(nextToken.substring(0, nextLinePositionEnd
					+ JavaTokens.SEMI.name.length()));

			nextToken = nextToken.substring(nextLinePositionEnd
					+ JavaTokens.SEMI.name.length());

			isCommand = tokenizeCommands(tokenArray, nextToken);

		} else {

			tokenArray.add(nextToken);

			isCommand = false;
		}

		return isCommand;
	}

	public static int getClassTokenPosition(String nextToken) {

		int classTokenPosition = nextToken.indexOf(JavaTokens.CLASS.name);

		if (classTokenPosition >= 0) {

			return classTokenPosition;

		} else {

			int interfaceTokenPosition = nextToken
					.indexOf(JavaTokens.INTERFACE.name);

			return interfaceTokenPosition;
		}
	}

}
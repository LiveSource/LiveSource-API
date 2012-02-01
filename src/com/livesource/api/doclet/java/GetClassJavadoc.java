package com.livesource.api.doclet.java;

import java.util.ArrayList;

import com.livesource.api.doclet.java.tokenizer.JavadocTokens;
import com.livesource.api.doclet.java.tokenizer.Tokenize;
import com.livesource.api.doclet.java.tokenizer.TokenizeClassDeclaration;

public class GetClassJavadoc {

	public static String getJavadoc(String fileContent) {

		String classJavadoc = null;

		ArrayList<String> classSourceTokenized = Tokenize
				.getClassArrayIndex(fileContent);

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			String token = classSourceTokenized.get(i);

			if (TokenizeClassDeclaration.getClassTokenPosition(token) >= 0) {

				if (classSourceTokenized.get(i - 1).startsWith(
						JavadocTokens.JAVADOC_INIT.name)) {

					classJavadoc = classSourceTokenized.get(i - 1);
				}

				break;
			}
		}

		return classJavadoc;
	}

}
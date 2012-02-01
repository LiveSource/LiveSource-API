package com.livesource.api.doclet.java;

import java.util.ArrayList;

import com.livesource.api.doclet.java.tokenizer.JavadocTokens;
import com.livesource.api.doclet.java.tokenizer.Tokenize;
import com.livesource.api.doclet.java.tokenizer.TokenizeClassDeclaration;

public class EditClassDescription {

	public static String edit(String fileContent, String classType, String classStatus,
			String classDescription) {

		ArrayList<String> classSourceTokenized = Tokenize
				.getClassArrayIndex(fileContent);

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			String token = classSourceTokenized.get(i);

			if (!token.startsWith(JavadocTokens.JAVADOC_INIT.toString())
					&& !token.startsWith(JavadocTokens.COMMENT.toString())
					&& TokenizeClassDeclaration.getClassTokenPosition(token) >= 0) { 

				classSourceTokenized.set(
						i,
						getNewClassJavadoc(classType, classStatus,
								classDescription) + token);

				if (classSourceTokenized.get(i - 1).startsWith(
						JavadocTokens.JAVADOC_INIT.toString())) {

					classSourceTokenized.set(i - 1, "");
				}

				break;
			}
		}

		String classSourceUpdated = "";

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			classSourceUpdated += classSourceTokenized.get(i);
		}

return classSourceUpdated;
	}

	private static String getNewClassJavadoc(String classType, String classStatus,
			String classDescription) {

		String stringStatus = "";
		if (classStatus != null && !classStatus.equals("")) {

			stringStatus = "\n * @" + classStatus;
		}

		String stringType = "";

		if (classType != null && !classType.equals("")) {

			stringType = "\n * @" + classType;
		}

		String comment = "\n\n/** \n * " + classDescription + "\n * "
				+ stringStatus + stringType + " \n */";

		return comment;
	}

}
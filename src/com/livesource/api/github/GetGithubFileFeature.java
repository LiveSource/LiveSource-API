package com.livesource.api.github;

import org.json.JSONObject;

import com.livesource.api.doclet.java.GetClassJavadoc;
import com.livesource.api.doclet.java.tokenizer.TokenizeJavadoc;

public class GetGithubFileFeature {

	public static final String EXTENSION_JAVA = "java";

	public static JSONObject getClassDescription(String fileContent,
			String fileExtension) {

		JSONObject classDescriptionJson = new JSONObject();

		if (EXTENSION_JAVA.equals(fileExtension)) {

			String classJavadocString = GetClassJavadoc.getJavadoc(fileContent);

			classDescriptionJson = TokenizeJavadoc.tokenize(classJavadocString);
		}

		return classDescriptionJson;
	}

}

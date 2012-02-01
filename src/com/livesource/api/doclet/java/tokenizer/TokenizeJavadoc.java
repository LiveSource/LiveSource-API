package com.livesource.api.doclet.java.tokenizer;

import org.json.JSONException;
import org.json.JSONObject;

public class TokenizeJavadoc {

	public static JSONObject tokenize(String javadocString) {

		JSONObject jsonJavadoc = new JSONObject();

		if (javadocString != null) {

			javadocString = javadocString.replaceAll(
					JavadocTokens.JAVADOC_INIT_REGULAR_EXPRESSION.name, "");

			javadocString = javadocString.replaceAll(
					JavadocTokens.JAVADOC_END_REGULAR_EXPRESSION.name, "");

			javadocString = javadocString.replaceAll(
					JavadocTokens.STAR_REGULAR_EXPRESSION.name, "");

			String[] javadocTagsArray = javadocString.trim().split(
					JavadocTokens.AT.name);

			String classDescription = "";

			String classType = null;

			String classStatus = null;

			for (String tag : javadocTagsArray) {

				tag = tag.trim();

				for (LiveSourceClassTypeTags typeTag : LiveSourceClassTypeTags
						.values()) {

					if (typeTag.name().equals(tag)) {

						classType = tag;
						break;
					}
				}

				for (LiveSourceClassStatusTags statusTag : LiveSourceClassStatusTags
						.values()) {

					if (statusTag.name().equals(tag)) {

						classStatus = tag;
						break;
					}
				}

				if (tag != classType && tag != classStatus) {

					classDescription += tag;
				}
			}

			try {

				jsonJavadoc.put("classDescription", classDescription);

				jsonJavadoc.put("classType", classType);

				jsonJavadoc.put("classStatus", classStatus);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return jsonJavadoc;
	}
}
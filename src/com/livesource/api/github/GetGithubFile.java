package com.livesource.api.github;

import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;
import com.livesource.api.URLUtilities;

public class GetGithubFile {

	private static final String reposURL = "https://api.github.com/repos/";

	public static String getFile(final String authToken,
			final String githubRepository, final String sha) {

		String parameters = authToken;

		final String jsonString = URLUtilities.fetchURLGet(reposURL
				+ githubRepository + "/git/blobs/" + sha, parameters);

		return jsonString;
	}

	public static String getFileContent(final String authToken,
			final String githubRepository, final String sha) {

		String content = null;

		String jsonFileString = getFile(authToken, githubRepository, sha);

		JSONObject jsonFile;

		try {

			jsonFile = new JSONObject(jsonFileString);

			content = jsonFile.getString("content");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return content;
	}

	public static String getFileContentDecoded(
			final String authenticationToken, final String githubRepository,
			final String fileSha) {

		String fileContent = getFileContent(authenticationToken,
				githubRepository, fileSha);

		String fileContentDecoded = decodeBase64(fileContent);

		return fileContentDecoded;
	}

	public static String decodeBase64(String encodedString) {

		byte[] decodedStr = Base64.decode(encodedString);

		return new String(decodedStr);
	}
}

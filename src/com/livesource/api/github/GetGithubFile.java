package com.livesource.api.github;

import org.json.JSONException;
import org.json.JSONObject;

import com.livesource.api.URLUtilities;

public class GetGithubFile {

	private static final String reposURL = "https://api.github.com/repos/";

	public static String getFile(final String authToken,
			final String githubRepository, final String sha) {

		final String jsonString = URLUtilities.fetchURL(reposURL
				+ githubRepository + "/git/blobs/" + sha + "?" + authToken);

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
}

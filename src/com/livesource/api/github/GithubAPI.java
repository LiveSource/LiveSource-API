package com.livesource.api.github;

import com.livesource.api.URLUtil;


public class GithubAPI {

	private static final String userURL = "https://api.github.com/user";

	private static final String userEmailsURL = "https://api.github.com/user/emails";

	private static final String reposURL = "https://api.github.com/repos/";

	public static String me(final String authToken) {

		// {"type":"User","public_gists":0,"html_url":"https://github.com/allineo",
		// "created_at":"2011-03-24T18:45:16Z","email":null,"bio":null,"total_private_repos":0,"private_gists":0,
		// "public_repos":7,"url":"https://api.github.com/users/allineo","login":"allineo",
		// "plan":{"private_repos":0,"space":307200,"collaborators":0,"name":"free"},"owned_private_repos":0,
		// "collaborators":0,"following":0,"followers":1,"blog":"livesourceagile.blogspot.com",
		// "gravatar_id":"fc8dd4cc6324ade763ffe4b3f69b02a8",
		// "avatar_url":"https://secure.gravatar.com/avatar/fc8dd4cc6324ade763ffe4b3f69b02a8?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
		// "disk_usage":33988,"name":"Alline Watkins","location":"San Diego, CA","id":688892,"company":"LiveSource","hireable":false}

		final String jsonString = URLUtil.fetchURL(userURL + "?" + authToken);

		return jsonString;
	}

	public static String userEmails(final String authToken) {

		final String json = URLUtil.fetchURL(userEmailsURL + "?" + authToken);

		return json; 
	}

	public static String listSourceFiles(final String authToken,
			final String githubRepository) {

		final String json = URLUtil.fetchURL(reposURL + githubRepository
				+ "/git/trees/master?recursive=1&" + authToken);

		return json;
	}

	public static String getFile(final String authToken,
			final String githubRepository, final String sha) {

		final String jsonString = URLUtil.fetchURL(reposURL + githubRepository
				+ "/git/blobs/" + sha + "?" + authToken);

		return jsonString;
	}

}

package com.livesource.api.github;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.livesource.api.ServletUtilities;

public class GetGithubFileFeatureServlet extends HttpServlet {

	// http://localhost:8888/livesourceapi/GetGithubFileFeature?
	// access_token=b5af59983483e88f308487943fc5308b225e7225&token_type=bearer
	// &githubRepository=LiveSource/TicTacToe4j
	// &fileExtension=java
	// &sha=63756ce4c0bc4da4b4bbe9e90f8d2c3181489186

	// sha=9aa3b553395a0aa89e4f8da688de546be86e91fa

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String authenticationToken = request.getParameter("access_token");

		String githubRepository = request.getParameter("githubRepository");

		String fileExtension = request.getParameter("fileExtension");

		String fileSha = request.getParameter("sha");

		String fileContent = GetGithubFile.getFileContentDecoded(
				authenticationToken, githubRepository, fileSha);

		JSONObject classDescription = GetGithubFileFeature.getClassDescription(
				fileContent, fileExtension);

		String answer = ServletUtilities.getCallback(
				request.getParameter("callback"), classDescription.toString());

		response.getWriter().println(answer);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String authenticationToken = request.getParameter("access_token");

		String githubRepository = request.getParameter("githubRepository");

		String fileExtension = request.getParameter("fileExtension");

		String fileSha = request.getParameter("sha");

		String fileContent = GetGithubFile.getFileContentDecoded(
				authenticationToken, githubRepository, fileSha);

		JSONObject classDescriptionJson = GetGithubFileFeature
				.getClassDescription(fileContent, fileExtension);

		try {

			classDescriptionJson.put("fileContent", fileContent);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		String answer = ServletUtilities.getCallback(
				request.getParameter("callback"),
				classDescriptionJson.toString());

		response.getWriter().println(answer);
	}

}

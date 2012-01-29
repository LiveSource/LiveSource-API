package com.livesource.api.github;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livesource.api.ServletUtilities;

public class GetGithubFileFeatureServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String authToken = request.getParameter("authToken");

		String githubRepository = request.getParameter("githubRepository");
		
		String fileSha = request.getParameter("sha");

		String fileContent = GetGithubFile.getFileContent(authToken, githubRepository, fileSha);

		String answer = ServletUtilities.getCallback(request.getParameter("callback"),
				entity.toString());

		response.getWriter().println(answer);
	}
}

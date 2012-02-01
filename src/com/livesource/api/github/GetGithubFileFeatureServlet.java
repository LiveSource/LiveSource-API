package com.livesource.api.github;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;
import com.livesource.api.ServletUtilities;
import com.livesource.api.doclet.java.GetClassJavadoc;
import com.livesource.api.doclet.java.tokenizer.TokenizeJavadoc;

public class GetGithubFileFeatureServlet extends HttpServlet {

	// http://localhost:8888/livesourceapi/GetGithubFileFeature?
	// access_token=b5af59983483e88f308487943fc5308b225e7225&token_type=bearer
	// &githubRepository=LiveSource/TicTacToe4j
	// &sha=63756ce4c0bc4da4b4bbe9e90f8d2c3181489186

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String authToken = request.getParameter("access_token");

		String githubRepository = request.getParameter("githubRepository");

		String fileSha = request.getParameter("sha");

		String fileContent = GetGithubFile.getFileContent(authToken,
				githubRepository, fileSha);

		String fileContentDecoded = decodeBase64(fileContent);

		String classJavadocString = GetClassJavadoc
				.getJavadoc(fileContentDecoded);

		JSONObject classDescription = TokenizeJavadoc
				.tokenize(classJavadocString);

		String answer = ServletUtilities.getCallback(
				request.getParameter("callback"), classDescription.toString());

		response.getWriter().println(answer);
	}

	public static String decodeBase64(String encodedString) {

		byte[] decodedStr = Base64.decode(encodedString);

		return new String(decodedStr);
	}
}

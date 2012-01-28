package com.livesource.api;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;

import com.google.appengine.repackaged.org.json.JSONObject;


public class LiveSourceAPIServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		
		String kind = request.getParameter("authToken");

		String keyName = request.getParameter("ID");

		JSONObject entity = GetData.getJson(kind, keyName);

		String answer = Utilities.getCallback(request.getParameter("callback"),
				entity.toString());

		response.getWriter().println(answer);
	}
}

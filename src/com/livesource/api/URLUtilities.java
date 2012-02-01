package com.livesource.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLUtilities {

	public static String encode(final String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	public static String decode(final String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	public static String fetchURLGet(final String u, String parameters) {

		String returnedString = "";
		try {
			final URL url = new URL(u + "?" + encode(parameters));
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				returnedString += line;
			}
			reader.close();

		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException calling url" + u
					+ e.getMessage());
		} catch (final IOException e) {
			System.out.println("IOException calling url" + u + e.getMessage());
		}
		return returnedString;
	}

	public static String fetchURLPost(final String u, String parameters) {

		String returnedString = "";

		try {

			final URL url = new URL(u);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(parameters);
			writer.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));

				String line;
				while ((line = reader.readLine()) != null) {
					returnedString += line;
				}

				reader.close();

			} else {
				System.out.println(connection.getResponseCode());
			}

		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException calling url" + u
					+ e.getMessage());
		} catch (final IOException e) {
			System.out.println("IOException calling url" + u + e.getMessage());
		}
		return returnedString;
	}

}

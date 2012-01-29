package com.livesource.api;

import org.json.JSONException;
import org.json.JSONObject;

public class ServletUtilities {

	public static String getCallback(String callback, String entities) {

		if (callback != null) {

			return callback + "(" + entities + ");";
		}

		return entities;
	}

	public static String getCallbackResponse(String callback) {

		JSONObject jsonFeed = null;

		try {

			jsonFeed = new JSONObject();

			jsonFeed.put("response", "OK");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return getCallback(callback, jsonFeed.toString());
	}

}

package com.livesource.api.doclet.java.tokenizer;

public enum LiveSourceClassStatusTags {

	ToDo, InProgress;

	public final String name;

	LiveSourceClassStatusTags() {
		this(null);
	}

	LiveSourceClassStatusTags(String name) {
		this.name = name;
	}

}

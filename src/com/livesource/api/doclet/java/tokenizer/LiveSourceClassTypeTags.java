package com.livesource.api.doclet.java.tokenizer;

public enum LiveSourceClassTypeTags {

	Feature, UserInterface, Architecture, Entity;

	public final String name;

	LiveSourceClassTypeTags() {
		this(null);
	}

	LiveSourceClassTypeTags(String name) {
		this.name = name;
	}

}

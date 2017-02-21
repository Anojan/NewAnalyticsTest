package com.javacodegeeks.drools.model;

import java.util.Map;

public class Analysis {
	private Map<String, String> results;
	private Map<String, String> tags;
	private String url;
	private boolean debug;

	public Map<String, String> getResults() {
		return results;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public String getUrl() {
		return url;
	}

	public void setResults(Map<String, String> results) {
		this.results = results;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean contains(String tag, String value) {
		return (tags.get(tag).equals(value)) ? true : false;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		System.out.println(debug);
		this.debug = debug;
	}
	
	public void name() {
		System.err.println("done!!");
	}

}

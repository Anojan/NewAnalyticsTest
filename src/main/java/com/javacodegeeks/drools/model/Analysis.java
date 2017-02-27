package com.javacodegeeks.drools.model;

import java.util.Map;

public class Analysis {
	private Map<String, String> results;
	private Map<String, String> tags;
	private String url;
	private String debug;

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

	public boolean check(String tag, String value) {
		String a = (tags.get(tag) != null) ? tags.get(tag) : "";
		return (a.equals(value)) ? true : false;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		System.out.println(debug);
		this.debug = debug;
	}

	public void name() {
		System.err.println("done!!");
	}

}

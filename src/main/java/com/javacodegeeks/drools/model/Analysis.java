package com.javacodegeeks.drools.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Analysis {

	private Map<String, String> tags;
	private String url;
	private List<Analysis> result = new ArrayList<Analysis>();
	private String keyValuePair;

	public String getKeyValuePair() {
		return keyValuePair;
	}

	public void setKeyValuePair(String keyValuePair) {
		this.keyValuePair = keyValuePair;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public String getUrl() {
		return url;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean checkUrl(String url) {
		return this.url.equals(url);
	}

	public List<Analysis> getResult() {
		return result;
	}

	public void setResult() {
		Analysis thisObj = new Analysis();
		thisObj.setUrl(this.url);
		thisObj.setKeyValuePair(this.keyValuePair);
		this.result.add(thisObj);
		System.out.println("Success: " + result);
	}

	public boolean checkKey(String keyValuePair) {
		this.keyValuePair = keyValuePair;
		String[] pair = keyValuePair.split(Pattern.quote(":"));
		String key = pair[0];
		String value = pair[1];
		if (null != key || null != value)
		return tags.get(key).equals(value);
		return false;
	}
	
	public String getAll() {
		String all = "";
		for (Analysis analysis : result) {
			all += analysis.toString() + ","; 
		}
		return all;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "<" + this.url + ">[" + this.keyValuePair + "]{" + getAll() + "}" ;
	}

}

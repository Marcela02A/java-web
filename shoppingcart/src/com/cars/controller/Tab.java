package com.cars.controller;

public class Tab {

	public Tab(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getString() {
		return this.toString();
	}

	public String name;
	public String url;

	@Override
	public String toString() {

		return String.format("Tab{name='%s' , url='%s'}", name, url);
	}

}

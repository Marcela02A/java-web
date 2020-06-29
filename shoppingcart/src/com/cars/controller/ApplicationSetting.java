package com.cars.controller;

import java.util.Map;

public class ApplicationSetting {

	private CssClass formCssClass;

	public CssClass getFormCssClass() {
		return formCssClass;
	}

	public void setFormCssClass(CssClass cssClass) {
		formCssClass = cssClass;
	}

	public String[] tabNames;

	public String[] getTabNames() {
		return tabNames;
	}

	public void setTabName(String[] names) {
		tabNames = new String[names.length];
		System.arraycopy(names, 0, tabNames, 0, tabNames.length);
	}

	private Map<String, Tab> tabs;

	public Map<String, Tab> getTabs() {
		return tabs;
	}

	public void setTabs(Map<String, Tab> tabs) {
		this.tabs = tabs;
	}
}

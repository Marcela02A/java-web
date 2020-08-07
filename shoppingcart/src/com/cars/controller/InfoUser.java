package com.cars.controller;

import java.util.ArrayList;
import java.util.List;

public class InfoUser {
	private String name;
	private String email;
	private String avatar;
	private List<Priority> all;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public InfoUser() {
		all = new ArrayList<Priority>();
	}

	public String get_name() {
		return name;
	}

	public void set_name(String _name) {
		this.name = _name;
	}

	public String get_email() {
		return email;
	}

	public void set_email(String _email) {
		this.email = _email;
	}

	public List<Priority> getAll() {
		return all;
	}

	public void addPriority(String description, int priority) {
		all.add(new Priority(description, priority));
	}

}
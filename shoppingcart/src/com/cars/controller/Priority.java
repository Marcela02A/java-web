package com.cars.controller;

public class Priority {
	private String description;
	private int priority;

	public Priority(String description, int priority) {
		super();
		this.description = description;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
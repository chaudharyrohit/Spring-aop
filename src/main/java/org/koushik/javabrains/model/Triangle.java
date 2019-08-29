package org.koushik.javabrains.model;

public class Triangle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		throw new RuntimeException();
		//return "returning "+name;
	}
}

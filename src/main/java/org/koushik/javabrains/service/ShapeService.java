package org.koushik.javabrains.service;

import org.koushik.javabrains.aspects.Loggable;
import org.koushik.javabrains.model.Circle;
import org.koushik.javabrains.model.Triangle;

public class ShapeService {
	private Triangle triangle;
	private Circle circle;
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	@Loggable
	public Circle getCircle() {
		System.out.println("Get circle called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
}

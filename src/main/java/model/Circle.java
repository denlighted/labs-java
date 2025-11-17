package model;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {
    private final double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle: " + this);
    }

    @Override
    public String toString() {
        return "Circle[color=" + shapeColor +
                ", radius=" + radius +
                ", area=" + calcArea() + "]";
    }
}

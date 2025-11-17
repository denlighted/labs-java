package model;

import java.io.Serializable;

public class Triangle extends Shape implements Serializable {
    private final double base;
    private final double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle: " + this);
    }

    @Override
    public String toString() {
        return "Triangle[color=" + shapeColor +
                ", base=" + base +
                ", height=" + height +
                ", area=" + calcArea() + "]";
    }
}

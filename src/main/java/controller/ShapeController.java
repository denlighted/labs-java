package controller;

import model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ShapeController {
    private Shape[] shapes;

    public ShapeController(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void displayAll() {
        for (Shape s : shapes) {
            s.draw();
        }
    }

    public double totalArea() {
        double sum = 0;
        for (Shape s : shapes) {
            sum += s.calcArea();
        }
        return sum;
    }

    public double totalAreaByType(Class<?> type) {
        double sum = 0;
        for (Shape s : shapes) {
            if (s.getClass() == type) {
                sum += s.calcArea();
            }
        }
        return sum;
    }

    public void sortByArea() {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));

    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(shapes);
            System.out.println("Shapes saved to file: " + filename);
        } catch (Exception e) {
            System.out.println("Error saving shapes: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            shapes = (Shape[]) ois.readObject();
            System.out.println("Shapes loaded from file: " + filename);
        } catch (Exception e) {
            System.out.println("Error loading shapes: " + e.getMessage());
        }
    }
}

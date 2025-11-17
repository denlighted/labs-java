package view;

import model.Shape;

public class ShapeView {
    public void printShapes(Shape[] shapes) {
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}

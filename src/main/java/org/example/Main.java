package org.example;

import controller.ShapeController;
import model.*;
import view.ShapeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle("Red", 2.0),
                new Rectangle("Blue", 3, 4),
                new Triangle("Green", 3, 5)
        };

        ShapeController controller = new ShapeController(shapes);
        ShapeView view = new ShapeView();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 – Display all shapes");
            System.out.println("2 – Total area");
            System.out.println("3 – Sort by area");
            System.out.println("4 – Sort by color");
            System.out.println("5 – Save shapes to file");
            System.out.println("6 – Load shapes from file");
            System.out.println("0 – Exit");
            System.out.print("Your choice: ");

            String c = sc.nextLine();

            switch (c) {
                case "1":
                    view.printShapes(controller.getShapes());
                    break;

                case "2":
                    System.out.println("Total area = " + controller.totalArea());
                    break;

                case "3":
                    controller.sortByArea();
                    view.printMessage("Sorted by area.");
                    break;

                case "4":
                    controller.sortByColor();
                    view.printMessage("Sorted by color.");
                    break;

                case "5":
                    System.out.print("Enter filename: ");
                    controller.saveToFile(sc.nextLine());
                    break;

                case "6":
                    System.out.print("Enter filename: ");
                    controller.loadFromFile(sc.nextLine());
                    view.printMessage("Shapes loaded:");
                    view.printShapes(controller.getShapes());
                    break;

                case "0":
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}

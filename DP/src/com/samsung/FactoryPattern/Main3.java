// Req 2
// Factory Method Pattern
package com.samsung.FactoryPattern;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3{

    //client
    public static void main(String[] args){

        //load the classes
        File folder = new File("./out/production/DP/com/samsung");
        String[] files = folder.list();
        for(String file: files){
            try {
                Class.forName("com.samsung." + file.split("\\.")[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("ClassNotFoundException:" + e.getMessage());
            }
        }

        while (true){
            // List names of shapes
            int index = 1;
            for (ShapeFactory factory: ShapeFactory.factories) {
                System.out.println(index + " " + factory.getName());
                index++;
            }

            // user selects on shape
            System.out.println("Select a Shape");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            // Shape object should be created
            Shape shape = ShapeFactory.factories.get(choice-1).getShape();

            // Specific Shape object should take its input
            shape.input();

            // Specific Shape object should draw the shape
            shape.draw();

            //for redraw store and redraw
        }
    }
}

interface Shape{
    void input();
    void draw();
}
abstract class ShapeFactory{
    abstract String getIcon();
    abstract String getName();
    abstract Shape getShape();

    static ArrayList<ShapeFactory> factories = new ArrayList<>();
    ShapeFactory(/* ShapeFactory this*/){
        factories.add(this);
    }
}

//-------------------------------------
class Circle implements Shape{
    private int cx, cy, radius;

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cx");
        cx = scanner.nextInt();

        System.out.println("Enter cy");
        cy = scanner.nextInt();

        System.out.println("Enter radius");
        radius = scanner.nextInt();
    }

    @Override
    public void draw() {
        System.out.println("Circle: " + cx + " " + cy + " " + radius);
    }
}
class CircleFactory extends ShapeFactory{
    static { new CircleFactory(); }
    String getIcon() {
        return "CircleIcon.jpg";
    }

    String getName() {
        return "Circle";
    }
    Shape getShape() {
        return new Circle();
    }
}

//-------------------------------------
class Rectangle implements Shape{
    private int left, right, height, width;

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter left");
        left = scanner.nextInt();

        System.out.println("Enter right");
        right = scanner.nextInt();

        System.out.println("Enter height");
        height = scanner.nextInt();

        System.out.println("Enter width");
        width = scanner.nextInt();
    }

    @Override
    public void draw() {
        System.out.println("Rectangle: " + left + " " + right + " " + height + " " + width);
    }
}
class RectangleFactory extends ShapeFactory{
    static { new RectangleFactory(); }
    String getIcon() {
        return "RectangleIcon.jpg";
    }

    String getName() {
        return "Rectangle";
    }
    Shape getShape(){
        return new Rectangle();
    }
}
//-------------------------------------
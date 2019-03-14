package com.samsung.MementoPattern;
// Memento pattern

// SOLID Principles
// SRP: Single Responsibility Principle

import java.util.Stack;

interface ObjectState{
    ObjectState undo();
}

abstract class Item{

    //state of the object
    private int x, y, width, height; // these are instance data members
    // Instance data members become part of sub-class object
    public int getX(/* Item this*/ ){ return this.x; }

    public int getY(/* Item this*/ ) {
        return this.y;
    }

    public int getWidth(/* Item this*/ ) { return this.width; }

    public int getHeight(/* Item this*/ ) {
        return this.height;
    }

    //constructor
    protected Item(/*Item this*/ int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Inner class
    private class Position implements ObjectState{

        //Instance Reference Variable; //Instance Data Member
        private int previousX, previousY; // Instance Data Member

        private Position(/* Position this */int previousX, int previousY){
            this.previousX = previousX;
            this.previousY = previousY;
        }

        @Override
        public ObjectState undo(/* Position this */) {
            return Item.this.move(this.previousX, this.previousY);
        }
    }

    //Inner Class
    private class Width implements ObjectState{
        //Item Reference Variable; //Instance Data Member
        private int previousWidth;
        private Width(/*Width this*/int previousWidth){
            this.previousWidth = previousWidth;
        }

        @Override
        public ObjectState undo() {
            return Item.this.changeWidth(previousWidth);
        }
    }

    //this helps in making late-bound call to implementation
    public abstract void draw();

    public ObjectState move(/*Item this*/int x, int y){
        Position position = this.new Position(this.x, this.y);
        this.x = x;
        this.y = y;
        this.draw();
        return position;
    }

    public ObjectState changeWidth(/*Item this*/ int width){
        Width w =  new Width(this.width);
        this.width = width; // capture
        this.draw();
        return w; // externalize
    }

}

class PC extends Item{
    private String color;

    public PC(/*PC this*/ int x, int y, int width, int height, String color){
        super(/* value of this*/x, y, width, height);
        this.color = color;
    }

    void changeColor(String color){
        this.color = color;
    }

    public void draw(/*PC this*/){
        System.out.println("PC:  " + this.getX()
                + " " + this.getY() + " " + this.getWidth() + " " + this.getHeight() + " " + this.color) ;
    }
}

class Windows extends Item{
    private boolean open;

    public Windows(/*Windows this*/ int x, int y, int width, int height, boolean open){
        super(/* value of this*/x, y, width, height);
        this.open = open;
    }

    public void draw(/*Windows this*/){
        System.out.println("Windows:  " + this.getX()
                + " " + this.getY() + " " + this.getWidth() + " " + this.getHeight() + " " + this.open) ;
    }

    public void toggle() {
        this.open = !this.open;
    }
}

class Door extends Item{
    private int angle;

    public Door(/*Door this*/ int x, int y, int width, int height, int angle){
        super(/* value of this*/x, y, width, height);
        this.angle = angle;
    }

    public void draw(/*Door this*/){
        System.out.println("Door:  " + this.getX()
                + " " + this.getY() + " " + this.getWidth() + " " + this.getHeight() + " " + this.angle) ;
    }

    public void rotate(int angle) {
        this.angle = angle;
    }
}

public class Main4 {
    public static void main(String[] args) {
        PC pc1 = new PC(1,1, 100, 100, "red");
        pc1.draw();

        Windows windows1 = new Windows(2,2,100, 100, true);
        windows1.draw();

        Door door1 = new Door(3, 3, 300 ,300, 45);
        door1.draw();

        Stack<ObjectState> states = new Stack<>();
        states.add(pc1.move(30, 30));

        states.add(windows1.move(40, 40));

        states.add(door1.move(50, 50));

        states.add(door1.changeWidth(500));

        states.pop().undo();
        states.pop().undo();
        states.pop().undo();
        states.pop().undo();
    }
}

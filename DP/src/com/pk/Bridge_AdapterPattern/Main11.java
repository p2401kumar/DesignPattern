package com.samsung.Bridge_AdapterPattern;

abstract class GraphicsLibrary{
    public abstract void drawRectangle(int x, int y, int width, int height);
    public abstract void drawText(int x, int y, String text);

    public static GraphicsLibrary graphicsLibrary;
    protected GraphicsLibrary(){
        graphicsLibrary = this;
    }
}

class DirectXAdapter extends GraphicsLibrary{
    static {new DirectXAdapter();}

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        System.out.println("Call into DirectX to draw Rectangle");
    }

    @Override
    public void drawText(int x, int y, String text) {
        System.out.println("Call into DirectX to draw Text");
    }
}

class OpenGLAdapter extends GraphicsLibrary{
    static {new OpenGLAdapter();}

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        System.out.println("Call into OpenGL to draw Rectangle");
    }

    @Override
    public void drawText(int x, int y, String text) {
        System.out.println("Call into OpenGL to draw Text");
    }
}

class Loader{
    public static void loadClass() {
        try{
            Class.forName("com.samsung.Bridge_AdapterPattern.OpenGLAdapter"); //hardcoded
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

abstract class UIControl {
    private GraphicsLibrary graphicsLibrary = null;

    protected UIControl(){
        graphicsLibrary = GraphicsLibrary.graphicsLibrary;
    }

    protected void drawRectangle(int x, int y, int width, int height) {
        graphicsLibrary.drawRectangle(x, y, width, height);
    }

    protected void drawText(int x, int y, String text) {
        graphicsLibrary.drawText(x, y, text);
    }
}

class Button extends UIControl {
    public void draw() {
        System.out.println("----------------Button Starts-----------------");
        drawRectangle(10, 10, 100, 100);
        drawText(10, 10, "Click");
        System.out.println("----------------Button Ends-----------------");
    }
}

class Grid extends UIControl {
    public void draw() {
        System.out.println("----------------grid Starts-----------------");
        drawRectangle(10, 10, 100, 100);
        drawRectangle(10, 10, 20, 20);
        drawText(10, 10, "Click");
        System.out.println("----------------grid Ends-----------------");
    }
}

public class Main11 {
    public static void main(String[] args) {
        Loader.loadClass();

        Button button = new Button();
        button.draw();

        Grid grid = new Grid();
        grid.draw();
    }
}

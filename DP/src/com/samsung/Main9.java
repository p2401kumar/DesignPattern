package com.samsung;

public class Main9 {
    public static void main(String[] args){
        Window w1 = new Window("w1");
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");

        w1.add(b1);
        w1.add(b2);

        w1.show();
        w1.hide();

        Panel p1 = new Panel("p1");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");

        p1.add(b3);
        p1.add(b4);

        w1.add(p1);
        w1.show();
        p1.hide();
        p1.show();

        w1.hide();
    }
}

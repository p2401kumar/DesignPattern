package com.samsung.CompositePattern;

import java.util.ArrayList;

//Marker Interface
interface NonComposable {

}

abstract class Component {
    private String name;

    public Component(/*Component this*/String name) {
        this.name = name;
    }

    public String getName(/*Component this*/) {
        return name;
    }

    public void show(/*Component this*/) {
        System.out.println(name + " show");
    }

    public void hide(/*Component this*/) {
        System.out.println(name + " hide");
    }
}

//every composite is a Component
abstract class Composite extends Component {
    ArrayList<Component> components = new ArrayList<>();

    public Composite(/*this*/String name) {
        super(name);
    }

    public void add(Component component) throws Exception {
        if (component instanceof NonComposable) {
            throw new Exception("Component is non-composable");
        }
        components.add(component);
    }

    public void show(/*Component this*/) {
        super.show(/*value of this*/);
        for (Component component : components) {
            component.show();
        }
    }

    public void hide(/*Component this*/) {
        super.hide(/*value of this*/);
        for (Component component : components) {
            component.hide();
        }
    }
}

class Window extends Composite implements NonComposable {
    public Window(String name) {
        super(name);
    }
}

class Panel extends Composite {
    public Panel(String name) {
        super(name);
    }
}

class Button extends Component {
    public Button(String name) {
        super(name);
    }
}

public class Main9 {
    public static void main(String[] args) {
        Window w1 = new Window("w1");
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");

        try {
            w1.add(b1);
            w1.add(b2);

            w1.show();
            System.out.println("----------------");
            w1.hide();
            System.out.println("----------------");

            Panel p1 = new Panel("p1");
            Button b3 = new Button("b3");
            Button b4 = new Button("b4");

            p1.add(b3);
            p1.add(b4);

            w1.add(p1);
            w1.show();
            System.out.println("----------------");
            p1.hide();
            System.out.println("----------------");
            w1.show();
            System.out.println("----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

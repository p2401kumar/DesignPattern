package com.samsung.BuilderPattern;

class Canvas {

}

interface ClockBuilder {

    void drawFace();

    void drawNumber();

    void drawTime();

    Canvas build();
}

class ClockBuilder1 implements ClockBuilder {
    Canvas canvas = new Canvas();

    @Override
    public void drawFace() {
    }

    @Override
    public void drawNumber() {
    }

    @Override
    public void drawTime() {
    }

    @Override
    public Canvas build() {
        drawFace();
        drawNumber();
        drawTime();
        return canvas;
    }
}

class ClockBuilder2 implements ClockBuilder {
    Canvas canvas = new Canvas();

    @Override
    public void drawFace() {
    }

    @Override
    public void drawNumber() {
    }

    @Override
    public void drawTime() {
    }

    @Override
    public Canvas build() {
        drawFace();
        drawNumber();
        drawTime();
        return canvas;
    }
}

class Clock {
    public void create(ClockBuilder clockBuilder) {
        Canvas canvas = clockBuilder.build();
    }
}

public class Main15 {
    public static void main(String[] args) {

        ClockBuilder1 clockBuilder1 = new ClockBuilder1();
        ClockBuilder2 clockBuilder2 = new ClockBuilder2();

        Clock clock = new Clock();
        clock.create(clockBuilder1);
    }
}

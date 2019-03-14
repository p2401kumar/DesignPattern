package com.samsung.ObserverPattern;

import java.util.ArrayList;

@FunctionalInterface()
interface Capturable {
    void send(int count);
}

class CameraDeviceDriverSimulator {

    private Thread secondaryThread;
    private boolean flag;
    private Capturable capturable;

    public CameraDeviceDriverSimulator(Capturable capturable) {
        this.capturable = capturable;
    }

    public void start() { // MT
        flag = true;
        secondaryThread = new Thread(() -> {
            startLoop();
        });
        secondaryThread.start(); // MT starts ST
    }

    public void stop() { // MT
        flag = false; // MT
        secondaryThread = null; // MT
    }

    private void startLoop() { //Secondary Thread
        int count = 1;
        while (flag) { // ST
            this.capturable.send(count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // TODO: Log the Exception
            }
            count++;
        } //ST
    } // ST
}

@FunctionalInterface()
interface EventListener {
    void send(Object data);
}

class Event {
    private ArrayList<EventListener> cameraFeedListeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        synchronized (listener){
            cameraFeedListeners.add(listener);
        }
    }

    public void removeListener(EventListener listener) {
        synchronized (listener){
            cameraFeedListeners.remove(listener);
        }
    }

    public void raiseEvent(Object data) {
        for (EventListener listener : cameraFeedListeners) {
            listener.send(data);
        }
    }
}

class Camera {
    private Event CameraFeedEvent = new Event();
    public Event getCameraFeedEvent(){
        return CameraFeedEvent;
    }
    private Event CameraNoFeedEvent = new Event();
    public Event getCameraNoFeedEvent(){
        return CameraNoFeedEvent;
    }

    // C++ Device Driver Object
    CameraDeviceDriverSimulator cameraDeviceDriverSimulator;

    private Camera() {
        cameraDeviceDriverSimulator = new CameraDeviceDriverSimulator((count) -> {
            CameraFeedEvent.raiseEvent(count);
        });
        cameraDeviceDriverSimulator.start();
    }

    private static Object sync = new Object(); // will used only for Synchronization
    private static Camera camera = null;

    public static Camera get() {

        //Double check pattern, both if are important here to maintain concurrency and speed
        if (camera == null) {
            synchronized (sync) {
                if (camera == null)
                    camera = new Camera();
            }
        }
        return camera;
    }
}

class SaveToHardDisk {
    public SaveToHardDisk() {
        Camera.get().getCameraFeedEvent().addListener((count) -> {

        });
    }
}

class Stream {
    public Stream() {
        Camera.get().getCameraFeedEvent().addListener((count) -> {

        });
    }
}

class Ring911 {
    public Ring911() {
        Camera.get().getCameraFeedEvent().addListener((count) -> {

        });
    }
}

class Alarm {
    public Alarm() {
        Camera.get().getCameraFeedEvent().addListener((count) -> {

        });
    }
}

//ConsoleUI
class ConsoleUI {

}

//GraphicalUI

//ServeLet / Spring MVC Controller

public class Main6 {
    public static void main(String[] args) {
        Camera camera = Camera.get();
    }
}

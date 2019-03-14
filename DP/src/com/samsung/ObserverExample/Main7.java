package com.samsung.ObserverExample;

import java.util.ArrayList;

@FunctionalInterface()
interface ClickListener{
    void onClick();
}

class ClickEvent{
    ArrayList<ClickListener> clickListeners = new ArrayList<>();
    public void addListener(ClickListener clickListener){
        clickListeners.add(clickListener);
    }

    public void removeListener(ClickListener clickListener){
        clickListeners.remove(clickListener);
    }

    public void notifyClick(){
        for (ClickListener clickListener: clickListeners) {
            clickListener.onClick();
        }
    }
}
class Button{
    private ClickEvent clickEvent = new ClickEvent();
    public ClickEvent getClickEvent(){
        return clickEvent;
    }

    public void click(){
        clickEvent.notifyClick();
    }
}
class Window{
    Button b1 = new Button();
    Button b2 = new Button();

    public Window(){
        b1.getClickEvent().addListener(()->{
            System.out.println("button 1 clicked");
        });

        b2.getClickEvent().addListener(()->{
            System.out.println("button 2 clicked");
        });
    }

    public void callButtonClick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    b1.click();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b2.click();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
public class Main7 {
    public static void main(String[] args){
        Window window = new Window();
        window.callButtonClick();
    }
}

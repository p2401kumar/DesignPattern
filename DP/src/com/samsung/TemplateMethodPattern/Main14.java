package com.samsung.TemplateMethodPattern;

class Queue{
    public void doWork(String text){

    }

    public void receiveData(String text){
        //here it will check time duration between 2 different strings
        doWork(text);
    }
}

class Prescription extends Queue{
    public void doWork(String text){

    }
}

class Medicine extends Queue{
    public void doWork(String text){

    }
}
public class Main14 {
    public static void main(String[] args){

    }
}

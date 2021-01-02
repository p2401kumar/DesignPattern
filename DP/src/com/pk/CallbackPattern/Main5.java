package com.samsung.CallbackPattern;


@FunctionalInterface //such interfaces are for callback only
interface ResultCallback{
    void send(int number, int i, int result); //only one method
}

class Utility {
    // Callee
    public static void multiplicationTable(int number, ResultCallback callback) {
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            // callback to caller and give the data to the caller
            callback.send(number, i, result);
        }
    }
}

public class Main5 {

    // Caller
    public static void main(String[] args) {
        Utility.multiplicationTable(5, (number, i, result)->{

        });
        Utility.multiplicationTable(6, new ResultCallback() {
            @Override
            public void send(int number, int i, int result) {

            }
        });
        Utility.multiplicationTable(7, new Receiver());
    }
}

class Receiver implements ResultCallback{

    @Override
    public void send(int number, int i, int result) {

    }
}
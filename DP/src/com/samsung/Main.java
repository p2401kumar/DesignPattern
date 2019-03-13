package com.samsung;

//New Data Type - 1
class Stack{
    //Instance Data Members - 2
    int[] items = new int[10];
    int top = 0;

    //Instance Method - 3
    void push(/*com.samsung.Stack this*/ int item) {
        items[top] = item; //this.items[this.top] = item;
        top++; // this.top++;
    }

    int pop(/*com.samsung.Stack this*/){
        top--; //this.top--;
        return items[top]; //this.items[this.top];
    }
}

public class Main {

    public static void main(String[] args) {
        Stack s1 = new Stack();
        //s1 is a reference variable
        //s1 hold reference of the first instance

        s1.push(100); //push (value of s1, 100);

        Stack s2 = new Stack();
        //s2 is a reference variable
        //s2 hold reference of the first instance
        s2.push(1000); //push (value of s2, 100);

        Stack s3 = new Stack();
        //s3 is a reference variable
        //s3 hold reference of the first instance
    }
}

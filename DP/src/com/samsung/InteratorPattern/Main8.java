package com.samsung.InteratorPattern;

import java.util.*;

class ListBox{

    public void display(Iterable<String> iterable) {
        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class MyCollection implements Iterable<String>{
    String a1 = "S1", b1 = "S2", c1 = "S3";
    String[] arr = new String[10];
    int size = 0;

    private class MyCollectionterator implements Iterator<String>{
        private int index = 1;

        @Override
        public boolean hasNext() {
            return index < 4;
        }

        @Override
        public String next() {
            if(index == 1){
                index = 2;
                return a1;
            } else if(index == 2){
                index = 3;
                return b1;
            } else if(index == 3){
                index = 4;
                return c1;
            } else {
                return null;
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new MyCollectionterator();
    }

    public void add(String s1) {
        arr[size++] = s1;
    }
}
public class Main8 {

    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        names.add("A1");
        names.add("A2");
        names.add("A3");
        names.add("A4");

        LinkedList<String> countries = new LinkedList<>();
        countries.add("C1");
        countries.add("C2");
        countries.add("C3");
        countries.add("C4");

        MyCollection states = new MyCollection();
        states.add("S1");
        states.add("S2");
        states.add("S3");
        states.add("S4");
        states.add("S5");

        ListBox lb = new ListBox();
        lb.display(names);
        lb.display(countries);
        lb.display(states);
    }
}

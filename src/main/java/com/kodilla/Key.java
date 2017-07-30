package com.kodilla;

import java.util.*;

class Key {
    private int index;

    public Key(int index){
        this.index = index;
    }

    public boolean equals(Object o){
        final Key e = (Key) o;
        return index == e.index;
    }

    public int hashCode(){
        return index;
    }

    public int getIndex() {
        return index;
    }
}

    class Value extends Key {
        public Value(int index) {
            super(index);
        }
    }

class SpeedTest {
    public static void main (String[] ars) {

        //Creating LinkedList
        List<Integer> theBigList = new LinkedList<Integer>();
        for(int i = 0; i < 3000000; i++){
            theBigList.add(theBigList.size());
        }

        //Removing element at the beginning of the collection
        long begin = System.nanoTime();
        int firstElement = theBigList.get(0);
        theBigList.remove(firstElement);
        long end = System.nanoTime();

        System.out.println("Removing element at the begining of the collection has taken "
                + (end - begin) + "ns");

        //Removing element at the end of the collection
        begin = System.nanoTime();
        theBigList.remove(theBigList.size()-1);
        end = System.nanoTime();

        System.out.println("Removing element at the end of the collection has taken "
                + (end - begin) + "ns");

        //Adding element at the beginnig of the collection
        begin = System.nanoTime();
        theBigList.add(0, 0);
        end = System.nanoTime();

        System.out.println("Adding element at the beggining of the collection has taken "
                + (end - begin) + "ns");

        //Adding element at the end of the collection
        begin = System.nanoTime();
        theBigList.add(theBigList.size(), 3000001);
        end = System.nanoTime();

        System.out.println("Adding element at the end of the collection has taken " +
                (end - begin) + "ns");

        Map<Key, Value> myMap = new HashMap<>();
        for(int i=0; i<300000; i++) {
            myMap.put(new Key(i), new Value(i));
            }

        Random theGenerator = new Random();

        //Searching for the random key
        begin = System.nanoTime();
        myMap.get(new Key(theGenerator.nextInt(myMap.size())));
        end = System.nanoTime();

        System.out.println("Searching for random key has taken: " + (end - begin) + "ns");

        //Adding new entry to the HashMap
        begin = System.nanoTime();
        myMap.put(new Key(-100), new Value(theGenerator.nextInt(myMap.size())));
        end = System.nanoTime();

        System.out.println("Adding new entry to the HashMap has taken: " + (end - begin) + "ns");

        //Removing the random entry from the HashMap
        begin = System.nanoTime();
        myMap.remove(new Key(theGenerator.nextInt(myMap.size())));
        end = System.nanoTime();

        System.out.println("Removing random key from the HashMap has taken: " + (end - begin) + "ns");
    }
}


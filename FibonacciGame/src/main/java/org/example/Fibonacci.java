package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fibonacci {
    protected ArrayList<Integer> fibList = new ArrayList<Integer>();

    public Fibonacci(){
        createFibIndex();
        printList();
        //System.out.println("weee from constructor");
    }

    private void printList(){
        System.out.println("Array length :" + fibList.size());
        for (int i = 0 ; i < fibList.size() ; i++){
            System.out.println("Printing array index " + i + " as " +fibList.indexOf(i));
            System.out.println("i just printed array index " + i);
            //System.out.println("WEEEEEE from print method");
        }
    }

    private void createFibIndex(){
        int previous = 0 , current = 1 , next = 0 ;      // 1
        for (int i = 0 ; i<100 ; i++){
            if (current <= 100){
                fibList.add(i , current); // Add current to List if below 100
                System.out.println("Just added " + current + " to index " + i);
                previous = current; // move current to previous
                System.out.println("In loop " + i + " , Previous=" + previous + " Current=" + current);
                current = current + previous;// get new current by sum of old current and previous current
                System.out.println("New Current=" + current);
            }
            else{
                break;
            }
        }
    }
}


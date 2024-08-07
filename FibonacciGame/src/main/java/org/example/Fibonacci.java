package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fibonacci {
    private ArrayList<Integer> fibList = new ArrayList<Integer>();

    public Fibonacci(){
        fibList = createFibIndex();
        printList(fibList);
    }

    private void printList(ArrayList fibList){
        for (int i = 0 ; i < fibList.size() ; i++){
            System.out.println(fibList.get(i));
            System.out.println("WEEEEEE");
        }
    }

    private ArrayList createFibIndex(){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        int previous = 0 , current = 1 , next = 0 ;      // 1
        for (int i = 1 ; i<100 ; i++){
            if (current <= 100){
                fibList.add(current); // Add current to List if below 100
                previous = current; // move current to previous
                current = current + previous;// get new current by sum of old current and previous current
            }
            else{
                break;
            }

        }
        return newList;
    }
}


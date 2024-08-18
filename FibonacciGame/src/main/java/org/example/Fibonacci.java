package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fibonacci {

    protected ArrayList<Integer> fibList = new ArrayList<Integer>();

    public void printList(){// print the fibonacci array , more for debug
        setList();
        System.out.println("Recieved Array length:" + fibList.size() );
        for (int i = 0; i < fibList.size(); i++) {
            System.out.println(fibList.get(i));
        }
    }

    private void setList(){ //populate an array with the fibonacci sequence
        int previous = 0 , current = 1 , next = 0 ;      // 1
        for (int i = 0 ; i<100 ; i++){
            if (current <= 100){
                fibList.add(i , current); // Add current to List if below 100
                previous = current; // move current to previous
                current = current + previous;// get new current by sum of old current and previous current
            }
            else{
                break;
            }
        }
    }

    public ArrayList getList(){ //simply to pass the generated list , calls setList to ensure always populated
        setList();
        return fibList;
    }

}


package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Machine {
    private int guessNum = 0 ;
    private boolean fibTrueFalse = false , userAnswer = false;
    private ArrayList<Integer> fibIndex =new ArrayList<Integer>();

    public Machine(ArrayList fibIndex){
        this.fibIndex = fibIndex;
        Random random = new Random(90);
        guessNum = (random.nextInt() + 10); //generate guess num
        isFibonacci(guessNum, fibIndex); //determine if it is a fibonacci
    }

    private void isFibonacci(int guess , ArrayList fibIndex){
        if (fibIndex.contains(guess)){
            fibTrueFalse = true;
        }else {
            fibTrueFalse = false; //Ensure program works correctly if implementing loop
        }
    }




}

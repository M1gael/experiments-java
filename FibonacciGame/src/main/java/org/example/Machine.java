package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Machine {
    protected int guessNum = 0 ;
    protected ArrayList<Integer> fibIndex =new ArrayList<Integer>();

    public Machine(){
        Random random = new Random(90);
        guessNum = (random.nextInt() + 10); //generate guess num
        getFibIndex(); //get list from Fib class
        isFibonacci(); //determine if the random number is part of the sequence
    }

    private void getFibIndex (){
        Fibonacci newList = new Fibonacci();
        fibIndex =  newList.getList();
    }

    private boolean isFibonacci(){
        if (fibIndex.contains(guessNum)){
            return true;
        }else {
            return false; //Ensure program works correctly if implementing loop
        }
    }

    public String printAnswer(boolean userAnswer){
        if (isFibonacci() == userAnswer){
            return "Correct , the number " + guessNum + " is infact part of the fibonacci sequence.";
        }else{
            return  "Incorrect";
        }
    }


}

package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Machine {
    protected int guessNum = 0 ;
    protected ArrayList<Integer> fibIndex =new ArrayList<Integer>();
    Fibonacci fibonacci = new Fibonacci();

    Random random = new Random();

    public Machine(){
    }

    private void getValues (){// get values for Fib array and random int
        fibIndex =  fibonacci.getList();
        guessNum = (random.nextInt(90) + 10); //generate guess num
    }

    private boolean isFibonacci(){ // determine if the random int is part of the sequence
        if (fibIndex.contains(guessNum)){
            return true;
        }else {
            return false; //Ensure program works correctly if implementing loop
        }
    }

    public String printGuess(){//print a string displaying the generated guess int
        getValues();
        return "Is the number " + guessNum + " , part of the Fibonacci sequence?";
    }

    public String printAnswer(boolean userAnswer){ // determine if user guess equals isFibonacci method to be correct
        if (isFibonacci() == userAnswer){
            return "Correct";
        }else{
            return  "Incorrect";
        }
    }



}

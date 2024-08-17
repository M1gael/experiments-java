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

    private void getValues (){
        fibIndex =  fibonacci.getList();
        guessNum = (random.nextInt(90) + 10); //generate guess num
    }

    private boolean isFibonacci(){
        if (fibIndex.contains(guessNum)){
            return true;
        }else {
            return false; //Ensure program works correctly if implementing loop
        }
    }

    public String printGuess(){
        getValues();
        return "Is the number " + guessNum + " , part of the Fibonacci sequence?";
    }

    public String printAnswer(boolean userAnswer){
        if (isFibonacci() == userAnswer){
            return "Correct";
        }else{
            return  "Incorrect";
        }
    }



}

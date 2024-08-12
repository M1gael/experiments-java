package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Machine {
    protected int guessNum = 0 ;
    protected boolean fibTrueFalse = false , userAnswer = false;
    protected ArrayList<Integer> fibIndex =new ArrayList<Integer>();

    public Machine(){
        Random random = new Random(90);
        guessNum = (random.nextInt() + 10); //generate guess num
        isFibonacci();
    }

    private void getFibIndex (){
        Fibonacci newList = new Fibonacci();
        fibIndex =  newList.getList();
    }

    private void isFibonacci(){
        if (fibIndex.contains(guessNum)){
            fibTrueFalse = true;
        }else {
            fibTrueFalse = false; //Ensure program works correctly if implementing loop
        }
    }

    public void setBotResponse(){
        if (fibTrueFalse == userAnswer){
            System.out.println("Correct , the number " + guessNum + " is infact part of the fibonacci sequence." );
        }else{
            System.out.println("Incorrect");
        }
    }


}

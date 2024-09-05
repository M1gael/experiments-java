package org.sqlCRUDapp;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String name = "" , email = ""  , loopChoice = "";
        int id = 0 , age = 0 ;
        boolean again = true;
        Scanner kb = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();


        do { //for(int i = 0 ; i<1 ;){

            System.out.println("Would you like to :" +
                    "\n 1: Make a new entry to the database." +
                    "\n 2: Update an entry name." +
                    "\n 3: Remove an entry." +
                    "\n 4: Retrive all information on an entry." +
                    "\n 5: EXIT");
            loopChoice = kb.next();

            switch (loopChoice){
                case  "1" :
                    System.out.println("Enter Name :");
                    name = kb.next();
                    System.out.println("Enter Age :");
                    age = kb.nextInt();
                    System.out.println("Enter Email :");
                    email = kb.next();
                    //System.out.println(name + age + email);//Debug
                    studentDAO.addStudent(name , age , email);
                    break;

                case  "2" :
                    System.out.println("Case 2");
                    break;

                case  "3" :
                    System.out.println("Case 3");
                    break;

                case  "4" :
                    System.out.println("Case 4");
                    break;

                case  "5" :
                    //i++;
                    again = false;
                    break;

            }
        }while(again == true);
    }
}

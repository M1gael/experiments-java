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
                    "\n 4: Retrive all information on Table." +
                    "\n 5: EXIT");
            loopChoice = kb.next();

            switch (loopChoice){
                case  "1" : //New entry
                    System.out.println("Enter Name :");
                    name = kb.next();
                    System.out.println("Enter Age :");
                    age = kb.nextInt();
                    System.out.println("Enter Email :");
                    email = kb.next();
                    studentDAO.addStudent(name , age , email);
                    break;

                case  "2" : //Update name
                    System.out.println("Enter Student Name of the Row you want Modified:");
                    name = kb.next();
                    System.out.println("Enter the New Student Name:");
                    String newName = kb.next();
                    studentDAO.updateStudentName(name,newName);
                    break;

                case  "3" :// Remove entry
                    System.out.println("Enter Student Name of the Row you want Removed:");
                    name = kb.next();
                    studentDAO.deleteStudent(name);
                    break;

                case  "4" :// Retrieve info
                    studentDAO.displayWholeTable();
                    break;

                case  "5" ://Exit
                    //i++;
                    again = false;
                    break;

            }
        }while(again == true);
    }
}

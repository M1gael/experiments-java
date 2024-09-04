package org.sqlCRUDapp;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String name = "" , email = "" ;
        int id = 0 , age = 0 ;
        boolean again = true;
        StudentDAO studentDAO = new StudentDAO();


        while (again = true){

            System.out.println("Would you like to :" +
                    "\n 1: Make a new entry to the database." +
                    "\n 2: Update an entry name." +
                    "\n 3: Remove an entry." +
                    "\n 4: Retrive all information on an entry." +
                    "\n 5: EXIT");

            Scanner kb = new Scanner(System.in);

            switch (kb.nextLine()){
                case  "1" :
                    System.out.println("Enter Name :");
                    name = kb.nextLine();
                    System.out.println("Enter Age :");
                    age = kb.nextInt();
                    System.out.println("Enter Email :");
                    email = kb.nextLine();
                    studentDAO.addStudent(name , age , email);
                    break;
                case  "5" :
                    again = false;
            }
            kb.close();
        }
    }
}

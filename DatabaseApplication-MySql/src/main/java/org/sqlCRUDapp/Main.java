package org.sqlCRUDapp;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        try {
            // Create
            studentDAO.addStudent();
            // Read
            // Update
            // Delete
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

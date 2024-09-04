package org.sqlCRUDapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class studentDAO {

    public void addStudent(String name , int age , String email) throws SQLException{

        String sql = "INSERT INTO students (name , age , email) VALUES (? , ? , ?)"; //Debug

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(1 , name);
                pstmt.setInt(2 , age);
                pstmt.setString(3 , email);

                pstmt.executeUpdate();
            }
    }

    public void getStudent() throws SQLException{

        String sql  = "SELECT * FROM students";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-----");
            }
        }
    }

    public void updateStudent() throws SQLException {

        String sql = "UPDATE students SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1 , name);
            pstmt.setInt(2 , id);

            pstmt.executeUpdate();
        }
    }

    public void deleteStudent() throws SQLException{

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.preparedStatement(sql)){

            pstmt.setInt(1 , id);

            pstmt.executeUpdate();
        }
    }


}

package org.sqlCRUDapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO {

    private String sql ="";

    public void addStudent(String name , int age , String email){

        sql = "INSERT INTO student (name , age , email) VALUES (? , ? , ?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(1 , name);
                pstmt.setInt(2 , age);
                pstmt.setString(3 , email);

                pstmt.executeUpdate();
            }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudent(String name , int age , String email) throws SQLException{

        sql  = "SELECT * FROM students";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-----");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentName(String name ,String newName){

        sql = "UPDATE student SET name = ? WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1 , newName);
            pstmt.setString(2 , name);

            pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String name){

        sql = "DELETE FROM student WHERE name = ?";

        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //pstmt.setInt(1 , name);

            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayWholeTable(){
        sql = "SELECT * FROM student;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();){

            while (rs.next()){
                System.out.println("\n ===============");
                System.out.println("Row ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("age: " + rs.getInt("age")+ "\n");
            }
        }catch (SQLException e){

        }
    }




}

package com.example.finalproject;

import java.sql.*;

public class DatabaseManager {
    //მონაცემთა ბაზის მისამართი
    private static final String TABLE_NAME = "students";
    private static final String URL = "jdbc:mysql://localhost:3306/" + TABLE_NAME;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    //მონაცემთა ბაზაში ინფორმაციის განახელბა(update)
    public boolean update(User user){
        int status =0;
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps= conn.prepareStatement("UPDATE students set email=?, psw=?, confirmPsw=?,firstName=?, surname=?, profession=? where email=? ")  ;
            ps .setString(1, user.getEmail());
            ps.setString(2, user.getPsw());
            ps.setString(3, user.getConfirmPsw());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getSurname());
            ps.setString(6, user.getProfession());
            ps.setString(7, user.getEmail());
            status = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e);
        }
        return status>0;
    }

    public boolean login(User user){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String query = ("select * from students where email=? and psw=?");
            PreparedStatement PreparedStatement = conn.prepareStatement(query);
            PreparedStatement.setString(1, user.getEmail());
            PreparedStatement.setString(2, user.getPsw());
            ResultSet rs = PreparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //ბაზაში მონაცემების შეყვანა
    public void insert(User user) {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "INSERT INTO students(email, psw, confirmPsw, firstName, surname, profession) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement PreparedStatement = conn.prepareStatement(query);
            PreparedStatement.setString(1, user.getEmail());
            PreparedStatement.setString(2, user.getPsw());
            PreparedStatement.setString(3, user.getConfirmPsw());
            PreparedStatement.setString(4, user.getFirstName());
            PreparedStatement.setString(5, user.getSurname());
            PreparedStatement.setString(6, user.getProfession());

            PreparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e);
        }
    }


    //ბაზაში მონაცემების შემოწმება, არსებობს თუ არა რეგისტრაციის დროს შეყვანილი მეილი ბაზაში
    public boolean userExists(String existedEmail) throws SQLException {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "select count(email) as total from students where email=?";
            PreparedStatement PreparedStatement = conn.prepareStatement(query);
            PreparedStatement.setString(1, existedEmail);
            ResultSet rs = PreparedStatement.executeQuery();
            rs.next();
            return rs.getInt("total") > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

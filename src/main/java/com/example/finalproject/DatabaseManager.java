package com.example.finalproject;

import java.sql.*;

public class DatabaseManager {    //მონაცემთა ბაზის მისამართი

    private static final String TABLE_NAME = "students";
    private static final String URL = "jdbc:mysql://localhost:3306/" + TABLE_NAME;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public void update(User user){     //მონაცემთა ბაზაში ინფორმაციის განახელბა(update)


        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SET SQL_SAFE_UPDATES = 0";
            String query = "UPDATE students SET email=?, psw=?, confirmPsw=?,firstName=?, surname=?, profession=? WHERE email=?";
            PreparedStatement PreparedStatement= conn.prepareStatement(select + query);
            PreparedStatement.setString(1, user.getEmail());
            PreparedStatement.setString(2, user.getPsw());
            PreparedStatement.setString(3, user.getConfirmPsw());
            PreparedStatement.setString(4, user.getFirstName());
            PreparedStatement.setString(5, user.getSurname());
            PreparedStatement.setString(6, user.getProfession());
            PreparedStatement.setString(7, user.getEmail());
            PreparedStatement.executeUpdate(select + query);
        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e);
        }
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

    public void insert(User user) {    //ბაზაში მონაცემების შეყვანა/რეგისტრაცია
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


    //ბაზაში მეილის შემოწმება, არსებობს თუ არა რეგისტრაციის დროს შეყვანილი მეილი ბაზაში
    public boolean userExists(String existedEmail) throws SQLException {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "select count(email) as total from students where email=?"; //ბაზაში ითვლის შეყვანილი მეილის რაოდენობას და აბრუნებს ინტს, პასუხი ყოველთვის იქნება 0 ან 1
            PreparedStatement PreparedStatement = conn.prepareStatement(query);
            PreparedStatement.setString(1, existedEmail);
            ResultSet rs = PreparedStatement.executeQuery();

            rs.next();
            return rs.getInt("total") > 0; //1-ის დაბრუნების შემთხვევაში აბრუნებს false-ს.
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

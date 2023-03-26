package com.example.finalproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        String firstName = request.getParameter("firstName");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","1234");
            String query = ("select * from students where email=? and psw=?");
            PreparedStatement PreparedStatement = conn.prepareStatement(query);
            PreparedStatement.setString(1, email);
            PreparedStatement.setString(2, psw);
            ResultSet rs = PreparedStatement.executeQuery();
            if(rs.next()){
                RequestDispatcher dispatcher = request.getRequestDispatcher("userPage.jsp");
                request.setAttribute("email",email);
                request.setAttribute("psw", psw);
                request.setAttribute("firstName",firstName);
                dispatcher.forward(request,response);
            } else {
                RequestDispatcher dp = request.getRequestDispatcher("loginError.jsp");
                dp.forward(request,response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

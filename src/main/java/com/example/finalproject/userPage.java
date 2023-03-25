package com.example.finalproject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "userPage", value = "/userPage")
public class userPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        String confirmPsw = request.getParameter("repeatPassword");
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String profession = request.getParameter("profession");
        RequestDispatcher dispatcher;

        DatabaseManager students = new DatabaseManager();
        User user = new User();

        try{
            if(!psw.equals(confirmPsw)){
                dispatcher = request.getRequestDispatcher("userPageError.jsp");
                dispatcher.forward(request,response);
            } else {
                user.setEmail(email);
                user.setPsw(psw);
                user.setConfirmPsw(confirmPsw);
                user.setFirstName(firstName);
                user.setSurname(surname);
                user.setProfession(profession);
                students.update(user);

                dispatcher = request.getRequestDispatcher("userPage.jsp");
                request.setAttribute("email", email);
                request.setAttribute("psw", psw);
                request.setAttribute("confirmPsw", confirmPsw);
                request.setAttribute("firstName", firstName);
                request.setAttribute("surname", surname);
                request.setAttribute("profession", profession);
                dispatcher.forward(request,response);
            }
        }
        catch (Exception e){
            System.err.println("Got an exception");
            System.err.println(e);
        }

    }
}


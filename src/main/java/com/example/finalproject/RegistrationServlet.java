package com.example.finalproject;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(name = "registrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        String confirmPsw = request.getParameter("repeatPassword");
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String profession = request.getParameter("profession");

        User user = new User();
        DatabaseManager students = new DatabaseManager();
        RequestDispatcher dispatcher;

        try{
            if(!psw.equals(confirmPsw)){
                dispatcher = request.getRequestDispatcher("registrationError.jsp");
                dispatcher.forward(request,response);
            } else if (students.userExists(email)){
                dispatcher = request.getRequestDispatcher("registrationError.jsp");
                dispatcher.forward(request,response);
            }else {
                user.setEmail(email);
                user.setPsw(psw);
                user.setConfirmPsw(confirmPsw);
                user.setFirstName(firstName);
                user.setSurname(surname);
                user.setProfession(profession);
                students.insert(user);
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

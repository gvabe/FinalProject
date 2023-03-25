package com.example.finalproject;


public class User {
    private String email;
    private String psw;
    private String confirmPsw;
    private String firstName;
    private String surname;
    private String profession;

    public User(String email, String psw, String confirmPsw, String firstName, String surname, String profession) {
    }


    public void setEmail(String email){this.email = email;}
    public void setPsw(String psw){this.psw = psw;}
    public void setConfirmPsw(String confirmPsw){this.confirmPsw = confirmPsw;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setProfession(String profession){this.profession = profession;}
    public String getEmail(){return email;}
    public String getPsw(){return psw;}
    public String getConfirmPsw(){return confirmPsw;}

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }
    public String getProfession(){return profession;}

    public User(String email, String psw) {

    }
    public User(){

    }
}


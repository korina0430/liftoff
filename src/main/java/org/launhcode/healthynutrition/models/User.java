package org.launhcode.healthynutrition.models;

import javax.persistence.*;

@Entity
public class Register {

    private String user_fname;
    private String user_lname;
    @Id
    private String user_email;
    private String user_pass;

//    private int id;


    public Register(){}

    public Register(String user_fname, String user_lname, String user_email, String user_pass, int id) {
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_email = user_email;
        this.user_pass = user_pass;
//        this.id = id;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public String getUser_fname() {
        return user_fname;
    }
    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }
    public String getUser_lname() {
        return user_lname;
    }
    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_pass() {
        return user_pass;
    }
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

//    @Override
//    public String toString() {
//        return "User [id=" + ", user_fname=" + user_fname + ", user_lname=" + user_lname + ", user_email="
//                + user_email + ", user_pass=" + user_pass + "]";
//    }


}


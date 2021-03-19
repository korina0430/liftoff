package org.launhcode.healthynutrition.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class User {

    @NotNull
    private String user_fname;
    private String user_lname;
    @Id
    @Email
    private String user_email;
    @NotNull
    private String user_pass;
    private String user_repass;
//    private int id;


    public User(){}

    public User(String user_fname, String user_lname, String user_email, String user_pass, int id) {
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_email = user_email;
        this.user_pass = user_pass;
        this.user_repass = user_repass;
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

    public String getUser_repass() {return user_repass;}
    public void setUser_repass(String user_repass) {this.user_repass = user_repass;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUser_pass(), user.getUser_pass()) &&
                Objects.equals(getUser_repass(), user.getUser_repass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_pass(), getUser_repass());
    }


    //    @Override
//    public String toString() {
//        return "User [id=" + ", user_fname=" + user_fname + ", user_lname=" + user_lname + ", user_email="
//                + user_email + ", user_pass=" + user_pass + "]";
//    }


}


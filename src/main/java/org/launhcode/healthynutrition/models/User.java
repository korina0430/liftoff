//package org.launhcode.healthynutrition.models;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
///**
// * Represents a row in the user table in the database.
// */
//
//@Table(name = "user")
//public class User {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @NotNull
//    private int id;
//
//    @NotNull
//    private String password;
//
//    @Column(unique = true)
//    @NotNull
//    private String username;
//
//    public User(){}
//
//    public User(@NotNull String username, @NotNull String password) {
//        this.password = password;
//        this.username = username;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}
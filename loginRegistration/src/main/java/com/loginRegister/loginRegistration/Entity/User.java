package com.loginRegister.loginRegistration.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "my_app_user")
public class User {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "username", length = 255)
    private String userName;

    @Column(name = "password",length = 255)
    private String passWord;

    @Column(name = "email",length = 255)
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int userId, String userName, String passWord, String email) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(email, user.email);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, passWord, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User() {
    }
}

package com.loginRegister.loginRegistration.DTO;

import org.springframework.stereotype.Component;

@Component
public class LoginDto {

    private String passWord;
    private String email;

    public LoginDto() {
    }

    public LoginDto(String passWord, String email) {
        this.passWord = passWord;
        this.email = email;
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
}

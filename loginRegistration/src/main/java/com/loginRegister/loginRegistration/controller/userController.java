package com.loginRegister.loginRegistration.controller;


import com.loginRegister.loginRegistration.DTO.LoginDto;
import com.loginRegister.loginRegistration.DTO.UserDto;


import com.loginRegister.loginRegistration.Service.UserService;
import com.loginRegister.loginRegistration.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class userController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto){

        String id =userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){

        LoginResponse loginResponse;
        loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);

    }
}

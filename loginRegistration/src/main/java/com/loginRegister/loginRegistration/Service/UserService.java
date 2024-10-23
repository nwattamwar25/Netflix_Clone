package com.loginRegister.loginRegistration.Service;

import com.loginRegister.loginRegistration.DTO.LoginDto;
import com.loginRegister.loginRegistration.DTO.UserDto;
import com.loginRegister.loginRegistration.payloadResponse.LoginResponse;
import org.springframework.stereotype.Service;


public interface UserService {


   String addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);
}

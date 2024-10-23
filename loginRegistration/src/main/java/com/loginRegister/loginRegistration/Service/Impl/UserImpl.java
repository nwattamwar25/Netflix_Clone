package com.loginRegister.loginRegistration.Service.Impl;

import com.loginRegister.loginRegistration.DTO.LoginDto;
import com.loginRegister.loginRegistration.DTO.UserDto;
import com.loginRegister.loginRegistration.Entity.User;
import com.loginRegister.loginRegistration.Repository.UserRepo;
import com.loginRegister.loginRegistration.Service.UserService;
import com.loginRegister.loginRegistration.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {

        User user = new User(
                userDto.getUserId(),
                userDto.getUserName(),
                this.passwordEncoder.encode(userDto.getPassWord()),
                userDto.getEmail()
        );

        userRepo.save(user);
        return user.getUserName();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
         String msg = "";

         User user = userRepo.findByEmail(loginDto.getEmail());
        if(user != null){
            String password = loginDto.getPassWord();
            String encodedPassword = user.getPassWord();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if(isPwdRight){
                Optional<User> user1 = userRepo.findOneByEmailAndPassword(loginDto.getEmail() ,encodedPassword);
                if(user1.isPresent()){
                    return new LoginResponse("Logged In Successfully", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            }else {
                return new LoginResponse("Incorrect Password", false);
            }
        } else {
            return new LoginResponse("Email Doesn't Exists",false);
        }
    }
}

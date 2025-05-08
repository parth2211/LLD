package com.lldprojects.splitwise.controllers;

import com.lldprojects.splitwise.Dtos.RegisterUserRequestDto;
import com.lldprojects.splitwise.Dtos.RegisterUserResponseDto;
import com.lldprojects.splitwise.models.User;
import com.lldprojects.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public RegisterUserResponseDto registerUserController(RegisterUserRequestDto request){
        String username = request.getUsername();
        String phoneNo = request.getPhoneNumber();
        String password = request.getPassword();

        User user = userService.registerUserService(username, phoneNo, password);

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);

        return registerUserResponseDto;
    }
}

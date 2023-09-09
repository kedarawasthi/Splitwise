package com.splitwise.controllers;


import com.splitwise.dtos.RegisterUserRequestDto;
import com.splitwise.dtos.RegisterUserResponseDto;
import com.splitwise.models.User;
import com.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto dto){
        try{
            User user = userService.registerUser(dto.getPhoneNumber(), dto.getUserName(), dto.getPassword());
            return RegisterUserResponseDto.getSuccessResponse(user);
        } catch (Exception e){
            return RegisterUserResponseDto.getFailureResponse(e.getMessage());
        }
    }
}

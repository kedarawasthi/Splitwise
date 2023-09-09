package com.splitwise.dtos;

import com.splitwise.models.User;
import lombok.Data;

@Data
public class RegisterUserResponseDto {
    private Response response;
    private String phoneNumber;
    private String userName;
    private int id;


    public static RegisterUserResponseDto getSuccessResponse(User user){
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setResponse(Response.getSuccessResponse("User registered successfully"));
        registerUserResponseDto.setUserName(user.getName());
        registerUserResponseDto.setId(user.getId());
        registerUserResponseDto.setPhoneNumber(user.getPhoneNumber());
        return registerUserResponseDto;
    }

    public static RegisterUserResponseDto getFailureResponse(String message){
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setResponse(Response.getFailureResponse("User registered successfully"));
        return registerUserResponseDto;
    }
}

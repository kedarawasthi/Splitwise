package com.splitwise.dtos;

import lombok.Data;

@Data
public class Response {
    private String message;
    private ResponseStatus responseStatus;

    public static Response getSuccessResponse(String meesage){
        Response response = new Response();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setMessage(meesage);
        return response;
    }

    public static Response getFailureResponse(String meesage){
        Response response = new Response();
        response.setResponseStatus(ResponseStatus.FAILURE);
        response.setMessage(meesage);
        return response;
    }
}

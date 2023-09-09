package com.splitwise.controllers;


import com.splitwise.dtos.Response;
import com.splitwise.dtos.ResponseStatus;
import com.splitwise.dtos.SettleGroupRequestDto;
import com.splitwise.dtos.SettleGroupResponseDto;
import com.splitwise.models.Transaction;
import com.splitwise.services.SettleUpService;

import java.util.List;

public class SettleUpController {

    public SettleUpService settleUpService;


    public SettleGroupResponseDto settleGroup(SettleGroupRequestDto dto){
        List<Transaction> transactions = settleUpService.settleGroup(dto.getGroupId());
        SettleGroupResponseDto responseDto = new SettleGroupResponseDto();
        responseDto.setTransactions(transactions);
        Response response = new Response();
        response.setMessage("Success");
        response.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setResponse(response);
        return responseDto;
    }

    public List<Transaction> settleUser(int userId){
        List<Transaction> transactions = settleUpService.settleUser(userId);
        return transactions;
    }
}

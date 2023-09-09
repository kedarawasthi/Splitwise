package com.splitwise.dtos;

import com.splitwise.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {
    private List<Transaction> transactions;
    private Response response;
}

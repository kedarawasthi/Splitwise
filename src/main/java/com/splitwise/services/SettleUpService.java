package com.splitwise.services;

import com.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    public List<Transaction> settleGroup(int groupId);

    public List<Transaction> settleUser(int userId);
}

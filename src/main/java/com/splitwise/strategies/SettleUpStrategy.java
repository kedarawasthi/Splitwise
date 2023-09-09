package com.splitwise.strategies;

import com.splitwise.models.Transaction;
import com.splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {

    public List<Transaction> settleUp(Map<User, Double> aggregateExpenses);
}

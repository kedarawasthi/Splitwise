package com.splitwise.services;


import com.splitwise.models.Expense;
import com.splitwise.models.GroupExpense;
import com.splitwise.models.Transaction;
import com.splitwise.models.User;
import com.splitwise.strategies.SettleUpStrategy;
import com.splitwise.utils.ExpenseUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SettleUpServiceImpl implements SettleUpService{

    private GroupExpenseRepository groupExpenseRepository;
    private SettleUpStrategy settleUpStrategy;

    @Override
    public List<Transaction> settleGroup(int groupId) {
        List<GroupExpense> groupExpenses = groupExpenseRepository.findByGroup_Id(groupId);
        List<Expense> expenses = groupExpenses.stream().map(obj -> obj.getExpense()).collect(Collectors.toList());
        Map<User, Double> aggregateExpenses = ExpenseUtils.aggregateExpenses(expenses);
        return settleUpStrategy.settleUp(aggregateExpenses);
    }

    @Override
    public List<Transaction> settleUser(int userId) {
        /*
        Approach #1:
        Step 1: Fetch all rows from expense user table
        Step 2: Create a set of expense ids from the rows received
        Step 3: Query group expense table and figure out which expense ids are not part of a group
        Step 4: Filter rows obtained in Step 1 on the basis of non group expense ids


        Approach #2:
        Fetch rows from expense user table which are not part of any group directly in a single query
        1. Figure out query
        2. Figure out how to write custom query in spring
        3. Implement this from controller to repository
        4. Create dtos

         */
        return null;
    }
}

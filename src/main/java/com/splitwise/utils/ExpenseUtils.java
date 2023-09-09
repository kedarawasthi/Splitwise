package com.splitwise.utils;

import com.splitwise.models.Expense;
import com.splitwise.models.ExpenseType;
import com.splitwise.models.ExpenseUser;
import com.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseUtils {

    public static Map<User, Double> aggregateExpenses(List<Expense> expenses){
        Map<User, Double> condensedExpenses = new HashMap<>();
        for (Expense expense : expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                User user = expenseUser.getUser();
                double amountForThisExpense = expenseUser.getExpenseType().equals(ExpenseType.PAID) ? 1 : -1 * expenseUser.getAmount();
                condensedExpenses.put(user,  amountForThisExpense + condensedExpenses.getOrDefault(user, 0d));
            }
        }
        return condensedExpenses;
    }
}

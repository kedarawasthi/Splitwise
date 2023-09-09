package com.splitwise.services;

import com.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Integer> {

    List<GroupExpense> findByGroup_Id(int groupId);
}

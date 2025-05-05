package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends ModelID{
    Double amount;
    List<ExpensePaidBy> expensePaidBy;
    List<ExpenseOwedBy> expenseOwedBy;
    ExpenseStatus expenseStatus;
    List<User> participants;
    User createdBy;
    String description;
    Currency currency;
}

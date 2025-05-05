package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends ModelID{
    private double amount;
    private List<ExpensePaidBy> expensePaidBy;
    private List<ExpenseOwedBy> expenseOwedBy;
    private ExpenseStatus expenseStatus;
    @ManyToMany
    private List<User> participants;
    @ManyToOne
    private User createdBy;
    private String description;
    @ManyToOne
    private Currency currency;
}

package com.lldprojects.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "expenses")
public class Expense extends ModelID{
    private double amount;

    @OneToMany
    private List<ExpensePaidBy> expensePaidBy;

    @OneToMany
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

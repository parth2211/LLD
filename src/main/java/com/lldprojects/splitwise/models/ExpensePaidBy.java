package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExpensePaidBy extends ModelID{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amountPaid;
}

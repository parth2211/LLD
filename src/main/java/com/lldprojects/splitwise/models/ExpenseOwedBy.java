package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExpenseOwedBy extends ModelID {
    String expenseID;
    User user;
    Double amountOwed;
}

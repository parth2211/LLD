package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Group extends ModelID{
    User createdBy;
    String name;
    String description;
    List<User> groupParticipants;
    List<Expense> groupExpenses;
    List<User> admins;
}

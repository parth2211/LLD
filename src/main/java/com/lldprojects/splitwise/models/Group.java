package com.lldprojects.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="groups")
public class Group extends ModelID{
    @ManyToOne
    private User createdBy;
    private String name;
    private String description;
    @ManyToMany
    private List<User> groupParticipants;
    @OneToMany
    private List<Expense> groupExpenses;
    @ManyToMany
    private List<User> admins;
}

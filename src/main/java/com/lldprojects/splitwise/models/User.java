package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User extends ModelID{
    private String username;

    private String password;

    private String phoneNo;
}

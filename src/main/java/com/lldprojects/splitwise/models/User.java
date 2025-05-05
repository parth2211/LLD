package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends ModelID{
    String username;
    String password;
    String phoneNo;
}

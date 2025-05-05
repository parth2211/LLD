package com.lldprojects.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Currency {
    private String symbol;

    private String name;
}

package com.sparta.currency_user.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Currency extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currencyName;
    private BigDecimal exchangeRate= BigDecimal.valueOf(900);
    private String symbol;

    @OneToMany
    @JoinColumn(name = "currencyId")
    List<Middle> middlelist = new ArrayList<>();

    public Currency(String currencyName, String symbol) {
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public Currency() {
    }
}

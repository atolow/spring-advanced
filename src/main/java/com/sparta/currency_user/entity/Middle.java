package com.sparta.currency_user.entity;

import com.sparta.currency_user.Const.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Middle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="currencyId")
    Currency currency;

    @ManyToOne
    @JoinColumn(name="userId")
    User user;

    @Column(nullable = false)
    Long amount_in_krw;

    @Column(nullable = false)
    Double amount_after_exchange;

    @Column(nullable = false)
    StatusType statusType;
}

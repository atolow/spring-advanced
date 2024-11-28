package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Getter

public class Middle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "to_currency_id")
    Currency currency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(nullable = false)
    BigDecimal amount_in_krw;

    @Column(nullable = false)
    BigDecimal amount_after_exchange;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('NORMAL', 'CANCELLED')")
    @NotNull
    private MiddleStatus status;
    public enum MiddleStatus {
        NORMAL,
        CANCELLED
    }

    public Middle() {
    }

    public Middle(Currency currency, User user, BigDecimal amount_in_krw, BigDecimal amount_after_exchange, MiddleStatus status) {
        this.currency = currency;
        this.user = user;
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.status = status;
    }
    public void changeStatusCancelled(){

        if(status == MiddleStatus.CANCELLED){
            status=MiddleStatus.NORMAL;
        }
        else{
            status = MiddleStatus.CANCELLED;
        }
    }
}

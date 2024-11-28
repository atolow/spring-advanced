package com.sparta.currency_user.dto;


import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleResponseDto {
    private Long id;
    private Currency currency;
    private User user;
    private BigDecimal amount_in_krw;
    private BigDecimal amount_after_exchange;
    private String status;

    public MiddleResponseDto(Long id, Currency currency, User user, BigDecimal amount_in_krw, BigDecimal amount_after_exchange, Middle.MiddleStatus status) {
        this.id = id;
        this.currency = currency;
        this.user = user;
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.status = String.valueOf(status);
    }

    public MiddleResponseDto(Middle middle) {
        this.id = middle.getId();
        this.currency = middle.getCurrency();
        this.user = middle.getUser();
        this.amount_in_krw = middle.getAmount_in_krw();
        this.amount_after_exchange = middle.getAmount_after_exchange();
        this.status = middle.getStatus().name();
    }



    public static MiddleResponseDto toDto(Middle middle) {
        return new MiddleResponseDto(
                middle.getId(),
                middle.getCurrency(),
                middle.getUser(),
                middle.getAmount_in_krw(),
                middle.getAmount_after_exchange(),
                middle.getStatus()
        );
    }

}

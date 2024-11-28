package com.sparta.currency_user.dto;

import com.sparta.currency_user.Const.StatusType;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleResponseDto {
    Long id;
    Currency currency;
    User user;
    BigDecimal amount_in_krw;
    BigDecimal amount_after_exchange;
    StatusType statusType;


    public MiddleResponseDto(Long id, Currency currency, User user, BigDecimal amount_in_krw, BigDecimal amount_after_exchange, StatusType statusType) {
        this.id = id;
        this.currency = currency;
        this.user = user;
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.statusType = statusType;
    }

    public MiddleResponseDto(Middle middle) {
        this.id = middle.getId();
        this.currency = middle.getCurrency();
        this.user = middle.getUser();
        this.amount_in_krw = middle.getAmount_in_krw();
        this.amount_after_exchange = middle.getAmount_after_exchange();
        this.statusType = getStatusType();
    }



    public static MiddleResponseDto toDto(Middle middle) {
        return new MiddleResponseDto(
                middle.getId(),
                middle.getCurrency(),
                middle.getUser(),
                middle.getAmount_in_krw(),
                middle.getAmount_after_exchange(),
                middle.getStatusType()
        );
    }

}

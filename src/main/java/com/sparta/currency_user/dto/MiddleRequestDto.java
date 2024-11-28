package com.sparta.currency_user.dto;


import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleRequestDto {
    Currency currency;
    User user;
    BigDecimal amount_in_krw;
    Double amount_after_exchange;
    String status;
}

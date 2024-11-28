package com.sparta.currency_user.dto;


import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
public class MiddleRequestDto {
    @NotNull
    Long currency;
    @NotNull
    Long user;
    @NotNull
    BigDecimal amount_in_krw;
}

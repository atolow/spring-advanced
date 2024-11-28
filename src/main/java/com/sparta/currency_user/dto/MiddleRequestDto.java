package com.sparta.currency_user.dto;

import com.sparta.currency_user.Const.StatusType;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleRequestDto {
    Currency currency;
    User user;
    BigDecimal amount_in_krw;
    Double amount_after_exchange;
    StatusType statusType;
}

package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @NotBlank(message = "통화 이름은 필수값 입니다.")
    private String currencyName;
    @NotNull(message = "환율은 필수값 입니다.")
    private BigDecimal exchangeRate;
    @NotBlank(message = "통화 심볼은 필수값 입니다.")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}

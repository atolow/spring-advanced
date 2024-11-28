package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import jakarta.persistence.Column;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @NotNull
    private String currencyName;
    @NotNull
    private BigDecimal exchangeRate;
    @NotNull
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.symbol
        );
    }
}

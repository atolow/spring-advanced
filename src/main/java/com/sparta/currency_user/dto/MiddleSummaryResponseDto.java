package com.sparta.currency_user.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleSummaryResponseDto {

    private Long userId;

    private Long count;

    private BigDecimal totalAmountInKrw;

    public MiddleSummaryResponseDto(Long userId, Long count, BigDecimal totalAmountInKrw) {
        this.userId = userId;
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}

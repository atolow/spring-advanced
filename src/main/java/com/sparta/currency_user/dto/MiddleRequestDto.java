package com.sparta.currency_user.dto;



import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MiddleRequestDto {
    @NotNull(message = "currency는 필수값 입니다. 추가해주세요")
    Long currency;
    @NotNull(message = "user는 필수값 입니다. 추가해주세요")
    Long user;
    @NotNull(message = "환전 금액은 필수값 입니다. 숫자 형태로 입력해주세요")
    BigDecimal amount_in_krw;
}

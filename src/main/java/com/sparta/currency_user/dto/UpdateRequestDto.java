package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

    @NotNull
    private Long exchangeId;

    public UpdateRequestDto() {}
}

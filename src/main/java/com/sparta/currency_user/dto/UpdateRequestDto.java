package com.sparta.currency_user.dto;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class UpdateRequestDto {

    @NotNull
    private Long exchangeId;

    public UpdateRequestDto() {}
}

package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

    @NotNull(message = "middleId은 필수값 입니다. 추가해주세요")
    private Long middleId;

    public UpdateRequestDto() {}
}

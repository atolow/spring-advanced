package com.sparta.currency_user.dto;


import com.sparta.currency_user.entity.Middle;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateResponseDto {

    @NotNull
    private Long middleId;

    @NotNull
    private String status;

    public UpdateResponseDto(Long middleId, String status) {
        this.middleId = middleId;
        this.status = status;
    }

    public UpdateResponseDto(Middle middle) {
        this.middleId = middle.getId();
        this.status = middle.getStatus().name();
    }
}

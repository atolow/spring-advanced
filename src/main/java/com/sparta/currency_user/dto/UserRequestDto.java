package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class UserRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}

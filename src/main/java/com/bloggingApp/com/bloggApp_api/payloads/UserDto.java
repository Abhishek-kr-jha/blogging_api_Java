package com.bloggingApp.com.bloggApp_api.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;

    @NotNull
    private String name;
    @Email(message = "Email is required")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
    @NotNull
    private String about;
}

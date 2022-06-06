package com.api.safetech.userservice.user.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateUserResource {
    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max=8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8,max=20)
    private String password;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    @Size(max=9)
    private String phone;

    @NotNull
    private Date birthday;
}
package com.ibrahim.gallery.gallerymanagement.authentication.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDTO {

    @NotBlank(message = "authentication.not.blank.username")
    private String username;

    @NotBlank(message = "authentication.not.blank.password")
    private String password;

}

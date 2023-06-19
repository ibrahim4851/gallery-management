package com.ibrahim.gallery.gallerymanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "authentication.not.blank.username")
    private String username;

    @NotBlank(message = "authentication.not.blank.password")
    private String password;


}

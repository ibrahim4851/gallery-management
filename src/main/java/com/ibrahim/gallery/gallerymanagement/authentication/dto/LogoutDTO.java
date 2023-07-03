package com.ibrahim.gallery.gallerymanagement.authentication.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LogoutDTO {

    @NotNull(message = "not.null.user.id")
    private Long userId;
    
    @NotBlank(message = "not.null.token")
    private String token;

}


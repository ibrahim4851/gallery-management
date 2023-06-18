package com.ibrahim.gallery.gallerymanagement.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDTO implements Serializable {

    private Date createdAt;

    private String createdByUserId;

    private Date lastModifiedAt;

    private String lastModifiedByUserId;

}

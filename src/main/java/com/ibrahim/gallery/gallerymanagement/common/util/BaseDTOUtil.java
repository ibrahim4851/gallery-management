package com.ibrahim.gallery.gallerymanagement.common.util;


import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;

public class BaseDTOUtil {

    public static void setBaseEntityProperty(BaseEntity existEntity, BaseEntity newEntity) {
        newEntity.setCreatedAt(existEntity.getCreatedAt());
        newEntity.setCreatedByUserId(existEntity.getCreatedByUserId());
        newEntity.setLastModifiedAt(existEntity.getLastModifiedAt());
        newEntity.setLastModifiedByUserId(existEntity.getLastModifiedByUserId());
    }

}

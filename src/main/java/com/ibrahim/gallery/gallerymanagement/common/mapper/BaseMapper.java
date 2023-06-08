package com.ibrahim.gallery.gallerymanagement.common.mapper;

import java.util.List;

public interface BaseMapper <Entity, DTO>{

    Entity toEntity(DTO dto);

    List<Entity> toListEntity(List<DTO> dtos);

    DTO toDTO(Entity entity);

    List<DTO> toListDTO(List<Entity> entities);

    Entity clone(Entity entity);

}

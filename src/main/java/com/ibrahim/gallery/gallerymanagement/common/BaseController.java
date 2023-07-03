package com.ibrahim.gallery.gallerymanagement.common;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.common.util.BaseDTOUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public abstract class BaseController<Entity extends BaseEntity, DTO extends BaseDTO, Service extends BaseService<Entity, ID>, Mapper extends BaseMapper<Entity, DTO>, ID> {

    protected abstract Service getService();

    protected abstract Mapper getMapper();

    @PostMapping
    public DTO save(@RequestBody @Validated DTO dto){
        Entity entity = getService().save(getMapper().toEntity(dto));
        DTO responseDTO = getMapper().toDTO(entity);
        return responseDTO;
    }

    @PutMapping("/{id}")
    public DTO put(@PathVariable("id") ID id, @RequestBody @Validated DTO dto) {

        Entity existEntity = getService().get(id);
        Entity newEntity = getMapper().toEntity(dto);

        BaseDTOUtil.setBaseEntityProperty(existEntity, newEntity);

        Entity putServiceResult = getService().put(newEntity);

        DTO responseDTO = getMapper().toDTO(putServiceResult);

        return responseDTO;
    }

    @GetMapping("/{id}")
    public DTO get(@PathVariable ID id) {
        DTO dto = getMapper().toDTO(getService().get(id));
        return dto;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") ID id) {
        getService().delete(id);
        return Boolean.TRUE;
    }

    @GetMapping
    public List<DTO> findAll() {
        List<Entity> entities = getService().findAll();
        List<DTO> dtos = getMapper().toListDTO(entities);
        return dtos;
    }
}

package com.ibrahim.gallery.gallerymanagement.common.controller;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseServiceResult;
import com.ibrahim.gallery.gallerymanagement.common.util.BaseDTOUtil;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public abstract class BaseController<Entity extends BaseEntity, DTO extends BaseDTO, Service extends BaseService<Entity, ID>, Mapper extends BaseMapper<Entity, DTO>, ID> extends BaseResponseCreator<DTO> {

    protected abstract Service getService();

    protected abstract Mapper getMapper();

    public BaseController(MessageSource messageSource) {
        super(messageSource);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Validated DTO dto) {
        BaseServiceResult<Entity> serviceResult = getService().save(getMapper().toEntity(dto));
        DTO responseDTO = getMapper().toDTO(serviceResult.getResult());
        return createResponse(responseDTO);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Entity>> filter(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<Entity> entities = getService().findAllWithPagination(pageable).getContent();
        List<DTO> dtos = getMapper().toListDTO(entities);

        return createResponse(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") ID id, @RequestBody @Validated DTO dto) {

        Entity existEntity = getService().get(id);
        Entity newEntity = getMapper().toEntity(dto);

        BaseDTOUtil.setBaseEntityProperty(existEntity, newEntity);

        BaseServiceResult<Entity> putServiceResult = getService().put(newEntity);

        DTO responseDTO = getMapper().toDTO(putServiceResult.getResult());

        return createResponse(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable ID id) {
        DTO dto = getMapper().toDTO(getService().get(id));
        return createResponse(dto);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") ID id) {
        getService().delete(id);
        return Boolean.TRUE;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Entity> entities = getService().findAll();
        List<DTO> dtos = getMapper().toListDTO(entities);
        return createResponse(dtos);
    }
}

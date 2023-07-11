package com.ibrahim.gallery.gallerymanagement.common.service;

import com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants.NOT_FOUND;

public abstract class BaseService<Entity, ID> extends BaseServiceProxy<Entity, ID, BaseRepository<Entity, ID>> {

    public BaseServiceResult<Entity> save(Entity entity){
        savePreHandler(entity);
        Entity newEntity = getRepository().save(entity);
        saveAfterHandler(newEntity);
        return new BaseServiceResult<>(newEntity);
    }

    public Entity get(ID id) {
        return getRepository().findById(id).orElseThrow(() -> new NoSuchElementException(ExceptionConstants.NOT_FOUND));
    }

    public BaseServiceResult<Entity> put(Entity entity) {
        putPreHandler(entity);
        Entity save = getRepository().save(entity);
        putAfterHandler(save);
        return new BaseServiceResult<>(save);
    }

    public void delete(ID id) {
        deletePreHandler(id);
        getRepository().deleteById(id);
    }

    public Entity getById(ID id) {
        return getRepository().findById(id).orElseThrow(()-> new NoSuchElementException(NOT_FOUND));
    }

    public void savePreHandler(Entity entity) {
    }

    public void putPreHandler(Entity entity) {
    }

    public void saveAfterHandler(Entity entity) {
    }

    public void putAfterHandler(Entity entity) {
    }

    public void deletePreHandler(ID entityId) {
    }

    public List<Entity> findAll() {
        List<Entity> entities = getRepository().findAll();
        return entities;
    }

}

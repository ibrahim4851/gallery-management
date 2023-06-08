package com.ibrahim.gallery.gallerymanagement.common.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;

import java.util.NoSuchElementException;

import static com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants.NOT_FOUND;

public abstract class BaseService<Entity, ID> extends BaseServiceProxy<Entity, ID, BaseRepository<Entity, ID>> {

    public Entity save(Entity entity){
        savePreHandler(entity);
        Entity newEntity = getRepository().save(entity);
        saveAfterHandler(newEntity);
        return newEntity;
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

    public void deletePreHandler(Long entityId) {
    }

}

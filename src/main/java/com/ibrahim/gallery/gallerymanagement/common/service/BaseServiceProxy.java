package com.ibrahim.gallery.gallerymanagement.common.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;

import javax.swing.text.html.parser.Entity;

public abstract class BaseServiceProxy<Entity, ID, Repository extends BaseRepository<Entity, ID>> {

    public abstract Repository getRepository();

}

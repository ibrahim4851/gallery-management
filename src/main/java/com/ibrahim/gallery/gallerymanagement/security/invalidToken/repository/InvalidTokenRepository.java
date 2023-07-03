package com.ibrahim.gallery.gallerymanagement.security.invalidToken.repository;


import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.security.invalidToken.entity.InvalidToken;

import java.util.Date;
import java.util.List;

public interface InvalidTokenRepository extends BaseRepository<InvalidToken, Long> {

    List<InvalidToken> findAllByExpireDateLessThan(Date expireDate);

    Boolean existsByToken(String token);

}

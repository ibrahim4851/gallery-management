package com.ibrahim.gallery.gallerymanagement.security.invalidToken.service;

import com.ibrahim.gallery.gallerymanagement.authentication.dto.LogoutDTO;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.security.invalidToken.entity.InvalidToken;
import com.ibrahim.gallery.gallerymanagement.security.invalidToken.repository.InvalidTokenRepository;
import com.ibrahim.gallery.gallerymanagement.security.service.TokenService;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvalidTokenService extends BaseService<InvalidToken, Long> {

    private final InvalidTokenRepository invalidTokenRepository;
    private final TokenService tokenService;


    @Override
    public BaseRepository<InvalidToken, Long> getRepository() {
        return invalidTokenRepository;
    }

    public List<InvalidToken> getByTokenExpireDateLessThan(Date expireDate) {
        return invalidTokenRepository.findAllByExpireDateLessThan(expireDate);
    }

    public void deleteAll(List<InvalidToken> invalidTokens) {
        invalidTokenRepository.deleteAll(invalidTokens);
    }

    public InvalidToken save(LogoutDTO logoutDTO) {
        InvalidToken invalidToken = saveInvalidToken(logoutDTO, tokenService.getExpirationDateFromToken(logoutDTO.getToken()));
        return invalidTokenRepository.save(invalidToken);
    }

    public Boolean existsByToken(String token) {
        return invalidTokenRepository.existsByToken(token);
    }

    private InvalidToken saveInvalidToken(LogoutDTO logoutDTO, Date expirationDate) {
        InvalidToken invalidToken = new InvalidToken();
        invalidToken.setToken(logoutDTO.getToken());
        invalidToken.setUser(getUser(logoutDTO.getUserId()));
        invalidToken.setExpireDate(expirationDate);
        return invalidTokenRepository.save(invalidToken);
    }

    private User getUser(Long userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }

}

package com.ibrahim.gallery.gallerymanagement.user.controller;

import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import com.ibrahim.gallery.gallerymanagement.user.dto.UserDTO;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import com.ibrahim.gallery.gallerymanagement.user.mapper.UserDTOMapper;
import com.ibrahim.gallery.gallerymanagement.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<User, UserDTO, UserService, UserDTOMapper, Long> {

    private final UserService userService;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserService userService, UserDTOMapper userDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    protected UserService getService() {
        return userService;
    }

    @Override
    protected UserDTOMapper getMapper() {
        return userDTOMapper;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity save(@RequestBody @Valid UserDTO userDTO) {
        User user = userDTOMapper.toEntity(userDTO);
        return createResponse(userDTOMapper.toDTO(userService.register(user)));
    }
}
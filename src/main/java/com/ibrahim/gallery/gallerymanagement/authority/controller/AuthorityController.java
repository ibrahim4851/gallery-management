package com.ibrahim.gallery.gallerymanagement.authority.controller;

import com.ibrahim.gallery.gallerymanagement.authority.dto.AuthorityDTO;
import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.authority.mapper.AuthorityDTOMapper;
import com.ibrahim.gallery.gallerymanagement.authority.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("authorities")
public class AuthorityController  {

    private final AuthorityService authorityService;
    private final AuthorityDTOMapper authorityDTOMapper;

    public AuthorityController(AuthorityService authorityService, AuthorityDTOMapper authorityDTOMapper) {
        this.authorityService = authorityService;
        this.authorityDTOMapper = authorityDTOMapper;
    }

    @GetMapping
    public List<AuthorityDTO> findAll() {
        List<Authority> claims = authorityService.findAll();
        return authorityDTOMapper.toListDTO(claims);
    }

    @GetMapping(path = "/{claimId}")
    public AuthorityDTO get(@PathVariable String claimId) {
        Authority claim = authorityService.get(claimId);
        return authorityDTOMapper.toDTO(claim);
    }

    @PostMapping
    public AuthorityDTO save(@Valid @RequestBody AuthorityDTO claimDTO) {
        Authority authority = authorityDTOMapper.toEntity(claimDTO);
        Authority registeredClaim = authorityService.save(authority);
        return authorityDTOMapper.toDTO(registeredClaim);
    }

    @PutMapping({"/{claimId}"})
    public AuthorityDTO put(@PathVariable String claimId, @RequestBody @Valid AuthorityDTO authorityDTO) {
        Authority authority = authorityDTOMapper.toEntity(authorityDTO);
        Authority updatedClaim = authorityService.put(claimId, authority);
        return authorityDTOMapper.toDTO(updatedClaim);
    }

    @DeleteMapping({"/{claimId}"})
    public Boolean delete(@PathVariable String claimId) {
        return authorityService.delete(claimId);
    }
}

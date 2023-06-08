package com.ibrahim.gallery.gallerymanagement.security.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(name = "USERS")
@Entity
public class User extends BaseEntity implements UserDetails, CredentialsContainer {

    @Serial
    private static final long serialVersionUID = -7714517341931883905L;

    @Id
    @GeneratedValue(generator = "USER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;

    private String password;

    private String username;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
    joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "id") },
    indexes = {
            @Index(name = "USER_INDEX", columnList = "USER_ID"),
            @Index(name = "ROLE_INDEX", columnList = "ROLE_ID")
    })
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .map(Authority::getPermission)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}

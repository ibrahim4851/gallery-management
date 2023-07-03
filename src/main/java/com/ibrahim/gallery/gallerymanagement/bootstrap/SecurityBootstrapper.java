package com.ibrahim.gallery.gallerymanagement.bootstrap;

import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.authority.service.AuthorityService;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import com.ibrahim.gallery.gallerymanagement.role.service.RoleService;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import com.ibrahim.gallery.gallerymanagement.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@AllArgsConstructor
public class SecurityBootstrapper {

    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    @PostConstruct
    private void userLoader() {
        Authority authorityAppCreate = new Authority();
        Authority authorityAppRead = new Authority();
        Authority authorityAppUpdate = new Authority();
        Authority authorityAppDelete = new Authority();

        authorityAppCreate.setPermission("app:create");
        authorityAppUpdate.setPermission("app:update");
        authorityAppRead.setPermission("app:read");
        authorityAppDelete.setPermission("app:delete");

        authorityAppCreate = authorityService.save(authorityAppCreate);
        authorityAppUpdate = authorityService.save(authorityAppUpdate);
        authorityAppRead = authorityService.save(authorityAppRead);
        authorityAppDelete = authorityService.save(authorityAppDelete);

        Role adminRole = new Role();
        adminRole.setAuthorities(Set.of(authorityAppCreate, authorityAppUpdate, authorityAppRead, authorityAppDelete));

        Role systemManagerRole = new Role();
        systemManagerRole.setAuthorities(Set.of(authorityAppUpdate, authorityAppRead));

        Role customerRole = new Role();
        customerRole.setAuthorities(Set.of(authorityAppRead));

        adminRole = roleService.save(adminRole);
        systemManagerRole = roleService.save(systemManagerRole);
        customerRole = roleService.save(customerRole);

        User admin = new User();
        //admin.setUsername("admin");
        admin.setEmail("admin@email.com");
        admin.setPassword(passwordEncoder.encode("123"));
        admin.setRoles(Set.of(adminRole));
        //admin.setEnabled(true);

        User systemManager = new User();
        //systemManager.setUsername("sm");
        systemManager.setEmail("sm@email.com");
        systemManager.setPassword(passwordEncoder.encode("123"));
        systemManager.setRoles(Set.of(systemManagerRole));

        User customer = new User();
        //systemManager.setUsername("customer");
        customer.setEmail("customer@email.com");
        customer.setPassword(passwordEncoder.encode("123"));
        customer.setRoles(Set.of(customerRole));

        userService.save(admin);
        userService.save(systemManager);
        userService.save(customer);


    }

}

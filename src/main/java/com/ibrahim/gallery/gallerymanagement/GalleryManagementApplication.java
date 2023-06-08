package com.ibrahim.gallery.gallerymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GalleryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryManagementApplication.class, args);
    }

}

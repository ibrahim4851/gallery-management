package com.ibrahim.gallery.gallerymanagement.common.validator;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class CustomEmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: Regex to validate email
        return true;
    }
}

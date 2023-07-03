package com.ibrahim.gallery.gallerymanagement.security.handler;

import com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, ExceptionConstants.FORBIDDEN_MESSAGE);
    }
}

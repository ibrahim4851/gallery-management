package com.ibrahim.gallery.gallerymanagement.security.config;

import com.ibrahim.gallery.gallerymanagement.common.constants.GlobalConstants;
import com.ibrahim.gallery.gallerymanagement.security.filter.JwtRequestFilter;
import com.ibrahim.gallery.gallerymanagement.security.handler.CustomAccessDeniedHandler;
import com.ibrahim.gallery.gallerymanagement.security.handler.CustomAuthenticationEntryPoint;
import com.ibrahim.gallery.gallerymanagement.security.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final JwtRequestFilter jwtRequestFilter;
    private final CustomUserDetailsService customUserDetailsService;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(GlobalConstants.EXCLUDE_URL)
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler).authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                .headers().frameOptions().disable();

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}

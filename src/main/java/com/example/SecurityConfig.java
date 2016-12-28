package com.example;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableWebSecurity
public class SecurityConfig {
    @Configuration
    @EnableOAuth2Sso
    @Order(2)
    public static class Oauth2SsoSecurity extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .requestMatchers()
                    .antMatchers("/sso/**", "/login")
            .and()
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .anyRequest().authenticated();
            // @formatter:on
        }
    }

    @Configuration
    public static class ResourceServerConfig implements ResourceServerConfigurer {
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources
                    .resourceId("my-cloud-app");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().authenticated();
        }
    }
}

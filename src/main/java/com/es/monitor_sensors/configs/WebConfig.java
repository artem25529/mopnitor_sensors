package com.es.monitor_sensors.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/sensors");

        registry.addViewController("/sensors").setViewName("pages/sensors-list");
        registry.addViewController("/login").setViewName("pages/login");
    }
}

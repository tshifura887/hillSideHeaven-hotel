package com.dailycodework.hillsideheavenhotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Talifhani Tshifura
 */
@Configuration
public class WebConfig {

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("*");  // Allow all origins
    config.addAllowedHeader("*");  // Allow all headers
    config.addAllowedMethod("*");  // Allow all methods
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}


package kr.co.calejoin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        registry.addMapping("/api/**")

                .allowedOrigins("http://localhost:3000", "http://calejoin.site/","http://localhost:8080")
                .allowedOrigins("http://localhost:3000", "http://localhost:8080")
                //.allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedMethods("*")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Custom-Header")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

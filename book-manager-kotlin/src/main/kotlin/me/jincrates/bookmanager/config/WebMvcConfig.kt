package me.jincrates.bookmanager.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig(
    val MAX_AGE_SECS: Long = 3600
): WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        //모든 경로에 대해
        registry.addMapping("/**")
            // Origin이 http:localhost:3000에 대해
            .allowedOrigins("http://localhost:3000")
            // 허용 메서드
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(MAX_AGE_SECS);
    }
}
package ru.innopolis.stc31.appeal.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${cloudinary.config.cloudName}")
    private String cloudName;

    @Value("${cloudinary.config.apiKey}")
    private String apiKey;

    @Value("${cloudinary.config.apiSecret}")
    private String apiSecret;

    @Bean
    public Cloudinary getCloudinary() {
        Cloudinary cloudinary = new Cloudinary();
        cloudinary.config.apiKey = apiKey;
        cloudinary.config.apiSecret = apiSecret;
        cloudinary.config.cloudName = cloudName;
        return cloudinary;
    }
}

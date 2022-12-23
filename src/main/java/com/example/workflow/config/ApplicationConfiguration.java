package com.example.workflow.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    private final CloudinaryConfig config;

    public ApplicationConfiguration(CloudinaryConfig config) {
        this.config = config;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                Map.of(
                        "cloud_name", config.getCloudName(),
                        "api_key", config.getApiKey(),
                        "api_secret", config.getApiSecret()
                )
        );
    }
}

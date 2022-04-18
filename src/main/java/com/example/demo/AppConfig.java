package com.example.demo;

import com.google.appengine.api.ThreadManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ThreadFactory;

@Configuration
public class AppConfig {

    @Primary
    @Bean
    public ThreadFactory modelMapper() {
        return ThreadManager.backgroundThreadFactory();
    }
}

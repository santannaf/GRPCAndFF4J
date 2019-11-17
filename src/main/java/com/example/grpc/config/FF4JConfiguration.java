package com.example.grpc.config;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FF4JConfiguration implements FF4jProvider {

    @Bean
    @Primary
    public FF4j getFF4j() { return new FF4j("ff4j-features.xml"); }
}
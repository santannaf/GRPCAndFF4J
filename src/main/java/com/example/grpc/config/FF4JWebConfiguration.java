package com.example.grpc.config;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.ff4j.property.PropertyString;
import org.ff4j.web.FF4jDispatcherServlet;
import org.ff4j.web.embedded.ConsoleServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ConsoleServlet.class, FF4jDispatcherServlet.class})
@RequiredArgsConstructor
public class FF4JWebConfiguration extends SpringBootServletInitializer {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ConsoleServlet ff4jConsoleServlet) {
        return new ServletRegistrationBean(ff4jConsoleServlet, "/ff4j-console");
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsoleServlet getFF4jServlet(FF4j ff4j) {

        ff4j.createProperty(new PropertyString("name", "THALES"));
        ConsoleServlet ff4jConsoleServlet = new ConsoleServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }

    @Bean
    public ServletRegistrationBean ff4jDispatcherServletRegistrationBean(FF4jDispatcherServlet ff4jDispatcherServlet) {
        return new ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*");
    }

    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet getFF4jDispatcherServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }
}

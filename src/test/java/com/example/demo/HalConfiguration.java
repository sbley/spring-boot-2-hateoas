package com.example.demo;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.ConverterRegisteringWebMvcConfigurer;

@Configuration
public class HalConfiguration {

    @Bean
    public RestTemplateCustomizer halCustomizer(ConverterRegisteringWebMvcConfigurer customizer) {
        return (template) -> customizer.extendMessageConverters(template.getMessageConverters());
    }
}

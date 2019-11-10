package ru.pchurzin.spring.customannotations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }

    @Bean
    public TestController getTestController() {
        return new TestController();
    }
}

package com.schooling.app.config;


import com.schooling.app.shared.annotation.UseCaseService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = {"com.schooling.app.**.application.usecase"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = UseCaseService.class))
public class UseCaseConfiguration {

}

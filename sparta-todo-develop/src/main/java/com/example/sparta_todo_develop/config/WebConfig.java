package com.example.sparta_todo_develop.config;

import com.example.sparta_todo_develop.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean customFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        // Filter 등록
        filterRegistrationBean.setFilter(new LoginFilter());
        // Filter 순서 설정
        filterRegistrationBean.setOrder(1);
        // 전체 URL에 Filter 적용
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}


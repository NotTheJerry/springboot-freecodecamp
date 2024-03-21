package com.alibou.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean("bean1")
    public MyFirstClass myFirstBean () {
        return new MyFirstClass("First bean");
    }

    @Bean
    public MyFirstClass mySecondBean () {
        return new MyFirstClass("Second bean");
    }

    @Bean
//    @Primary
    public MyFirstClass myThirdBean () {
        return new MyFirstClass("Third bean");
    }
}

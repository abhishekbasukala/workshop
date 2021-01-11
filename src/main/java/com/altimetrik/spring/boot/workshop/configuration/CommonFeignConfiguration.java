package com.altimetrik.spring.boot.workshop.configuration;

import com.altimetrik.spring.boot.workshop.exception.CommonFeignErrorDecoder;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonFeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    public CommonFeignErrorDecoder feignErrorDecoder(){
        return new CommonFeignErrorDecoder();
    }

}

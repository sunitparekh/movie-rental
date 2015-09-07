package com.github.sunitparekh.movierental;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@Configurable
@ComponentScan
public class ApplicationConfigurations {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}

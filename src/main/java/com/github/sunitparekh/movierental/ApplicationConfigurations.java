package com.github.sunitparekh.movierental;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configurable
@ComponentScan
public class ApplicationConfigurations {

    @Bean(name="users")
    public Map<String,String> users() {
        return new HashMap<String, String>() {{
            put("sp18336","Sunit Parekh");
            put("ck08009","Chaitanya Karmarkar");
            put("al01234","Ankita Luthra");
        }};
    }

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}

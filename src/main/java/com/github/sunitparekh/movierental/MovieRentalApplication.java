package com.github.sunitparekh.movierental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MovieRentalApplication {

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


    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }
}

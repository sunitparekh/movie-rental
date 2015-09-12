package com.github.sunitparekh.movierental.exercise1;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ServiceB {

    @Resource(name = "users")
    public Map<String,String> users;

    public String findName(String id) {
        return users.get(id);
    }
}

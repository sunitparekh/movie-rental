package com.github.sunitparekh.movierental.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    @Autowired
    public ServiceB serviceB;

    public String greetUser(String id) {
        return String.format("Hello, %s", serviceB.findName(id));
    }

}

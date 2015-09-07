package com.github.sunitparekh.movierental.exercise1;


import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    public String findName(String id) {
        return String.format("Sunit %s", id);
    }
}

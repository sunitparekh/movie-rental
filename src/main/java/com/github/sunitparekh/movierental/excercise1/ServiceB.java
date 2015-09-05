package com.github.sunitparekh.movierental.excercise1;


import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    public String findName(String id) {
        return String.format("Sunit %s", id);
    }
}

package com.github.sunitparekh.movierental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
    public ModelAndView welcome(@PathVariable String name) {
        Map<String, Object> model = new HashMap<String,Object>() {{
            put("name",name);
            put("cities", Arrays.asList("Pune","Mumbai","Delhi"));
        }};
        return new ModelAndView("welcome","data",model);
    }
}

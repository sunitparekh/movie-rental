package com.github.sunitparekh.movierental.exercise1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceATest {

    @Autowired
    public ServiceA serviceA;

    @Test
    public void testGreetUser() throws Exception {
        String greeting = serviceA.greetUser("sp18336");
        Assert.assertThat(greeting,equalTo("Hello, Sunit Parekh"));
    }
}
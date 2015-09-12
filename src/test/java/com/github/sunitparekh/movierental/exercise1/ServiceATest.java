package com.github.sunitparekh.movierental.exercise1;

import com.github.sunitparekh.movierental.ApplicationConfigurations;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfigurations.class)
public class ServiceATest {

    @Autowired
    public ServiceA serviceA;

    @Test
    public void testGreetUser() throws Exception {
        String greeting = serviceA.greetUser("sp18336");
        Assert.assertThat(greeting,equalTo("Hello, Sunit Parekh"));
    }
}
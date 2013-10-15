package com.svanberg.jaxrs.impl;

import com.svanberg.jaxrs.api.HelloWorldResource;
import com.svanberg.jaxrs.domain.Person;

import javax.inject.Named;

@Named
public class HelloWorldResourceImpl implements HelloWorldResource {
    @Override
    public String helloWorld() {
        return "Hello world!";
    }

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public Person person(String name, int age) {
        return new Person(name, age);
    }
}

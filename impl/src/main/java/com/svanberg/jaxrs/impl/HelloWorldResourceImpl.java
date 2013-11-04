package com.svanberg.jaxrs.impl;

import com.svanberg.jaxrs.api.HelloWorldResource;
import com.svanberg.jaxrs.domain.Person;

import javax.inject.Named;
import java.util.Date;

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
        Person person = new Person(name, age);
        person.setBirthday(new Date(1324141241231L));
        return person;
    }
}

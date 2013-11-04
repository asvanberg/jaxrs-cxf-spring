package com.svanberg.jaxrs.impl;

import com.svanberg.jaxrs.domain.Person;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class HelloWorldResourceImplIT {
    @Test
    public void hello_world() throws Exception {
        String hello = client().path("hello").get(String.class);

        assertEquals("Hello world!", hello);
    }

    @Test
    public void create_person() throws Exception {
        String name = "name";
        int age = 18;

        Person person = client()
                .path("hello")
                .path("person")
                .path(name)
                .path(age)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(Person.class);

        assertEquals(new Date(1324141241231L), person.getBirthday());
    }

    private WebClient client() {
        return WebClient.create("http://localhost:8080/rest",
                asList(new JacksonJaxbJsonProvider())
        );
    }
}

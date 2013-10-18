package com.svanberg.jaxrs.impl;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldResourceImplIT {
    @Test
    public void hello_world() throws Exception {
        String hello = client().path("hello").get(String.class);

        assertEquals("Hello world!", hello);
    }

    private WebClient client() {
        return WebClient.create("http://localhost:8080/rest");
    }
}

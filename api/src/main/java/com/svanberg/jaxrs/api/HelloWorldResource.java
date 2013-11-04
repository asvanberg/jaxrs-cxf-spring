package com.svanberg.jaxrs.api;

import com.svanberg.jaxrs.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * The first thing aliens will encounter when they stumble upon our planet.
 */
@Path("/hello")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface HelloWorldResource {

    /**
     * Say hello to everyone.
     *
     * @return a greeting appropriate for any number of recipients
     */
    @GET
    public String helloWorld();

    /**
     * Say hello to a specific person.
     *
     * @param name name of the person to greet
     * @return     a more formal greeting to make the person feel special
     */
    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name);

    /**
     * Create an appropriate representation of yourself to use in the future.
     *
     * @param name your name
     * @param age  your age
     * @return     the human representation of yourself
     */
    @GET
    @Path("/person/{name}/{age}")
    public Person person(@PathParam("name") String name, @PathParam("age") int age);
}

package com.svanberg.jaxrs.api;

import com.svanberg.jaxrs.domain.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The first thing aliens will encounter when they stumble upon our planet.
 */
@Path("/hello")
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
    @Produces("application/xml")
    public Person person(@PathParam("name") String name, @PathParam("age") int age);
}

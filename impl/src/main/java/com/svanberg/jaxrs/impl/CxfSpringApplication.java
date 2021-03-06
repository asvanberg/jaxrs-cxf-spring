package com.svanberg.jaxrs.impl;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class CxfSpringApplication implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(CxfSpringConfiguration.class);

        CXFServlet cxfServlet = servletContext.createServlet(CXFServlet.class);

        servletContext.addListener(new ContextLoaderListener(applicationContext));
        servletContext
                .addServlet("cxf", cxfServlet)
                .addMapping("/rest/*");
    }
}

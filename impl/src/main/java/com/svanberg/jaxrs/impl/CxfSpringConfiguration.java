package com.svanberg.jaxrs.impl;

import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.apache.cxf.jaxrs.spring.JAXRSServerFactoryBeanDefinitionParser.*;

@Configuration
@ComponentScan("com.svanberg.jaxrs.impl")
@ImportResource("classpath*:META-INF/cxf/cxf.xml")
public class CxfSpringConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CxfSpringConfiguration.class);

    @Bean(initMethod = "create")
    public SpringJAXRSServerFactoryBean jaxRs(ApplicationContext applicationContext) {
        SpringJAXRSServerFactoryBean factory = new SpringJAXRSServerFactoryBean();

        List<SpringResourceFactory> factories = new ArrayList<>();
        for (String resourceName : getResources(applicationContext)) {
            factories.add(new SpringResourceFactory(resourceName));
            Path path = applicationContext.findAnnotationOnBean(resourceName, Path.class);
            LOG.info("Registering resource: {} at [{}]", resourceName, path.value());
        }

        factory.setTempResourceProviders(factories);
        LOG.info("Resources registered: {}", factories.size());

        return factory;
    }

    private static Set<String> getResources(ApplicationContext applicationContext) {
        return applicationContext.getBeansWithAnnotation(Path.class).keySet();
    }
}

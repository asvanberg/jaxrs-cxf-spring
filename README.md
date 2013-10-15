jaxrs-cxf-spring
================

XML-less integration of [JAX-RS], [Apache CXF] and [Spring].

Classpath is scanned for beans annotated with @Path and they are exposed as resources in CXF.

Split up over three modules to give a clear separation between the domain, api and the implementation glueing the pieces together.

The api module consists of only interfaces with JAX-RS annotations and javadoc that together with [Enunciate] generate XSD and HTML documentation.

[JAX-RS]: https://jax-rs-spec.java.net/
[Apache CXF]: http://cxf.apache.org/
[Spring]: http://spring.io/
[Enunciate]: http://enunciate.codehaus.org/

jaxrs-cxf-spring
================

XML-less integration of JSR311, CXF and Spring.

Classpath is scanned for beans annotated with @Path and they are exposed as resources in CXF.

Split up over three modules to give a clear separation between the domain, api and the implementation glueing the pieces together.

The api module consists of only interfaces with JSR311 annotations and javadoc that together with Enunciate generate XSD schema and HTML documentation.

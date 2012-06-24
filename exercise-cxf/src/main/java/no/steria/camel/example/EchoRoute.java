package no.steria.camel.example;

import org.apache.camel.builder.RouteBuilder;

public class EchoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxf:bean:echoService?dataFormat=PAYLOAD")
                .log("${body}");
    }

}

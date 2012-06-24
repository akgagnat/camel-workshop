package no.steria.camel.example;

import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/data?noop=true")
                .choice()
                .when().xpath("/person/city = 'London'").log("UK message").to("file:target/messages/uk")
                .otherwise().log("Other message").to("file:target/messages/others")
                .end();
    }

}

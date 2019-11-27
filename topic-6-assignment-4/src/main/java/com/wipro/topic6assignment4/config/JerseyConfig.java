package com.wipro.topic6assignment4.config;

import com.wipro.topic6assignment4.controller.CredCardController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(CredCardController.class);
    }
}

package com.wipro.topic6assignment1.config;

import com.wipro.topic6assignment1.controller.MovieController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MovieController.class);
    }
}

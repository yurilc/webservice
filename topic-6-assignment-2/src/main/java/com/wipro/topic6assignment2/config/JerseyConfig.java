package com.wipro.topic6assignment2.config;

import com.wipro.topic6assignment2.controller.StudentController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(StudentController.class);
    }
}

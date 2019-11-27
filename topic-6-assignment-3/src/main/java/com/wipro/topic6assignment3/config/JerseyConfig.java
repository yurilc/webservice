package com.wipro.topic6assignment3.config;

import com.wipro.topic6assignment3.controller.StudentController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(StudentController.class);
    }
}

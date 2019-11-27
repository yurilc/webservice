package com.wipro.topic7assignment1.config;

import com.wipro.topic7assignment1.controller.EmployeeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(EmployeeController.class);
    }
}

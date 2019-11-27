package com.wipro.topic6assignment4.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/credcard")
public class CredCardController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean validate(BigDecimal credcard) {
        return credcard.remainder(new BigDecimal(2)).intValue() == 0;
    }
}

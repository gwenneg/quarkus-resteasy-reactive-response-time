package org.acme.resteasyjackson;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonResource {

    @GET
    @Path("/uni")
    public Uni<List<Integer>> getUni() {
        return buildMulti().collect().asList();
    }

    @GET
    @Path("/multi")
    public Multi<Integer> getMulti() {
        return buildMulti();
    }

    private Multi<Integer> buildMulti() {
        return Multi.createFrom().items(1, 2, 3);
    }
}

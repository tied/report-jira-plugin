package com.atlassian.plugins.report.rest;

import com.atlassian.plugins.report.webwork.ReportWebworkAction;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/events-restful-table/")
public class RestfulTableController {

    private List<RestfulTableRowModel> storage = new ArrayList<>();

    @GET
    @Path("/all")
    public Response getAllEvents() {
        return Response.ok(storage.stream()
                .sorted(Comparator.comparing(RestfulTableRowModel::getId).reversed())
                .collect(Collectors.toList())).build();
    }

    @GET
    @Path("/self/{id}")
    public Response getEvent(@PathParam("id") String id) {
        return Response.ok(findInStorage(id)).build();
    }

    @PUT
    @Path("/self/{id}")
    public Response updateEvent(@PathParam("id") String id, RestfulTableRowModel update) {
        RestfulTableRowModel model = findInStorage(id);
        Optional.ofNullable(update.getName()).ifPresent(model::setName);
        Optional.ofNullable(update.getSalary()).ifPresent(model::setSalary);
        Optional.ofNullable(update.getClosedClockFix()).ifPresent(model::setClosedClockFix);
        Optional.ofNullable(update.getRollingHours()).ifPresent(model::setRollingHours);

        return Response.ok(model).build();
    }

    @POST
    @Path("/self")
    public Response createEvent(RestfulTableRowModel model) {
        model.setId(generateNewId());
        storage.add(model);
        return Response.ok(model).build();
    }

    @DELETE
    @Path("/self/{id}")
    public Response deleteEvent(@PathParam("id") String id) {
        storage.remove(findInStorage(id));
        return Response.ok().build();
    }

    private RestfulTableRowModel findInStorage(String id) {
        return storage.stream()
                .filter(item -> item.getId() == Long.valueOf(id))
                .findAny()
                .orElse(null);
    }

    private long generateNewId() {
        return storage.stream()
                .mapToLong(RestfulTableRowModel::getId)
                .max().orElse(0) + 1;
    }

}

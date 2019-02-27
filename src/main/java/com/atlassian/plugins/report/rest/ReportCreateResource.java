package com.atlassian.plugins.report.rest;

import com.atlassian.jira.util.json.JSONException;
import com.atlassian.jira.util.json.JSONObject;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/message")
public class ReportCreateResource {

    @POST
    @AnonymousAllowed
    @Consumes({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/name")
    public Response getMessage(String data)
    {
        return Response.ok(data).build();
    }
}
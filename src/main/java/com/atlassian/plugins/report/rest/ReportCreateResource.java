package com.atlassian.plugins.report.rest;


import com.atlassian.plugins.report.restWebworkConnector;
import com.atlassian.plugins.report.webwork.ReportWebworkAction;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/message")
public class ReportCreateResource {


    @Named
    @POST
    @AnonymousAllowed
    @Consumes({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/name")
    public Response getMessage(String data)
    {
//        ReportWebworkAction.setTest("data");
//            restWebworkConnector testConnector = new restWebworkConnector();
            Object obj = new JsonParser().parse(data);
            JsonObject jo = (JsonObject) obj;
            String salary = jo.get("salary").toString();
            String closedClockFix = jo.get("closedClockFix").toString();
            String rollingHours = jo.get("rollingHours").toString();
            salary = salary.substring(1, salary.length() - 1);
            closedClockFix = closedClockFix.substring(1, closedClockFix.length() - 1);
            rollingHours = rollingHours.substring(1, rollingHours.length() - 1);
            Double salaryInt = Double.parseDouble(salary);
            Double closedClockFixInt = Double.parseDouble(closedClockFix);
            Double rollingHoursInt = Double.parseDouble(rollingHours);
            ReportWebworkAction.createReport(salaryInt,closedClockFixInt,rollingHoursInt);
            return Response.ok(data).build();

    }


}
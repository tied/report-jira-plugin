package com.atlassian.plugins.report.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportCreateResourceModel {

    @XmlElement(name = "value")
    private String message;

    public ReportCreateResourceModel() {
    }

    public ReportCreateResourceModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
package com.atlassian.plugins.report.rest;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RestfulTableRowModel {

    @XmlElement(name = "id")
    private long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "salary")
    private Integer salary;

    @XmlElement(name = "closedClockFix")
    private Integer closedClockFix;

    @XmlElement(name = "rollingHours")
    private Integer rollingHours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getClosedClockFix() {
        return closedClockFix;
    }

    public void setClosedClockFix(Integer closedClockFix) {
        this.closedClockFix = closedClockFix;
    }

    public Integer getRollingHours() {
        return rollingHours;
    }

    public void setRollingHours(Integer rollingHours) {
        this.rollingHours = rollingHours;
    }
}

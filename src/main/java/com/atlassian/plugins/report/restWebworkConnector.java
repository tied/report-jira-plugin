package com.atlassian.plugins.report;

import com.atlassian.plugins.report.webwork.ReportWebworkAction;

public class restWebworkConnector {

    private Double salary;

    private Double closedClockFix;

    private Double rollingHours;

    private Double normaly;

    private Double premium;

    public restWebworkConnector() {
    }

    public restWebworkConnector(Double salary, Double closedClockFix, Double rollingHours) {
        this.salary = salary;
        this.closedClockFix = closedClockFix;
        this.rollingHours = rollingHours;
    }

    public restWebworkConnector(Double salary, Double closedClockFix, Double rollingHours, Double normaly, Double premium) {
        this.salary = salary;
        this.closedClockFix = closedClockFix;
        this.rollingHours = rollingHours;
        this.normaly = normaly;
        this.premium = premium;
    }

//    public void resultConnector(restWebworkConnector rwc){
//
//        ReportWebworkAction.createReport(rwc.getSalary(),rwc.getClosedClockFix(),rwc.getRollingHours());
//
//    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getClosedClockFix() {
        return closedClockFix;
    }

    public void setClosedClockFix(Double closedClockFix) {
        this.closedClockFix = closedClockFix;
    }

    public Double getRollingHours() {
        return rollingHours;
    }

    public void setRollingHours(Double rollingHours) {
        this.rollingHours = rollingHours;
    }

    public Double getNormaly() {
        return normaly;
    }

    public void setNormaly(Double normaly) {
        this.normaly = normaly;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }
}

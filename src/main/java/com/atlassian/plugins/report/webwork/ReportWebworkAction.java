package com.atlassian.plugins.report.webwork;

import com.atlassian.plugins.report.rest.ReportCreateResourceModel;
import com.atlassian.plugins.report.restWebworkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import webwork.action.standard.Redirect;
import javax.ws.rs.core.Response;

public class ReportWebworkAction extends JiraWebActionSupport
{

    private ReportCreateResourceModel reportCreateResourceModel = new ReportCreateResourceModel();

    private static final Logger log = LoggerFactory.getLogger(ReportWebworkAction.class);

    private restWebworkConnector result;

    private static Double salary;

    private static Double closedClockFix;

    private static Double rollingHours;

    private Double normaly;

    private Double premium;

    @Override
    public String execute() throws Exception {
//
        if(salary!=null && closedClockFix!=null && rollingHours!=null){
            setNormaly(salary*0.5);
            setPremium((salary*0.5)+closedClockFix-rollingHours);
            setSalary(null);
            setClosedClockFix(null);
            setRollingHours(null);
        }


        return "report-success"; //returns SUCCESS
    }


    public static void createReport(Double salary1, Double closedClockFix1, Double rollingHours1){

        setSalary(salary1);
        setClosedClockFix(closedClockFix1);
        setRollingHours(rollingHours1);

//        Double norm = salary*0.5;
//
//        setNormaly(norm);
//

//        return "report-success";
    }

    public static Double getSalary() {
        return salary;
    }

    public static void setSalary(Double salary) {
        ReportWebworkAction.salary = salary;
    }

    public static Double getClosedClockFix() {
        return closedClockFix;
    }

    public static void setClosedClockFix(Double closedClockFix) {
        ReportWebworkAction.closedClockFix = closedClockFix;
    }

    public static Double getRollingHours() {
        return rollingHours;
    }

    public static void setRollingHours(Double rollingHours) {
        ReportWebworkAction.rollingHours = rollingHours;
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

package com.atlassian.plugins.report.webwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

public class ReportWebworkAction extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(ReportWebworkAction.class);

    @Override
    public String execute() throws Exception {

        return "report-success"; //returns SUCCESS
    }
}

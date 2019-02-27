package it.com.atlassian.plugins.report.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.plugins.report.rest.ReportCreateResource;
import com.atlassian.plugins.report.rest.ReportCreateResourceModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class ReportCreateResourceFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/report/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        ReportCreateResourceModel message = resource.get(ReportCreateResourceModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}

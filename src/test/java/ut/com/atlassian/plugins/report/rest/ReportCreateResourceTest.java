package ut.com.atlassian.plugins.report.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.plugins.report.rest.ReportCreateResource;
import com.atlassian.plugins.report.rest.ReportCreateResourceModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class ReportCreateResourceTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        ReportCreateResource resource = new ReportCreateResource();

        Response response = resource.getMessage();
        final ReportCreateResourceModel message = (ReportCreateResourceModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}

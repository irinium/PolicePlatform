package e2e;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.policePlatform.Application;
import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.config.WebSecurityConfig;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("e2e")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {E2ETestConfiguration.class, WebSecurityConfig.class})
public class PoliceReportsE2ETest {

    @Autowired
    private WebApplicationContext wac;


    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(wac, springSecurity());
    }

    @Test
    public void createPoliceReportRequestTest() throws JsonProcessingException {
        final PoliceReportRequest request = createPoliceReportRequest();
        final PoliceReportResponse response = given()
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(request))
            .when()
            .post("/api/v1/police-reports")
            .then()
            .statusCode(SC_OK)
            .and()
            .extract()
            .response()
            .as(PoliceReportResponse.class);
        assertThat(response.getId(), is(notNullValue()));
        assertThat(response.getAssignee(), is(nullValue()));
        assertThat(response.getEo(), equalTo(request.getEo()));
        assertThat(response.getDecision(), equalTo(request.getDecision()));
        assertThat(response.getStory(), equalTo(request.getStory()));
        assertThat(response.getDeclarant(), equalTo(request.getDeclarant()));
        assertThat(response.getCommissionPlace(), equalTo(request.getCommissionPlace()));
        assertThat(response.getFullName(), equalTo(request.getFullName()));
        assertThat(response.getResults(), equalTo(request.getResults()));
    }

    @Test
    public void getPoliceReportTest() {
        final PoliceReportResponse response = given()
            .when()
            .get("/api/v1/police-reports/1")
            .then()
            .statusCode(SC_OK)
            .and()
            .extract()
            .response()
            .as(PoliceReportResponse.class);
    }

    private PoliceReportRequest createPoliceReportRequest() {
        final Long eo = 42L;
        final String decision = "decision";
        final String story = "story";
        final String declarant = "declarant";
        final String commissionPlace = "commissionPlace";
        final String fullName = "fullName";
        final String results = "results";
        return new PoliceReportRequest()
            .setEo(eo)
            .setDecision(decision)
            .setStory(story)
            .setDeclarant(declarant)
            .setCommissionPlace(commissionPlace)
            .setFullName(fullName)
            .setResults(results);
    }
}

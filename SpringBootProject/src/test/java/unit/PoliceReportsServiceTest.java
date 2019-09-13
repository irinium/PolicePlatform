package unit;

import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.domain.repositories.PoliceReportRepository;
import com.policePlatform.services.PoliceReportServiceImpl;
import com.policePlatform.services.specifications.PoliceReportSearchSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PoliceReportsServiceTest {

    @Mock
    PoliceReportRepository policeReportRepository;
    @Mock
    PoliceReportSearchSpecification policeReportSearchSpecification;

    @Captor
    ArgumentCaptor<PoliceReport> policeReportCaptor;

    @InjectMocks
    private PoliceReportServiceImpl policeReportService;

    @Test
    public void createPoliceReportTest() {
        final Long eo = 42L;
        final String decision = "decision";
        final String story = "story";
        final String declarant = "declarant";
        final String commissionPlace = "commissionPlace";
        final String fullName = "fullName";
        final String results = "results";
        final PoliceReportRequest request = new PoliceReportRequest()
            .setEo(eo)
            .setDecision(decision)
            .setStory(story)
            .setDeclarant(declarant)
            .setCommissionPlace(commissionPlace)
            .setFullName(fullName)
            .setResults(results);
        when(policeReportRepository.save(policeReportCaptor.capture())).then(invocation -> invocation.getArgument(0));
        policeReportService.createPoliceReport(request);
        final PoliceReport actual = policeReportCaptor.getValue();
        assertThat(actual.getId(), is(nullValue()));
        assertThat(actual.getAssignee(), is(nullValue()));
        assertThat(actual.getEo(), equalTo(eo));
        assertThat(actual.getDecision(), equalTo(decision));
        assertThat(actual.getStory(), equalTo(story));
        assertThat(actual.getDeclarant(), equalTo(declarant));
        assertThat(actual.getCommissionPlace(), equalTo(commissionPlace));
        assertThat(actual.getFullName(), equalTo(fullName));
        assertThat(actual.getResults(), equalTo(results));
    }

    @Test
    public void getPoliceReportTest(){

        final PoliceReport report = new PoliceReport();
        report.setId(1L);
        report.setDecision("decision");

        when(policeReportRepository.findById(report.getId())).thenReturn(of(report));
        final PoliceReportResponse response = policeReportService.getPoliceReport(report.getId());

        assertThat(report.getId(), equalTo(response.getId()));
        assertThat(report.getDecision(), equalTo(response.getDecision()));

    }

    @Test
    public void updatePoliceReportTest(){
        final PoliceReport report = new PoliceReport();
        report.setId(1L);
        report.setDecision("decision");
        report.setStory("story");

        final String story = "update";
        final PoliceReportRequest request = new PoliceReportRequest()
                .setStory(story);

        when(policeReportRepository.findById(report.getId())).thenReturn(of(report));
        when(policeReportRepository.save(policeReportCaptor.capture())).then(invocation -> invocation.getArgument(0));
        policeReportService.updatePoliceReport(report.getId(), request);

        final PoliceReport actual = policeReportCaptor.getValue();

        assertThat(actual, equalTo(report));

    }

    @Test
    public void deletePoliceReportTest(){
        final Long id = 1L;

        policeReportService.deletePoliceReport(id);
        verify(policeReportRepository, times(1)).deleteById(eq(id));

    }
}

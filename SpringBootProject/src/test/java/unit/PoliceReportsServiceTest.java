package unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.policePlatform.api.rest.dto.PoliceReportRequest;
import com.policePlatform.api.rest.dto.PoliceReportResponse;
import com.policePlatform.api.rest.dto.PoliceReportSearchRequest;
import com.policePlatform.domain.model.PoliceEmployee;
import com.policePlatform.domain.model.PoliceReport;
import com.policePlatform.domain.repositories.PoliceEmployeeRepository;
import com.policePlatform.domain.repositories.PoliceReportRepository;
import com.policePlatform.mapping.PoliceReportsMapper;
import com.policePlatform.mapping.PoliceReportsMapperImpl;
import com.policePlatform.services.PoliceReportServiceImpl;
import com.policePlatform.services.specifications.PoliceReportSearchSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PoliceReportsServiceTest {

    @Mock
    PoliceReportRepository policeReportRepository;

    @Mock
    PoliceReportSearchSpecification policeReportSearchSpecification;

    @Mock
    PoliceEmployeeRepository policeEmployeeRepository;
    @Captor
    ArgumentCaptor<PoliceReport> policeReportCaptor;

    @InjectMocks
    private PoliceReportServiceImpl policeReportService;

    @InjectMocks
    private PoliceReportsMapper mapper = new PoliceReportsMapperImpl();

    @Test
    public void createPoliceReportTest() {
        PoliceEmployee employee = new PoliceEmployee();
        employee.setId(1L);
        employee.setUuid("uuid");
        employee.setPassword("$2a$10$OReIVA7c8/R2YUVxWaDfg.IS/hZpnlxuKDN5ayCDJiWQ84zVA5f/y");
        employee.setName("name");
        employee.setLastName("lastName");

        final Long eo = 42L;
        final Long assignee = 1L;
        final String decision = "decision";
        final String story = "story";
        final String declarant = "declarant";
        final String commissionPlace = "commissionPlace";
        final String fullName = "fullName";
        final String results = "results";
        final PoliceReportRequest request = new PoliceReportRequest()
                .setEo(eo)
                .setAssignee(assignee)
                .setDecision(decision)
                .setStory(story)
                .setDeclarant(declarant)
                .setCommissionPlace(commissionPlace)
                .setFullName(fullName)
                .setResults(results);

        when(policeEmployeeRepository.findById(request.getAssignee())).thenReturn(Optional.of(employee));
        when(policeReportRepository.save(policeReportCaptor.capture())).then(invocation -> invocation.getArgument(0));
        policeReportService.createPoliceReport(request);
        final PoliceReport actual = policeReportCaptor.getValue();
        assertThat(actual.getId(), is(nullValue()));
        assertThat(actual.getAssignee(), equalTo(employee));
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

        when(policeReportRepository.findById(report.getId())).thenReturn(Optional.of(report));
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

        when(policeReportRepository.findById(report.getId())).thenReturn(Optional.of(report));
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

    @Test
    public void searchPoliceReports(){
        final PoliceReport report = new PoliceReport();
        report.setId(1L);
        report.setEo(1L);
        report.setAssignee(new PoliceEmployee());
        report.setResults("result");
        report.setFullName("fullName");
        report.setCommissionPlace("commissionPlace");
        report.setStory("story");
        report.setDeclarant("declarant");
        report.setDecision("decision");
        final Page<PoliceReport> pagePoliceReport = new PageImpl<>(List.of(report));
        final PoliceReportSearchRequest searchRequest = new PoliceReportSearchRequest();
        searchRequest.setStory("story");
        final PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(
                Sort.Order.asc("id")));
        when(policeReportRepository.findAll(policeReportSearchSpecification.getSpecification(searchRequest), pageRequest))
                .thenReturn(pagePoliceReport);
        final Page<PoliceReportResponse> page = policeReportService.searchPoliceReports(searchRequest, pageRequest);
        assertThat(page.getTotalElements(), equalTo(pagePoliceReport.getTotalElements()));
        assertThat(page.getTotalPages(), equalTo(pagePoliceReport.getTotalPages()));
        assertThat(page.getContent(), equalTo(pagePoliceReport.map(mapper::toResponse).getContent()));
    }
}

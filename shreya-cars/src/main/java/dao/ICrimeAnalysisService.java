package dao;

import java.util.List;
import entity.Incidents;
import exception.IncidentNumberNotFoundException;

public interface ICrimeAnalysisService {

    List<Incidents> searchIncidentsByType(String incidentType);

    List<Incidents> getIncidentsInDateRange(String startDateStr, String endDateStr);

    boolean updateIncidentStatus(int incidentId, String status) throws IncidentNumberNotFoundException;

    boolean createIncident(Incidents incident);

    Object generateIncidentReport(Incidents incident, int reportingOfficer);

    Incidents getIncidentById(int incidentId);

}
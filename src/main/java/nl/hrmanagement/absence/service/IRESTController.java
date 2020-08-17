package nl.hrmanagement.absence.service;

import nl.hrmanagement.absence.dto.AbsenceRequestDTO;
import nl.hrmanagement.absence.dto.CancelRequestDTO;
import nl.hrmanagement.absence.dto.UpdateAbsenceStatusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface IRESTController {

    ResponseEntity requestAbsence(AbsenceRequestDTO dto);
    ResponseEntity cancelAbsence(CancelRequestDTO dto);
    ResponseEntity retrieveAllAbsence(UUID id);
    ResponseEntity retrieveAllOpenAbsence(UUID companyId);
    ResponseEntity updateAbsenceStatus(UpdateAbsenceStatusDTO dto);
    ResponseEntity retrieveDashboardData_CurrentAbsence(UUID id);
    ResponseEntity retrieveOpenAbsenceData(UUID id);
}

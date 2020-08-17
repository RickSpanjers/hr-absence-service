package nl.hrmanagement.absence.service;

import nl.hrmanagement.absence.dto.AbsenceRequestDTO;
import nl.hrmanagement.absence.dto.CancelRequestDTO;
import nl.hrmanagement.absence.dto.GenericResponseDTO;
import nl.hrmanagement.absence.dto.UpdateAbsenceStatusDTO;
import java.util.UUID;

public interface IServiceProvider {

    GenericResponseDTO requestAbsence(AbsenceRequestDTO dto);
    GenericResponseDTO cancelAbsence(CancelRequestDTO dto);
    GenericResponseDTO retrieveAbsenceRequests(UUID userId);
    GenericResponseDTO retrieveOpenAbsence(UUID companyId);
    GenericResponseDTO updateAbsenceStatus(UpdateAbsenceStatusDTO dto);
    GenericResponseDTO retrieveDashboardData_CurrentAbsence(UUID companyId);
    GenericResponseDTO retrieveOpenAbsenceRequestData(UUID companyId);


}

package nl.hrmanagement.absence.service.impl;

import com.google.gson.Gson;
import nl.hrmanagement.absence.dto.*;
import nl.hrmanagement.absence.model.Absence;
import nl.hrmanagement.absence.model.AbsenceStatus;
import nl.hrmanagement.absence.model.AbsenceType;
import nl.hrmanagement.absence.repository.*;
import nl.hrmanagement.absence.service.IServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.*;
import java.util.List;
import java.util.UUID;

@Service
public class AbsenceServiceProvider implements IServiceProvider {

    @Autowired
    private AbsenceRepository absenceRepository;

//    @Autowired
//    private AbsenceCassandraRepository absenceCassandraRepository;

    private Logger logger = LoggerFactory.getLogger(AbsenceServiceProvider.class);
    private Gson gson = new Gson();

    @Override
    public GenericResponseDTO requestAbsence(@NotNull AbsenceRequestDTO dto) {
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", "Could not request absence. Did you enter all the fields completely?");
        if(dto.getUserId() != null) {
            if (validateAbsenceRequest(dto)) {
                AbsenceType typeEnum = AbsenceType.valueOf(dto.getAbsenceType());
                Absence absence = new Absence(0, dto.getStartDate(), dto.getEndDate(), typeEnum, AbsenceStatus.INPROCESS, dto.getReason(), dto.getUserId(), dto.getCompanyId());
                absenceRepository.save(absence);
                result = new GenericResponseDTO(true, null, "Successfully requested Absence");
            }
        }
        return result;
    }

    @Override
    public GenericResponseDTO cancelAbsence(@NotNull CancelRequestDTO dto) {
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getUserId() != null && dto.getRequestId() != 0) {
                Absence absence = absenceRepository.findById(dto.getRequestId());
                absence.setStatus(AbsenceStatus.CANCELLED);
                absenceRepository.save(absence);
                result = new GenericResponseDTO(true, null, "Successfully cancelled");

        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveAbsenceRequests(UUID userId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(userId != null){
            List<Absence> absences =  absenceRepository.findAllByUserId(userId);
            result = new GenericResponseDTO(true, absences, "Successfully retrieved absence requests");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveOpenAbsence(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", "There are currently no open requests");
        if(companyId != null){
            List<Absence> absenceList = absenceRepository.findAllByCompanyIdAndStatus(companyId, AbsenceStatus.INPROCESS);
            result = new GenericResponseDTO(true, absenceList, "Successfully retrieved absence requests");
        }
        return result;
    }

    @Override
    public GenericResponseDTO updateAbsenceStatus(UpdateAbsenceStatusDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, null, "Unable to update status. Are you sure you selected a new status?");
        if(dto.getAbsenceId() != 0 && !dto.getAbsenceStatus().equals("None")){
            Absence absence = absenceRepository.findById(dto.getAbsenceId());
            absence.setStatus(AbsenceStatus.valueOf(dto.getAbsenceStatus()));
            absenceRepository.save(absence);
            result = new GenericResponseDTO(true, absence, "Successfully updated absence request");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveDashboardData_CurrentAbsence(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, null, "Unable to retrieve absence!");
        if(companyId != null){
            java.util.Date date = new java.util.Date();
            int absenceTotal = absenceRepository.countAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndCompanyIdAndStatus(date, date, companyId, AbsenceStatus.APPROVED);
            result = new GenericResponseDTO(true, absenceTotal, "Successfully retrieved absences");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveOpenAbsenceRequestData(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, null, "Unable to retrieve open absence!");
        if(companyId != null){
            int absenceTotal = absenceRepository.countAllByCompanyIdAndStatus(companyId, AbsenceStatus.INPROCESS);
            result = new GenericResponseDTO(true, absenceTotal, "Successfully retrieved open absence requests");
        }
        return result;
    }

    private boolean validateAbsenceRequest(AbsenceRequestDTO dto){
        boolean result = false;
        if(dto.getStartDate() != null && dto.getEndDate() != null){
            if(dto.getStartDate().before(dto.getEndDate())){
                if(dto.getStartDate().after(Timestamp.valueOf(LocalDateTime.now()))){
                    if(!dto.getStartDate().equals(dto.getEndDate())){
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public boolean deleteAllAbsenceRequestsUser(UUID userId){
        boolean result = false;
        if(userId != null){
            absenceRepository.deleteAllByUserId(userId);
            result = true;
        }
        return result;
    }


}

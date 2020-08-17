package nl.hrmanagement.absence.service.impl;

import com.google.gson.Gson;
import nl.hrmanagement.absence.dto.*;
import nl.hrmanagement.absence.service.IRESTController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
public class AbsenceController implements IRESTController {

    @Autowired
    private AbsenceServiceProvider absenceServiceProvider;
    private Gson gson = new Gson();

    @Override
    @PostMapping(
            path = "/request",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity requestAbsence(@NotNull @RequestBody AbsenceRequestDTO dto){
        String body = gson.toJson(absenceServiceProvider.requestAbsence(dto));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/cancel",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity cancelAbsence(@NotNull @RequestBody CancelRequestDTO dto){
        String body = gson.toJson(absenceServiceProvider.cancelAbsence(dto));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveAllAbsence(@PathVariable UUID id) {
        String body = gson.toJson(absenceServiceProvider.retrieveAbsenceRequests(id));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/openRequests/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity retrieveAllOpenAbsence(@PathVariable UUID companyId) {
        String body = gson.toJson(absenceServiceProvider.retrieveOpenAbsence(companyId));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateAbsenceStatus(@NotNull @RequestBody UpdateAbsenceStatusDTO dto){
        String body = gson.toJson(absenceServiceProvider.updateAbsenceStatus(dto));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/retrieveDashboardData/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveDashboardData_CurrentAbsence(@PathVariable UUID id) {
        String body = gson.toJson(absenceServiceProvider.retrieveDashboardData_CurrentAbsence(id));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/retrieveOpenAbsenceDashboardData/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveOpenAbsenceData(@PathVariable UUID id) {
        String body = gson.toJson(absenceServiceProvider.retrieveOpenAbsenceRequestData(id));
        return generateRequestResponse(body);
    }

    private ResponseEntity generateRequestResponse(String body){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        headers.add("Responded", "Absence Service");
        if(body != null){
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(body, headers, status);
    }

}

package nl.hrmanagement.absence;

import nl.hrmanagement.absence.dto.*;
import nl.hrmanagement.absence.service.impl.AbsenceServiceProvider;
import org.hibernate.service.spi.ServiceException;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.Assert.assertFalse;

/**
 * @author Rick Spanjers
 * @since 21/10/2019
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestAbsenceApplication {

	@InjectMocks
	private AbsenceServiceProvider absenceServiceProvider;

	@Before
	public void setUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		MockitoAnnotations.initMocks(this);
	}

	public TestAbsenceApplication() throws ServiceException {

	}

	@org.junit.Test
	public void necessaryTest(){

	}

	@Test
	public void setupContext(){

	}

	@Test()
	public void testRequestAbsence_NoUserId(){
		AbsenceRequestDTO request = new AbsenceRequestDTO(UUID.randomUUID(), UUID.randomUUID(), "VACATION", "VACATION", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
		GenericResponseDTO actualResult = absenceServiceProvider.requestAbsence(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testRequestAbsence_NoStartDate(){
        AbsenceRequestDTO request = new AbsenceRequestDTO(UUID.randomUUID(), UUID.randomUUID(), "VACATION", "VACATION", null, Timestamp.valueOf(LocalDateTime.now()));
		GenericResponseDTO actualResult = absenceServiceProvider.requestAbsence(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testRequestAbsence_NoEndDate(){
        AbsenceRequestDTO request = new AbsenceRequestDTO(UUID.randomUUID(), UUID.randomUUID(), "VACATION", "VACATION", Timestamp.valueOf(LocalDateTime.now()), null);
		GenericResponseDTO actualResult = absenceServiceProvider.requestAbsence(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testRequestAbsence_NoReason(){
        AbsenceRequestDTO request = new AbsenceRequestDTO(UUID.randomUUID(), UUID.randomUUID(), null, "VACATION", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
		GenericResponseDTO actualResult = absenceServiceProvider.requestAbsence(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testRequestAbsence_NoType(){
        AbsenceRequestDTO request = new AbsenceRequestDTO(UUID.randomUUID(), UUID.randomUUID(), "VACATION", null, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
		GenericResponseDTO actualResult = absenceServiceProvider.requestAbsence(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testUpdateAbsenceStatus_NoAbsenceId(){
		UpdateAbsenceStatusDTO request = new UpdateAbsenceStatusDTO(0,"APPROVED");
		GenericResponseDTO actualResult = absenceServiceProvider.updateAbsenceStatus(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testUpdateAbsenceStatus_NoStatus(){
		UpdateAbsenceStatusDTO request = new UpdateAbsenceStatusDTO(0,null);
		GenericResponseDTO actualResult = absenceServiceProvider.updateAbsenceStatus(request);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testUpdateAbsenceStatus_WrongStatus(){
		UpdateAbsenceStatusDTO request = new UpdateAbsenceStatusDTO(0,"None");
		GenericResponseDTO actualResult = absenceServiceProvider.updateAbsenceStatus(request);
		assertFalse(actualResult.getSuccess());
	}

}

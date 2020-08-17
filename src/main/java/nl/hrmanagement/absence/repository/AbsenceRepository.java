package nl.hrmanagement.absence.repository;

import nl.hrmanagement.absence.model.Absence;
import nl.hrmanagement.absence.model.AbsenceStatus;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.UUID;

@Repository

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {

    Absence findById(int id);

    List<Absence> findAllByUserId(UUID userId);

    int countAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndCompanyIdAndStatus(java.util.Date start, java.util.Date end, UUID companyId, AbsenceStatus status);

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    int countAllByCompanyIdAndStatus(UUID companyId, AbsenceStatus status);

    @Transactional
    void deleteAllByUserId(UUID userId);

    List<Absence> findAllByCompanyIdAndStatus(UUID companyId, AbsenceStatus status);

}

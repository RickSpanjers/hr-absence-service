//package nl.hrmanagement.absence.repository;
//
//import nl.hrmanagement.absence.model.AbsenceCassandra;
//import nl.hrmanagement.absence.model.AbsenceStatus;
//import org.springframework.data.cassandra.repository.AllowFiltering;
//import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.UUID;
//
//public interface AbsenceCassandraRepository extends CassandraRepository<AbsenceCassandra, UUID> {
//
//    @AllowFiltering
//    List<AbsenceCassandra> findAllByUserId(UUID userId);
//
//    List<AbsenceCassandra> findByReasonContaining(String text);
//
//    @AllowFiltering
//    AbsenceCassandra findById(int id);
//
//    @AllowFiltering
//    int countAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndCompanyIdAndStatus(java.util.Date start, java.util.Date end, UUID companyId, AbsenceStatus status);
//
//    @AllowFiltering
//    int countAllByCompanyIdAndStatus(UUID companyId, AbsenceStatus status);
//
//    @AllowFiltering
//    @Transactional
//    void deleteAllByUserId(UUID userId);
//
//    @AllowFiltering
//    List<AbsenceCassandra> findAllByCompanyIdAndStatus(UUID companyId, AbsenceStatus status);
//}

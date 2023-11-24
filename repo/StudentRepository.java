package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StudentProfile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentProfile, Long> {
  Optional<StudentProfile> findByEmail(String email);

  Optional<StudentProfile> findByEnrollmentId(String enrollmentId);

  Optional<StudentProfile> findByUserId(Long id);

  Optional<StudentProfile> findByUserId(String id);


  boolean existsByEnrollmentIdAndMobileNoAndDob(String username, long l, Date dob);

  Optional<StudentProfile> findByEnrollmentIdAndMobileNoAndDob(String username, long mobileNo,
          Date dob);

  Optional<StudentProfile> findByMobileNo(long mobileNo);

  List<StudentProfile> findByCourseId(String course);
}

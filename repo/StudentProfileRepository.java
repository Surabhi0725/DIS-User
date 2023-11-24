package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StudentProfile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends CrudRepository<StudentProfile, Long> {
  Optional<StudentProfile> findByEmail(String email);

  Optional<StudentProfile> findByEnrollmentId(String enrollmentId);

  Optional<StudentProfile> findByUserId(String id);

  boolean existsByEnrollmentIdAndMobileNoAndDob(String username, long l, Date dob);

  Optional<StudentProfile> findByEnrollmentIdAndMobileNoAndDob(String username, long mobileNo,
          Date dob);

  Optional<StudentProfile> findByMobileNo(long mobileNo);

  List<StudentProfile> findByUserIdIn(Iterable<String> ids);

  List<StudentProfile> findByCourseIdAndAdmissionYear(String courseId, int admissionYear);

  @Query(value = "SELECT * FROM user.student_profile WHERE user.student_profile.course_id = ?1 AND user.student_profile.admission_year = ?2 AND user.student_profile.user_id IS NOT NULL", nativeQuery = true)
  List<StudentProfile> findByCourseIdAndAdmissionYearNotNull(String courseId, int admissionYear);

  boolean existsByEnrollmentId(String enrollmentId);
}

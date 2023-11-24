package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StudentAttendance;

import java.util.List;

@Repository()
public interface StudentAttendanceRepository extends CrudRepository<StudentAttendance, Long> {
  List<StudentAttendance> findByEnrollmentIdAndSubjectCode(String enrollmentId, String subjectCode);

  int countByEnrollmentIdAndSubjectCodeAndClassType(String enrollmentId, String subjectCode,
          char classType);

  int countByEnrollmentIdAndSubjectCodeAndClassTypeAndAttendance(String enrollmentId,
          String subjectCode, char classType, char attendance);
}

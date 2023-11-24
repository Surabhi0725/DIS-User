package sgsits.cse.dis.user.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.repo.StudentProfileRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class StudentProfileRepo {

  private final StudentProfileRepository studentProfileRepository;

  @Autowired
  /*Simple constructor*/
  public StudentProfileRepo(final StudentProfileRepository studentProfileRepository) {
    this.studentProfileRepository = studentProfileRepository;
  }

  /* Return student if exists of the given user id*/
  public StudentProfile getStudentProfileUsingUserId(final String userId)
          throws InternalServerError {

    try {
      final Optional<StudentProfile> optionalStudentProfile = studentProfileRepository.findByUserId(
              userId);

      if (optionalStudentProfile.isPresent()) {
        return optionalStudentProfile.get();
      } else {
        throw new NoSuchElementException("Student with the given userId not found");
      }
    } catch (Exception e) {
      throw new InternalServerError("Could not fetch Student Profile");
    }
  }

  /* If studentProfile exists then update else add the profile*/
  public void addOrUpdateStudentProfile(final StudentProfile studentProfile)
          throws InternalServerError {

    try {
      System.out.println(studentProfile.getSchemeYear() + " " + studentProfile.getSchemeSemester());
      if (studentProfileRepository.existsByEnrollmentId(studentProfile.getEnrollmentId())) {
        StudentProfile student = studentProfileRepository.findByEnrollmentId(
                studentProfile.getEnrollmentId()).get();
        studentProfile.setId(student.getId());
      }
      studentProfileRepository.save(studentProfile);
    } catch (Exception e) {
      System.out.println(e);
      throw new InternalServerError("Cannot add or update student Profile");
    }
  }

  /* Store list of all given students in repo*/
  public void saveAll(List<StudentProfile> students) throws InternalServerError {
    try {
      studentProfileRepository.saveAll(students);
    } catch (Exception e) {
      throw new InternalServerError("Cannot add or update student Profile");
    }
  }
}
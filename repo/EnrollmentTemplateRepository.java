package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.EnrollmentTemplate;

import java.util.Optional;

@Repository("enrollmentTemplateRepository")
public interface EnrollmentTemplateRepository extends CrudRepository<EnrollmentTemplate, String> {
  boolean existsById(String id);

  @Modifying
  void deleteById(String id);

  Optional<Object> findByfileName(String fileName);
}


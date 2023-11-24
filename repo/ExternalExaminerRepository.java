package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.ExternalExaminer;

import java.util.Optional;

@Repository
public interface ExternalExaminerRepository extends CrudRepository<ExternalExaminer, String> {
  Optional<ExternalExaminer> findByEmailId(String email);

  boolean existsByEmailId(String email);

  boolean existsById(Long id);

  Optional<ExternalExaminer> findByid(Long id);
}
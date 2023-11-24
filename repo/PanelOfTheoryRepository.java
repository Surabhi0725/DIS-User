package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.PanelOfTheory;

import javax.transaction.Transactional;

@Repository
public interface PanelOfTheoryRepository extends CrudRepository<PanelOfTheory, String> {

  boolean existsBySubjectCodeAndYear(String subjectCode, String year);

  @Modifying
  @Transactional
  Long deleteBySubjectCodeAndYear(String subjectCode, String year);
}

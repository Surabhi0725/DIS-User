package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserCompetitiveExam;

import java.util.List;

@Repository
public interface UserCompetitiveExamRepository extends CrudRepository<UserCompetitiveExam, Long> {
  List<UserCompetitiveExam> findByUserId(String userId);
}

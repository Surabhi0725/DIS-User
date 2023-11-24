package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserResearchWork;

import java.util.List;

@Repository()
public interface UserResearchWorkRepository extends CrudRepository<UserResearchWork, Long> {
  List<UserResearchWork> findByUserId(String id);
}

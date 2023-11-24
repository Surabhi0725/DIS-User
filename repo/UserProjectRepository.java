package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserProject;

import java.util.List;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject, Long> {
  List<UserProject> findByUserId(String userId);
}

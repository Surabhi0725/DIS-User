package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserInternship;

import java.util.List;

@Repository()
public interface UserInternshipRepository extends CrudRepository<UserInternship, Long> {
  List<UserInternship> findByUserId(String id);
}

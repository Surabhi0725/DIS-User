package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import sgsits.cse.dis.user.model.Group;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, String> {
  List<Group> findByCreatedBy(String username);
}

package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserWorkExperience;

import java.util.List;

@Repository()
public interface UserWorkExperienceRepository extends CrudRepository<UserWorkExperience, Long> {
  List<UserWorkExperience> findByUserId(String id);
}

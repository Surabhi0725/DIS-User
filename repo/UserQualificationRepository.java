package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserQualification;

import java.util.List;

@Repository()
public interface UserQualificationRepository extends CrudRepository<UserQualification, Long> {
  List<UserQualification> findByUserId(String id);
}

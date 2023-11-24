package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserTechnicalActivity;

import java.util.List;

@Repository
public interface UserTechnicalActivityRepository
        extends CrudRepository<UserTechnicalActivity, Long> {
  List<UserTechnicalActivity> findByUserId(final String userId);
}

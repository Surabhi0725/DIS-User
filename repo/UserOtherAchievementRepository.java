package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserOtherAchievement;

import java.util.List;

@Repository
public interface UserOtherAchievementRepository extends CrudRepository<UserOtherAchievement, Long> {
  List<UserOtherAchievement> findByUserId(final String userId);
}

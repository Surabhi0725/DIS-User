package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserCulturalActivityAchievement;

import java.util.List;

@Repository
public interface UserCulturalActivityAchievementRepository
        extends CrudRepository<UserCulturalActivityAchievement, Long> {
  List<UserCulturalActivityAchievement> findByUserId(final String userId);
}

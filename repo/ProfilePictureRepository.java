package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.ProfilePicture;

import java.util.List;

@Repository
public interface ProfilePictureRepository extends CrudRepository<ProfilePicture, Long> {

  List<ProfilePicture> findByUserId(final String userId);

  List<ProfilePicture> findByUserIdAndStatus(final String userId, final int status);
}

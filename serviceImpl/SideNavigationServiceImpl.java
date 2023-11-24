package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.message.response.SideNavigationData;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.SideNavigationService;

import java.util.Optional;

@Component
public class SideNavigationServiceImpl implements SideNavigationService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private StaffBasicProfileRepository staffBasicProfileRepository;

  @Override
  public SideNavigationData getSideNavigationDetails(String username) {
    Optional<User> userData = userRepository.findByUsername(username);
    Optional<StaffBasicProfile> profileDet = staffBasicProfileRepository.findByUserId(
            userData.get().getId());

    if (userData.isPresent()) {
      SideNavigationData data;
      if (profileDet.isPresent()) {

        data = new SideNavigationData(username, userData.get().getLastLogin(),
                profileDet.get().getName(), profileDet.get().getCurrentDesignation()
        );
      } else {
        data = new SideNavigationData(username, userData.get().getLastLogin(), null, null);
      }

      return data;
    }
    return null;
  }
}
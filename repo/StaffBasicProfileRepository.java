package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StaffBasicProfile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;

@Repository
public interface StaffBasicProfileRepository extends CrudRepository<StaffBasicProfile, String> {
  Optional<StaffBasicProfile> findById(String userId);

  Optional<StaffBasicProfile> findByEmail(String email);

  Optional<StaffBasicProfile> findByEmployeeId(String employeeId);

  Optional<StaffBasicProfile> findByUserId(String userId);

  //@Query(value="SELECT s.name, s.email from staff_basic_profile s where class = 'I' or class = 'II' order by current_designation", nativeQuery=true)
  List<StaffBasicProfile> findByClasssOrClasssOrderByCurrentDesignation(String classs1,
          String classs2);

  boolean existsByEmailAndMobileNoAndDob(String email, long mobileNo, Date dob);

  Optional<StaffBasicProfile> findByEmailAndMobileNoAndDob(String email, long mobileNo, Date dob);

  Optional<StaffBasicProfile> findByMobileNo(Long mobileNo);

  StaffBasicProfile findNameByUserId(String userId);

  List<StaffBasicProfile> findByNameContainingIgnoreCase(String name);

  Optional<StaffBasicProfile> findByName(String name);

  @Query(value = "UPDATE staff_basic_profile SET user_id =?1 WHERE email = ?2", nativeQuery = true)
  @Modifying
  void updateUserIdByEmailId(String userId, String email);

  @Query(value = "SELECT staff_basic_profile.name  FROM staff_basic_profile, user where staff_basic_profile.user_id=user.id and user.username=?1", nativeQuery = true)
  String findNameByUsername(String username);

  @Query(value = "SELECT staff_basic_profile.name  FROM staff_basic_profile", nativeQuery = true)
  List<String> findNames();

  @Query(value = "SELECT user.username, staff_basic_profile.name  FROM staff_basic_profile, user where staff_basic_profile.user_id=user.id", nativeQuery = true)
  List<Object[]> findAllUserIdAndUsername();

  @Query(value = "SELECT user.username, staff_basic_profile.email  FROM staff_basic_profile, user where staff_basic_profile.user_id=user.id", nativeQuery = true)
  List<Object[]> findAllUserIdAndEmails();

  boolean existsByEmail(String email);

  boolean existsByEmployeeId(String email);

}
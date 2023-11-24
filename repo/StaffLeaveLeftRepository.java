package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StaffLeaveLeft;
import sgsits.cse.dis.user.model.StaffLeaveLeftId;

@Repository
public interface StaffLeaveLeftRepository extends CrudRepository<StaffLeaveLeft, StaffLeaveLeftId> {
  StaffLeaveLeft findByUserIdAndYear(String userId, int year);

  Boolean existsByUserIdAndYear(String userId, int year);

  @Query(value = "update staff_leave_left s set s.leaves_left=?1 where s.user_id=?2 and s.year=?3", nativeQuery = true)
  @Modifying
  void updateStaffLeaveLeftInfo(long leavesLeft, String userId, int year);
}
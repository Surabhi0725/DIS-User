package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StaffLeave;

import java.util.List;

@Repository
public interface StaffLeaveRepository extends CrudRepository<StaffLeave, Long> {

  StaffLeave findByLeaveId(Long leaveId);

  List<StaffLeave> findByAppliedBy(String appliedBy);

  List<StaffLeave> findByStatusIgnoreCase(String status);

  List<StaffLeave> findByUserId(String userId);

  @Query(value = "update staff_leave set status=?2 where leave_id=?1", nativeQuery = true)
  @Modifying
  void updateStatusByLeaveId(Long leaveId, String status);
}
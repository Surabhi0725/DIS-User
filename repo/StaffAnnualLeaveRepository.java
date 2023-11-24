package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sgsits.cse.dis.user.model.StaffAnnualLeave;
import sgsits.cse.dis.user.model.StaffAnnualLeaveId;

public interface StaffAnnualLeaveRepository
        extends CrudRepository<StaffAnnualLeave, StaffAnnualLeaveId> {
  Boolean existsByUserIdAndLeaveNameAndToDate(String userId, String leaveName, String toDate);

  StaffAnnualLeave findByUserIdAndLeaveNameAndToDate(String userId, String leaveName,
          String toDate);

  @Modifying
  @Query(value = "UPDATE staff_annual_leave SET leaves_left = leaves_left + ?1 WHERE user_id = ?2 AND to_date = ?3 AND leave_name = ?4", nativeQuery = true)
  void creditLeave(int leaves_left, String userId, String toDate, String leaveName);
}

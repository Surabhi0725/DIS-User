package sgsits.cse.dis.user.service;

import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.*;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveTypes;

import java.text.ParseException;
import java.util.List;

@Component
public interface StaffLeaveService {

  List<StaffLeave> getAllLeaves();

  List<StaffLeaveTypes> getAllLeaveTypes();

  Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm) throws ConflictException, ParseException;

  List<StaffLeave> getLeavesByStatus(String status);

  int updateStatusByLeaveId(UpdateStatusForm updateStatus) throws ConflictException;

  List<StaffLeaveAccountResponse> getLeaveLeft(String userName);

  List<StaffLeave> getMyLeaves(String username);

  int createNewLeave(CreateStaffLeaveForm createStaffLeaveForm) throws ConflictException;

  void rejoin(StaffRejoinForm staffRejoinForm) throws ParseException;

  String creditLeave(StaffLeaveCreditForm staffLeaveCreditForm) throws ConflictException;

  long updateLeave(ApplyStaffLeaveForm applyStaffLeaveForm)
          throws ConflictException, ParseException;

  StaffLeaveAccountResponse getMyLeaveAccount(String username);

  StaffLeave getLeaveById(Long id);

  String cancelLeave(Long id);
}
package sgsits.cse.dis.user.message.request;

import javax.validation.constraints.NotBlank;

public class UpdateStatusForm {

  @NotBlank(message = "leave id cannot be blank") Long leaveId;

  @NotBlank(message = "status cannot be blank") String status;

  String remarks;

  public Long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Long leaveId) {
    this.leaveId = leaveId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }
}
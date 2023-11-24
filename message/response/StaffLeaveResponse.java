package sgsits.cse.dis.user.message.response;

public class StaffLeaveResponse {

  private String message;
  private Long leaveId;

  public StaffLeaveResponse(String message, Long leaveId) {
    this.message = message;
    this.leaveId = leaveId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Long leaveId) {
    this.leaveId = leaveId;
  }
}
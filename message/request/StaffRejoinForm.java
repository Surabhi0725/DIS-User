package sgsits.cse.dis.user.message.request;

public class StaffRejoinForm {
  Long leaveId;
  String rejoinDate;
  String toDuration;
  String remarks;

  public StaffRejoinForm() {
  }

  public StaffRejoinForm(Long leaveId, String rejoinDate, String toDuration) {
    this.leaveId = leaveId;
    this.rejoinDate = rejoinDate;
    this.toDuration = toDuration;
  }

  public Long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Long leaveId) {
    this.leaveId = leaveId;
  }

  public String getRejoinDate() {
    return rejoinDate;
  }

  public void setRejoinDate(String rejoinDate) {
    this.rejoinDate = rejoinDate;
  }

  public String getToDuration() {
    return toDuration;
  }

  public void setToDuration(String toDuration) {
    this.toDuration = toDuration;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }
}

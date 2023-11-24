package sgsits.cse.dis.user.message.request;

import java.util.List;

public class StaffLeaveCreditForm {
  List<String> facultyNames;
  String leaveName;
  int leaveToCredit;

  public List<String> getFacultyNames() {
    return facultyNames;
  }

  public void setFacultyNames(List<String> facultyNames) {
    this.facultyNames = facultyNames;
  }

  public String getLeaveName() {
    return leaveName;
  }

  public void setLeaveName(String leaveName) {
    this.leaveName = leaveName;
  }

  public int getLeaveToCredit() {
    return leaveToCredit;
  }

  public void setLeaveToCredit(int leaveToCredit) {
    this.leaveToCredit = leaveToCredit;
  }
}

package sgsits.cse.dis.user.message.response;

import java.util.List;

public class StaffLeaveAccountResponse {

  String userId;
  List<StaffLeaveLeftResponse> lifelong;
  List<StaffLeaveLeftResponse> annual;

  public StaffLeaveAccountResponse() {
  }

  public List<StaffLeaveLeftResponse> getLifelong() {
    return lifelong;
  }

  public void setLifelong(List<StaffLeaveLeftResponse> lifelong) {
    this.lifelong = lifelong;
  }

  public List<StaffLeaveLeftResponse> getAnnual() {
    return annual;
  }

  public void setAnnual(List<StaffLeaveLeftResponse> annual) {
    this.annual = annual;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}

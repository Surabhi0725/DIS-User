package sgsits.cse.dis.user.message.request;

import javax.validation.constraints.NotBlank;

public class CreateStaffLeaveForm {

  @NotBlank(message = "Leave Name cannot be blank")
  private String leaveName;

  @NotBlank(message = "Leave Type cannot be blank")
  private String leaveType;

  private String fromDate;

  private String toDate;

  private String description;

  private int noOfLeaves;

  public String getLeaveName() {
    return leaveName;
  }

  public void setLeaveName(String leaveName) {
    this.leaveName = leaveName;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(String leaveType) {
    this.leaveType = leaveType;
  }

  public String getFromDate() {
    return fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getNoOfLeaves() {
    return noOfLeaves;
  }

  public void setNoOfLeaves(int noOfLeaves) {
    this.noOfLeaves = noOfLeaves;
  }
}

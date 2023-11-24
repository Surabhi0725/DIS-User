package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_leave_types")
public class StaffLeaveTypes {

  @Id
  @Column(name = "leave_name")
  private String leaveName;

  @Column(nullable = false, name = "leave_type")
  private String leaveType;

  @Column(name = "from_date")
  private String fromDate;

  @Column(name = "to_date")
  private String toDate;

  @Column(name = "no_of_leaves")
  private int noOfLeaves;

  @Column(name = "description")
  private String description;

  public StaffLeaveTypes(String leaveName, String leaveType, String fromDate, String toDate,
          int noOfLeaves, String description) {
    this.leaveName = leaveName;
    this.leaveType = leaveType;
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.noOfLeaves = noOfLeaves;
    this.description = description;
  }

  public StaffLeaveTypes() {
  }

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

  public int getNoOfLeaves() {
    return noOfLeaves;
  }

  public void setNoOfLeaves(int noOfLeaves) {
    this.noOfLeaves = noOfLeaves;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "StaffLeaveTypes [description=" + description + ", fromDate=" + fromDate +
            ", leaveName=" + leaveName + ", leaveType=" + leaveType + ", noOfLeaves=" + noOfLeaves +
            ", toDate=" + toDate + "]";
  }
}
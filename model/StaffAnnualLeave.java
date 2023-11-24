package sgsits.cse.dis.user.model;

import javax.persistence.*;

@Entity
@IdClass(StaffAnnualLeaveId.class)
@Table(name = "staff_annual_leave")
public class StaffAnnualLeave {

  @Id
  @Column(name = "user_id")
  private String userId;

  @Id
  @Column(name = "to_date")
  private String toDate;

  @Id
  @Column(name = "leave_name")
  private String leaveName;

  @Column(name = "leaves_applied")
  private double leavesApplied;

  @Column(name = "leaves_left")
  private double leavesLeft;

  public StaffAnnualLeave() {
  }

  public StaffAnnualLeave(String userId, String toDate, String leaveName, double leavesApplied,
          double leavesLeft) {
    this.userId = userId;
    this.toDate = toDate;
    this.leaveName = leaveName;
    this.leavesApplied = leavesApplied;
    this.leavesLeft = leavesLeft;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getLeaveName() {
    return leaveName;
  }

  public void setLeaveName(String leaveName) {
    this.leaveName = leaveName;
  }

  public double getLeavesApplied() {
    return leavesApplied;
  }

  public void setLeavesApplied(double leavesApplied) {
    this.leavesApplied = leavesApplied;
  }

  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public double getLeavesLeft() {
    return leavesLeft;
  }

  public void setLeavesLeft(double leavesLeft) {
    this.leavesLeft = leavesLeft;
  }
}
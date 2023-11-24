package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import java.io.Serializable;

public class StaffAnnualLeaveId implements Serializable {

  @Column(name = "user_id")
  private String userId;

  @Column(name = "to_date")
  private String toDate;

  @Column(name = "leave_name")
  private String leaveName;

  public StaffAnnualLeaveId() {
  }

  public StaffAnnualLeaveId(String userId, String toDate, String leaveName) {
    this.userId = userId;
    this.toDate = toDate;
    this.leaveName = leaveName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public String getLeaveName() {
    return leaveName;
  }

  public void setLeaveName(String leaveName) {
    this.leaveName = leaveName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((leaveName == null) ? 0 : leaveName.hashCode());
    result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    StaffAnnualLeaveId other = (StaffAnnualLeaveId) obj;
    if (leaveName == null) {
      if (other.leaveName != null) return false;
    } else if (!leaveName.equals(other.leaveName)) return false;
    if (toDate == null) {
      if (other.toDate != null) return false;
    } else if (!toDate.equals(other.toDate)) return false;
    if (userId == null) {
      return other.userId == null;
    } else return userId.equals(other.userId);
  }
}
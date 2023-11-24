package sgsits.cse.dis.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(StaffLeaveLeftId.class)
public class StaffLeaveLeft {

  @Id
  private String userId;
  @Id
  private int year;

  private long leavesLeft;

  private String username;

  public StaffLeaveLeft() {
  }

  public StaffLeaveLeft(String userId, int year, int leavesLeft, String username) {
    this.userId = userId;
    this.year = year;
    this.leavesLeft = leavesLeft;
    this.username = username;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public long getLeavesLeft() {
    return leavesLeft;
  }

  public void setLeavesLeft(long leavesLeft) {
    this.leavesLeft = leavesLeft;
  }
}
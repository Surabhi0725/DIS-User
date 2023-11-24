package sgsits.cse.dis.user.message.request;

import javax.validation.constraints.NotBlank;

public class ApplyStaffLeaveForm {

  private String details;

  @NotBlank(message = "From date cannot be blank")
  private String fromDate;

  @NotBlank(message = "To date cannot be blank")
  private String toDate;

  private Long leaveId;

  private String fromDuration;

  private String toDuration;

  private boolean considerHolidays;

  private double noOfDays;

  private String remarks;

  private String status;

  private String subject;

  private String typeOfLeave;

  private String appliedBy;

  private String userId;

  private String prefix;

  private String suffix;

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getStauts() {
    return status;
  }

  public void setStauts(String stauts) {
    this.status = stauts;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getTypeOfLeave() {
    return typeOfLeave;
  }

  public void setTypeOfLeave(String typeOfLeave) {
    this.typeOfLeave = typeOfLeave;
  }

  public String getAppliedBy() {
    return appliedBy;
  }

  public void setAppliedBy(String appliedBy) {
    this.appliedBy = appliedBy;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public double getNoOfDays() {
    return noOfDays;
  }

  public void setNoOfDays(double noOfDays) {
    this.noOfDays = noOfDays;
  }

  public String getFromDuration() {
    return fromDuration;
  }

  public void setFromDuration(String fromDuration) {
    this.fromDuration = fromDuration;
  }

  public String getToDuration() {
    return toDuration;
  }

  public void setToDuration(String toDuration) {
    this.toDuration = toDuration;
  }

  public boolean isConsiderHolidays() {
    return considerHolidays;
  }

  public void setConsiderHolidays(boolean considerHolidays) {
    this.considerHolidays = considerHolidays;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public Long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Long leaveId) {
    this.leaveId = leaveId;
  }
}
package sgsits.cse.dis.user.model;

import javax.persistence.*;

@Entity
@Table(name = "staff_leave")
public class StaffLeave {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, unique = true, name = "leave_id")
  private Long leaveId;

  @Column(name = "created_date")
  private String createdDate;

  @Column(name = "modified_by")
  private String modifiedBy;

  @Column(name = "modified_date")
  private String modifiedDate;

  @Column(nullable = false, name = "applied_by")
  private String appliedBy;

  @Column(name = "details")
  private String details;

  @Column(nullable = false, name = "from_date")
  private String fromDate;

  @Column(nullable = false, name = "to_date")
  private String toDate;

  @Column(name = "from_duration")
  private String fromDuration;

  @Column(name = "to_duration")
  private String toDuration;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "status")
  private String status;

  @Column(name = "subject")
  private String subject;

  @Column(name = "type_of_leave")
  private String typeOfLeave;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "consider_holidays")
  private boolean considerHolidays;

  @Column(name = "no_of_days")
  private double noOfDays;

  @Column(name = "prefix")
  private String prefix;

  @Column(name = "suffix")
  private String suffix;

  public StaffLeave() {}

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public String getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(String modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getAppliedBy() {
    return appliedBy;
  }

  public void setAppliedBy(String appliedBy) {
    this.appliedBy = appliedBy;
  }

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

  public Long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Long leaveId) {
    this.leaveId = leaveId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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
}
package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffBasicProfileDto {

  private String createdBy;
  private String createdDate;
  private String id;
  private String userId;

  private String employeeId;
  private String name;
  private String nameAcronym;
  private String currentDesignation;
  private String classs;
  private String type;
  private String email;
  private Date dob;
  private String panNumber;
  private String aadharNumber;
  private String bloodGroup;
  private String gender;
  private String motherName;
  private String fatherName;
  private long mobileNo;
  private Long alternateMobileNo;
  private Date joiningDate;
  private String areaOfSpecialization;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameAcronym() {
    return nameAcronym;
  }

  public void setNameAcronym(String nameAcronym) {
    this.nameAcronym = nameAcronym;
  }

  public String getCurrentDesignation() {
    return currentDesignation;
  }

  public void setCurrentDesignation(String currentDesignation) {
    this.currentDesignation = currentDesignation;
  }

  public String getClasss() {
    return classs;
  }

  public void setClasss(String classs) {
    this.classs = classs;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getPanNumber() {
    return panNumber;
  }

  public void setPanNumber(String panNumber) {
    this.panNumber = panNumber;
  }

  public String getAadharNumber() {
    return aadharNumber;
  }

  public void setAadharNumber(String aadharNumber) {
    this.aadharNumber = aadharNumber;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public long getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(long mobileNo) {
    this.mobileNo = mobileNo;
  }

  public Long getAlternateMobileNo() {
    return alternateMobileNo;
  }

  public void setAlternateMobileNo(Long alternateMobileNo) {
    this.alternateMobileNo = alternateMobileNo;
  }

  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  public String getAreaOfSpecialization() {
    return areaOfSpecialization;
  }

  public void setAreaOfSpecialization(String areaOfSpecialization) {
    this.areaOfSpecialization = areaOfSpecialization;
  }
}

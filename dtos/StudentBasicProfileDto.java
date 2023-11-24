package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBasicProfileDto {

  //    private String id;
  private String createdBy;
  private String createdDate;
  //    private String modifiedBy;
  //    private String modifiedDate;
  private String userId;
  private String enrollmentId;
  //    private String profilePicture;
  private String fullName;
  private int admissionYear;
  private String courseId;
  private Long mobileNo;
  private String email;
  private Date dob;
  private String fatherName;
  private Long fatherContact;
  private String fatherEmail;
  private String motherName;
  private Long motherContact;
  private String motherEmail;
  private String category;
  private String gender;
  private String bloodGroup;
  private int schemeSemester;
  private int schemeYear;

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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEnrollmentId() {
    return enrollmentId;
  }

  public void setEnrollmentId(String enrollmentId) {
    this.enrollmentId = enrollmentId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public int getAdmissionYear() {
    return admissionYear;
  }

  public void setAdmissionYear(int admissionYear) {
    this.admissionYear = admissionYear;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public Long getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(Long mobileNo) {
    this.mobileNo = mobileNo;
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

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public Long getFatherContact() {
    return fatherContact;
  }

  public void setFatherContact(Long fatherContact) {
    this.fatherContact = fatherContact;
  }

  public String getFatherEmail() {
    return fatherEmail;
  }

  public void setFatherEmail(String fatherEmail) {
    this.fatherEmail = fatherEmail;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public Long getMotherContact() {
    return motherContact;
  }

  public void setMotherContact(Long motherContact) {
    this.motherContact = motherContact;
  }

  public String getMotherEmail() {
    return motherEmail;
  }

  public void setMotherEmail(String motherEmail) {
    this.motherEmail = motherEmail;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public int getSchemeSemester() {
    return schemeSemester;
  }

  public void setSchemeSemester(int schemeSemester) {
    this.schemeSemester = schemeSemester;
  }

  public int getSchemeYear() {
    return schemeYear;
  }

  public void setSchemeYear(int schemeYear) {
    this.schemeYear = schemeYear;
  }
}

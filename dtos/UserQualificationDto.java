package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQualificationDto extends UserProfileDto {

  private String degreeCertificate;

  private int yearOfPassing;

  private String collegeSchool;

  private String universityBoard;

  private String percentageCgpa;

  private String specialization;

  public String getDegreeCertificate() {
    return degreeCertificate;
  }

  public void setDegreeCertificate(String degreeCertificate) {
    this.degreeCertificate = degreeCertificate;
  }

  public int getYearOfPassing() {
    return yearOfPassing;
  }

  public void setYearOfPassing(int yearOfPassing) {
    this.yearOfPassing = yearOfPassing;
  }

  public String getCollegeSchool() {
    return collegeSchool;
  }

  public void setCollegeSchool(String collegeSchool) {
    this.collegeSchool = collegeSchool;
  }

  public String getUniversityBoard() {
    return universityBoard;
  }

  public void setUniversityBoard(String universityBoard) {
    this.universityBoard = universityBoard;
  }

  public String getPercentageCgpa() {
    return percentageCgpa;
  }

  public void setPercentageCgpa(String percentageCgpa) {
    this.percentageCgpa = percentageCgpa;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
}

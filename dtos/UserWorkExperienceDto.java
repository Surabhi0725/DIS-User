package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkExperienceDto extends UserProfileDto {

  private String organizationName;

  private String designation;

  private Date dateOfJoining;

  private Date dateOfLeaving;

  private Long payScale;

  private String country;

  private String state;

  private String city;

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Date getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(Date dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public Date getDateOfLeaving() {
    return dateOfLeaving;
  }

  public void setDateOfLeaving(Date dateOfLeaving) {
    this.dateOfLeaving = dateOfLeaving;
  }

  public Long getPayScale() {
    return payScale;
  }

  public void setPayScale(Long payScale) {
    this.payScale = payScale;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}

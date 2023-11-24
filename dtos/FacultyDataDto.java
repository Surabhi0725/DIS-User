package sgsits.cse.dis.user.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacultyDataDto {

  private String id;
  private String userId;
  private String name;
  private String nameAcronym;
  private String profilePicture;
  private String currentDesignation;
  private String email;
  private Long mobileNo;
  private Long alternateMobileNo;
  private String userName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  public String getCurrentDesignation() {
    return currentDesignation;
  }

  public void setCurrentDesignation(String currentDesignation) {
    this.currentDesignation = currentDesignation;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(Long mobileNo) {
    this.mobileNo = mobileNo;
  }

  public Long getAlternateMobileNo() {
    return alternateMobileNo;
  }

  public void setAlternateMobileNo(Long alternateMobileNo) {
    this.alternateMobileNo = alternateMobileNo;
  }
}

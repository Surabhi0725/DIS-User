package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyBriefDataDto {

  private String name;
  private String nameAcronym;
  private String profilePicture;
  private String currentDesignation;
  private String email;

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
}

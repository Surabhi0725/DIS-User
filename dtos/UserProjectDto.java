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
public class UserProjectDto extends UserProfileDto {

  private Date toDate;

  private Date fromDate;

  private String title;

  private String description;

  private String guide;

  private String otherCreators;

  private String role;

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getGuide() {
    return guide;
  }

  public void setGuide(String guide) {
    this.guide = guide;
  }

  public String getOtherCreators() {
    return otherCreators;
  }

  public void setOtherCreators(String otherCreators) {
    this.otherCreators = otherCreators;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}

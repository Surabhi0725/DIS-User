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
public class UserTechnicalActivityDto extends UserProfileDto {

  private String type;

  private String topicSubject;

  private Date fromDate;

  private Date toDate;

  private String nameOfCoordinator;

  private String attendedOrganized;

  private String place;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTopicSubject() {
    return topicSubject;
  }

  public void setTopicSubject(String topicSubject) {
    this.topicSubject = topicSubject;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public String getNameOfCoordinator() {
    return nameOfCoordinator;
  }

  public void setNameOfCoordinator(String nameOfCoordinator) {
    this.nameOfCoordinator = nameOfCoordinator;
  }

  public String getAttendedOrganized() {
    return attendedOrganized;
  }

  public void setAttendedOrganized(String attendedOrganized) {
    this.attendedOrganized = attendedOrganized;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }
}

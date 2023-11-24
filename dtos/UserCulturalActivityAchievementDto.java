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
public class UserCulturalActivityAchievementDto extends UserProfileDto {

  private String type;

  private String nameOfActivity;

  private String achievement;

  private Date date;

  private byte[] certificate;

  private String place;


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNameOfActivity() {
    return nameOfActivity;
  }

  public void setNameOfActivity(String nameOfActivity) {
    this.nameOfActivity = nameOfActivity;
  }

  public String getAchievement() {
    return achievement;
  }

  public void setAchievement(String achievement) {
    this.achievement = achievement;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public byte[] getCertificate() {
    return certificate;
  }

  public void setCertificate(byte[] certificate) {
    this.certificate = certificate;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }
}

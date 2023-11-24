package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCompetitiveExamDto extends UserProfileDto {

  private String nameOfExam;

  private double score;

  private int rank;

  private Short year;

  private byte[] scoreCard;

  private String registrationNo;

  public String getNameOfExam() {
    return nameOfExam;
  }

  public void setNameOfExam(String nameOfExam) {
    this.nameOfExam = nameOfExam;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public Short getYear() {
    return year;
  }

  public void setYear(Short year) {
    this.year = year;
  }

  public byte[] getScoreCard() {
    return scoreCard;
  }

  public void setScoreCard(byte[] scoreCard) {
    this.scoreCard = scoreCard;
  }

  public String getRegistrationNo() {
    return registrationNo;
  }

  public void setRegistrationNo(String registrationNo) {
    this.registrationNo = registrationNo;
  }
}

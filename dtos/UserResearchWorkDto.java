package sgsits.cse.dis.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResearchWorkDto extends UserProfileDto {

  private String title;

  private String category;

  private String subcategory;

  private String journalConferenceName;

  private String publisher;

  private String coAuthors;

  private String guideName;

  private int yearOfPublication;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(String subcategory) {
    this.subcategory = subcategory;
  }

  public String getJournalConferenceName() {
    return journalConferenceName;
  }

  public void setJournalConferenceName(String journalConferenceName) {
    this.journalConferenceName = journalConferenceName;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getCoAuthors() {
    return coAuthors;
  }

  public void setCoAuthors(String coAuthors) {
    this.coAuthors = coAuthors;
  }

  public String getGuideName() {
    return guideName;
  }

  public void setGuideName(String guideName) {
    this.guideName = guideName;
  }

  public int getYearOfPublication() {
    return yearOfPublication;
  }

  public void setYearOfPublication(int yearOfPublication) {
    this.yearOfPublication = yearOfPublication;
  }
}

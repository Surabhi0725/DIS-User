package sgsits.cse.dis.user.message.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreatePanelOfTheoryForm {

  @NotBlank(message = "subject code cannot be blank")
  private String subjectCode;

  @NotBlank(message = "year cannot be blank")
  private String year;

  private String subjectName;

  private String course;

  private List<String> faculties;

  public String getSubjectCode() {
    return subjectCode;
  }

  public void setSubjectCode(String subjectCode) {
    this.subjectCode = subjectCode;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public List<String> getFaculties() {
    return faculties;
  }

  public void setFaculties(List<String> faculties) {
    this.faculties = faculties;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}

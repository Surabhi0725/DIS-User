package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "panel_of_theory")
@IdClass(PanelOfTheoryId.class)
public class PanelOfTheory {

  @Id
  @Column(name = "subject_code")
  private String subjectCode;

  @Id
  @Column(name = "year")
  private String year;

  @ElementCollection
  @Column(name = "faculties")
  private List<String> faculties = new ArrayList<String>();

  @Column(name = "course")
  private String course;

  @Column(name = "subject_name")
  private String subjectName;

  public String getSubjectCode() {
    return subjectCode;
  }

  public void setSubjectCode(String subjectCode) {
    this.subjectCode = subjectCode;
  }

  public List<String> getFaculties() {
    return faculties;
  }

  public void setFaculties(List<String> faculties) {
    this.faculties = faculties;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
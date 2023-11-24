package sgsits.cse.dis.user.dtos;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PanelOfPracticalDto {

  private String id;
  private String subjectCode;
  private String subjectName;
  private String internalFaculty1;
  private String internalFaculty2;
  private String externalFaculty;
  private String labAssistant;
  private String labTechnician;
  private Date creationDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public String getInternalFaculty1() {
    return internalFaculty1;
  }

  public void setInternalFaculty1(String internalFaculty1) {
    this.internalFaculty1 = internalFaculty1;
  }

  public String getInternalFaculty2() {
    return internalFaculty2;
  }

  public void setInternalFaculty2(String internalFaculty2) {
    this.internalFaculty2 = internalFaculty2;
  }

  public String getExternalFaculty() {
    return externalFaculty;
  }

  public void setExternalFaculty(String externalFaculty) {
    this.externalFaculty = externalFaculty;
  }

  public String getLabAssistant() {
    return labAssistant;
  }

  public void setLabAssistant(String labAssistant) {
    this.labAssistant = labAssistant;
  }

  public String getLabTechnician() {
    return labTechnician;
  }

  public void setLabTechnician(String labTechnician) {
    this.labTechnician = labTechnician;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}

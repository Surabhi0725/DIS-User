package sgsits.cse.dis.user.message.response;

import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StudentProfile;

import java.util.List;

public class BatchData {

  private List<StudentProfile> students;
  private StaffBasicProfile guide, coguide;
  private String session, ugOrPg, batchId;

  public BatchData() {

  }

  public BatchData(List<StudentProfile> students, StaffBasicProfile guide,
          StaffBasicProfile coguide, String session, String ugOrPg, String batchId) {
    super();
    this.students = students;
    this.guide = guide;
    this.coguide = coguide;
    this.session = session;
    this.ugOrPg = ugOrPg;
    this.batchId = batchId;
  }

  public List<StudentProfile> getStudents() {
    return students;
  }

  public void setStudents(List<StudentProfile> students) {
    this.students = students;
  }

  public StaffBasicProfile getGuide() {
    return guide;
  }

  public void setGuide(StaffBasicProfile guide) {
    this.guide = guide;
  }

  public StaffBasicProfile getCoguide() {
    return coguide;
  }

  public void setCoguide(StaffBasicProfile coguide) {
    this.coguide = coguide;
  }

  public String getSession() {
    return session;
  }

  public void setSession(String session) {
    this.session = session;
  }

  public String getUgOrPg() {
    return ugOrPg;
  }

  public void setUgOrPg(String ugOrPg) {
    this.ugOrPg = ugOrPg;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }
}

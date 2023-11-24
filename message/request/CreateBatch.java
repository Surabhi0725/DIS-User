package sgsits.cse.dis.user.message.request;

import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StudentProfile;

import java.util.List;

public class CreateBatch {
  private List<StudentProfile> students;
  private StaffBasicProfile guide, coguide;
  private String session;
  private String ugOrPg;

  public CreateBatch() {

  }

  public CreateBatch(List<StudentProfile> students, StaffBasicProfile guide,
          StaffBasicProfile coguide, String session, String ugOrPg) {
    super();
    this.students = students;
    this.guide = guide;
    this.coguide = coguide;
    this.session = session;
    this.ugOrPg = ugOrPg;
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
}

package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pg_guide_allotment_student_details")
public class PgGuideAllotmentStudent {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "student_id", nullable = false)
  private String studentId;

  @Column(name = "batch_details_id", nullable = false)
  private String batchDetailsId;

  public PgGuideAllotmentStudent() {
    super();
  }

  public PgGuideAllotmentStudent(String studentId, String batchDetailsId) {
    super();
    this.studentId = studentId;
    this.batchDetailsId = batchDetailsId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getBatchDetailsId() {
    return batchDetailsId;
  }

  public void setBatchDetailsId(String batchDetailsId) {
    this.batchDetailsId = batchDetailsId;
  }
}

package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_attachment")
public class EventAttachment implements Serializable {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "event_id", nullable = true)
  private String eventId;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Lob
  @Column(name = "file_url", nullable = false)
  private String fileUrl;

  public EventAttachment() {
  }

  public EventAttachment(String fileName, String fileUrl) {
    super();
    this.fileName = fileName;
    this.fileUrl = fileUrl;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }
}

package sgsits.cse.dis.user.service;

import com.sun.mail.util.MailConnectException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.dtos.EventDto;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.Group;
import sgsits.cse.dis.user.model.Holiday;

import javax.mail.MessagingException;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

@Component
public interface CalendarServices {
  List<Event> getAllEvents();

  List<Holiday> getPublicHolidays();

  Event addEvent(EventDto event, MultipartFile[] files)
          throws SQLException, MessagingException, IOException;

  Event updateEvent(EventDto event, String eventId, MultipartFile[] files)
          throws SQLException, MessagingException, EventDoesNotExistException, IOException;

  void deleteEvent(String eventId)
          throws SQLException, MessagingException, EventDoesNotExistException, IOException;

  Event getEvent(String eventId);

  List<Event> getMyEvents(String participantId);

  Group addGroup(Group group);

  List<Group> getMyGroups(String username);
  List<Holiday> addPublicHoliday(List<Holiday> holidays);
}

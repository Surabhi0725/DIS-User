package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.dtos.EventDto;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.Group;
import sgsits.cse.dis.user.model.Holiday;
import sgsits.cse.dis.user.serviceImpl.CalendarServicesImpl;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "Calendar services controller")
@RestController
@RequestMapping(path = "/calendar")
/*
    Methods:
    1. getListOfEvents
    2. getListOfHolidays
    3. getListOfPublicHolidays
    4. Add/Delete/Update Event
    5. Add/Get Group
*/
public class CalendarController {

  @Autowired
  private CalendarServicesImpl calenderServiceImpl;

  private List<Event> eventList;

  @ApiOperation(value = "Get all the events", response = Event.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/getAllEvents", produces = "application/json")
  @ResponseBody
  public List<Event> getAllEvents() {
    List<Event> eventList = calenderServiceImpl.getAllEvents();
    return eventList;
  }

  @ApiOperation(value = "Get public holidays", response = Event.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/getPublicHolidays", produces = "application/json")
  @ResponseBody
  public List<Holiday> getPublicHolidays() {
    List<Holiday> holidayList = calenderServiceImpl.getPublicHolidays();
    return holidayList;
  }

  @ApiOperation(value = "Adding a public holiday", response = Event.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(path = "/addPublicHoliday", produces = "application/json")
  public List<Holiday> addPublicHoliday(@RequestBody List<Holiday> holiday) {
    calenderServiceImpl.addPublicHoliday(holiday);
    return holiday;
  }

  @ApiOperation(value = "Get my events", response = Event.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/getMyEvents", produces = "application/json")
  @ResponseBody
  public List<Event> getMyEvents(@RequestParam String id) {
    List<Event> eventList = calenderServiceImpl.getMyEvents(id);
    return eventList;
  }

  @ApiOperation(value = "Add an event", response = Event.class, httpMethod = "POST", produces = "application/json", consumes = "multipart/form-data")
  @PostMapping(path = "/addEvent", produces = "application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public Event addEvent(@RequestPart("event") EventDto event,
          @RequestPart("file") MultipartFile[] files)
          throws IOException, MessagingException, SQLException {
    System.out.println(event.toString());
    return calenderServiceImpl.addEvent(event, files);
  }

  @ApiOperation(value = "Delete an event", response = Event.class, httpMethod = "DELETE", produces = "application/json")
  @DeleteMapping(path = "/deleteEvent", produces = "application/json")
  public void deleteEvent(@RequestParam(value = "eventId") String eventId)
          throws EventDoesNotExistException, IOException, MessagingException, SQLException {
    System.out.println(eventId);
    calenderServiceImpl.deleteEvent(eventId);
  }

  @ApiOperation(value = "Update an event", response = Event.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(path = "/updateEvent", produces = "application/json")
  public Event updateEvent(@RequestParam(value = "eventId") String eventId,
          @RequestPart("event") EventDto event, @RequestPart("file") MultipartFile[] files)
          throws EventDoesNotExistException, IOException, MessagingException, SQLException {
    return calenderServiceImpl.updateEvent(event, eventId, files);
  }

  @ApiOperation(value = "Adding a group", response = Event.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(path = "/addGroup", produces = "application/json")
  public Group addGroup(@RequestBody Group group) {
    calenderServiceImpl.addGroup(group);
    return group;
  }
  @ApiOperation(value = "Get all my groups", response = Event.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/getMyGroup", produces = "application/json")
  public List<Group> getMyGroup(@RequestParam(value = "userName") String userName) {
    return calenderServiceImpl.getMyGroups(userName);
  }
}

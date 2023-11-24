package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.*;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.message.response.StaffLeaveLeftResponse;
import sgsits.cse.dis.user.model.*;
import sgsits.cse.dis.user.repo.*;
import sgsits.cse.dis.user.service.StaffLeaveService;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class StaffLeaveServiceImpl implements StaffLeaveService, Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private StaffLeaveRepository staffLeaveRepository;

  @Autowired
  private StaffBasicProfileRepository staffRepository;

  @Autowired
  private StaffLeaveTypeRepository staffLeaveTypeRepository;

  @Autowired
  private StaffLifelongLeaveRepository staffLifelongLeaveRepository;

  @Autowired
  private StaffAnnualLeaveRepository staffAnnualLeaveRepository;

  @Autowired
  private HolidayRepository holidayRepository;

  public List<StaffLeave> getAllLeaves() {
    List<StaffLeave> leaves = (List<StaffLeave>) staffLeaveRepository.findAll();
    for (StaffLeave l : leaves) {
      if (staffRepository.findNameByUsername(l.getAppliedBy()) != null) {
        String name = staffRepository.findNameByUsername(l.getAppliedBy());
        l.setAppliedBy(name);
      }
    }
    return leaves;
  }

  @Override
  public List<StaffLeaveTypes> getAllLeaveTypes() {
    List<StaffLeaveTypes> leaves = new ArrayList<StaffLeaveTypes>();
    leaves = (List<StaffLeaveTypes>) staffLeaveTypeRepository.findAll();
    return leaves;
  }

  @Override
  @Transactional
  public Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm)
          throws ConflictException, ParseException {

    String userId = applyStaffLeaveForm.getUserId();
    StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(
            applyStaffLeaveForm.getTypeOfLeave());
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fdate = applyStaffLeaveForm.getFromDate();
    String tdate = applyStaffLeaveForm.getToDate();

//    if (leaveType.getLeaveType().equals("annual")) {
//      try {
//        if (simpleDateFormat.parse(fdate)
//                .compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0 ||
//                simpleDateFormat.parse(leaveType.getToDate())
//                        .compareTo(simpleDateFormat.parse(tdate)) < 0) {
//          throw new ConflictException("Leave cannot be applied due to date issue.");
//        }
//      } catch (ParseException e) {
//        e.printStackTrace();
//      }
//    }
    StaffLeave staffLeave = new StaffLeave();
    staffLeave.setFromDate(applyStaffLeaveForm.getFromDate());
    staffLeave.setToDate(applyStaffLeaveForm.getToDate());
    staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
    staffLeave.setCreatedDate(simpleDateFormat.format(new Date()));
    staffLeave.setAppliedBy(applyStaffLeaveForm.getAppliedBy());
    staffLeave.setDetails(applyStaffLeaveForm.getDetails());
    staffLeave.setStatus(applyStaffLeaveForm.getStatus());
    staffLeave.setFromDuration(applyStaffLeaveForm.getFromDuration());
    staffLeave.setToDuration(applyStaffLeaveForm.getToDuration());
    staffLeave.setConsiderHolidays(applyStaffLeaveForm.isConsiderHolidays());
    staffLeave.setSubject(applyStaffLeaveForm.getSubject());
    staffLeave.setTypeOfLeave(applyStaffLeaveForm.getTypeOfLeave());
    staffLeave.setUserId(userId);
    staffLeave.setNoOfDays(
            getDays(applyStaffLeaveForm.getFromDate(), applyStaffLeaveForm.getToDate(),
                    applyStaffLeaveForm.isConsiderHolidays(), applyStaffLeaveForm.getFromDuration(),
                    applyStaffLeaveForm.getToDuration()
            ));

    if (!applyStaffLeaveForm.getFromDuration().equals("Second Half")) {
      staffLeave.setPrefix(getPrefix(applyStaffLeaveForm.getFromDate()));
    } else {
      staffLeave.setPrefix(applyStaffLeaveForm.getFromDate());
    }

    if (!applyStaffLeaveForm.getToDuration().equals("First Half")) {
      staffLeave.setSuffix(getSuffix(applyStaffLeaveForm.getToDate()));
    } else {
      staffLeave.setSuffix(applyStaffLeaveForm.getToDate());
    }

    StaffLeave test = staffLeaveRepository.save(staffLeave);
    return test.getLeaveId();
  }

  @Override
  public List<StaffLeave> getLeavesByStatus(String status) {
    List<StaffLeave> leaves = staffLeaveRepository.findByStatusIgnoreCase(status);
    for (StaffLeave l : leaves) {
      if (staffRepository.findNameByUsername(l.getAppliedBy()) != null) {
        String name = staffRepository.findNameByUsername(l.getAppliedBy());
        l.setAppliedBy(name);
      }
    }
    return leaves;
  }

  @Override
  @Transactional
  public int updateStatusByLeaveId(UpdateStatusForm updateStatus) throws ConflictException {

    Long leaveId = updateStatus.getLeaveId();
    String status = updateStatus.getStatus();
    status = status.toLowerCase();
    StaffLeave leave = staffLeaveRepository.findByLeaveId(leaveId);
    String leaveName = leave.getTypeOfLeave();
    String type = staffLeaveTypeRepository.findByLeaveName(leaveName).getLeaveType();
    StaffLeaveTypes slt = staffLeaveTypeRepository.findByLeaveName(leaveName);

    StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(leave.getTypeOfLeave());
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fdate = leave.getFromDate();
    String tdate = leave.getToDate();

//    if (leaveType.getLeaveType().equals("annual")) {
//      try {
//        if (simpleDateFormat.parse(fdate)
//                .compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0 ||
//                simpleDateFormat.parse(leaveType.getToDate())
//                        .compareTo(simpleDateFormat.parse(tdate)) < 0) {
//          throw new ConflictException("Leave cannot be applied due to date issue.");
//        }
//      } catch (ParseException e) { 
//        e.printStackTrace();
//      }
//    }

    if (type.equals("lifelong")) {
      if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(leave.getUserId(), leaveName)) {
        addToTable(leaveName, leave.getUserId());
      }
    } else {
      if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(leave.getUserId(),
              leaveName, slt.getToDate()
      )) {
        addToTable(leaveName, leave.getUserId());
      }
    }
    if (status.equals("approved") && !leave.getStatus().equals("approved")) {
      double days;
      days = leave.getNoOfDays();

      System.out.println("days" + days);
      if (type.equals("lifelong")) {
        StaffLifelongLeave leave2 = staffLifelongLeaveRepository.findByUserIdAndLeaveName(
                leave.getUserId(), leaveName);
        leave2.setLeavesApplied(leave2.getLeavesApplied() + days);
        leave2.setLeavesLeft(leave2.getLeavesLeft() - days);
        staffLifelongLeaveRepository.save(leave2);
      } else {
        StaffAnnualLeave leave2 = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(
                leave.getUserId(), leaveName, slt.getToDate());
        leave2.setLeavesApplied(leave2.getLeavesApplied() + days);
        leave2.setLeavesLeft(leave2.getLeavesLeft() - days);
        staffAnnualLeaveRepository.save(leave2);
      }
    }
    leave.setStatus(status);
    leave.setRemarks(updateStatus.getRemarks());
    staffLeaveRepository.save(leave);
    return 1;
  }

  public List<StaffLeaveAccountResponse> getLeaveLeft(String userName) {
    List<StaffLeaveAccountResponse> res = new ArrayList<StaffLeaveAccountResponse>();
    List<StaffBasicProfile> staff = staffRepository.findByNameContainingIgnoreCase(userName);
    List<StaffLeaveTypes> allLeave = (List<StaffLeaveTypes>) staffLeaveTypeRepository.findAll();

    for (StaffBasicProfile s : staff) {
      StaffLeaveAccountResponse account = new StaffLeaveAccountResponse();
      List<StaffLeaveLeftResponse> annual = new ArrayList<StaffLeaveLeftResponse>();
      List<StaffLeaveLeftResponse> lifelong = new ArrayList<StaffLeaveLeftResponse>();
      String userId = s.getUserId();
      account.setUserId(s.getUserId());
      for (StaffLeaveTypes a : allLeave) {
        StaffLeaveLeftResponse r = new StaffLeaveLeftResponse();
        if (a.getLeaveType().equals("annual")) {
          if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(userId,
                  a.getLeaveName(), a.getToDate()
          )) {
            addToTable(a.getLeaveName(), userId);
          }
          StaffAnnualLeave sal = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(
                  userId, a.getLeaveName(), a.getToDate());

          r.setLeaveName(a.getLeaveName());
          r.setLeavesApplied(sal.getLeavesApplied());
          r.setLeavesLeft(sal.getLeavesLeft());
          r.setToDate(sal.getToDate());
          annual.add(r);
        } else {
          if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(userId, a.getLeaveName())) {
            addToTable(a.getLeaveName(), userId);
          }
          StaffLifelongLeave sal = staffLifelongLeaveRepository.findByUserIdAndLeaveName(userId,
                  a.getLeaveName()
          );

          r.setLeaveName(a.getLeaveName());
          r.setLeavesApplied(sal.getLeavesApplied());
          r.setLeavesLeft(sal.getLeavesLeft());
          lifelong.add(r);
        }
      }
      account.setAnnual(annual);
      account.setLifelong(lifelong);
      res.add(account);
    }
    return res;
  }

  @Override
  public List<StaffLeave> getMyLeaves(String username) {
    List<StaffLeave> leaves = staffLeaveRepository.findByAppliedBy(username);
    for (StaffLeave l : leaves) {
      String name = staffRepository.findNameByUsername(l.getAppliedBy());
      l.setAppliedBy(name);
    }
    return leaves;
  }

  @Override
  public int createNewLeave(CreateStaffLeaveForm createStaffLeaveForm) throws ConflictException {
    if (createStaffLeaveForm.getLeaveType().equals("annual") &&
            createStaffLeaveForm.getToDate() != null) {
      StaffLeaveTypes staffLeaveTypes = new StaffLeaveTypes();
      staffLeaveTypes.setDescription(createStaffLeaveForm.getDescription());
      staffLeaveTypes.setLeaveName(createStaffLeaveForm.getLeaveName());
      staffLeaveTypes.setNoOfLeaves(createStaffLeaveForm.getNoOfLeaves());
      staffLeaveTypes.setLeaveType(createStaffLeaveForm.getLeaveType());
      staffLeaveTypes.setFromDate(createStaffLeaveForm.getFromDate());
      staffLeaveTypes.setToDate(createStaffLeaveForm.getToDate());
      staffLeaveTypeRepository.save(staffLeaveTypes);
      return 1;
    } else if (createStaffLeaveForm.getLeaveType().equals("lifelong")) {
      StaffLeaveTypes staffLeaveTypes = new StaffLeaveTypes();
      staffLeaveTypes.setDescription(createStaffLeaveForm.getDescription());
      staffLeaveTypes.setLeaveName(createStaffLeaveForm.getLeaveName());
      staffLeaveTypes.setNoOfLeaves(createStaffLeaveForm.getNoOfLeaves());
      staffLeaveTypes.setLeaveType(createStaffLeaveForm.getLeaveType());
      staffLeaveTypeRepository.save(staffLeaveTypes);
      return 1;
    } else {
      throw new ConflictException("new leave cannot be created");
    }
  }

  @Override
  @Transactional
  public void rejoin(StaffRejoinForm staffRejoinForm) throws ParseException {
    Date d;
    String strDate;
    StaffLeave leave = staffLeaveRepository.findByLeaveId(staffRejoinForm.getLeaveId());
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = df.parse(staffRejoinForm.getRejoinDate());
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    System.out.println("here 8");
    if (staffRejoinForm.getToDuration().equals("First Half")) {
      cal.add(Calendar.DATE, -1);
      d = cal.getTime();
      strDate = df.format(d);
      leave.setToDate(strDate);
      if (leave.getFromDate().equals(leave.getToDate())) {
        if (leave.getFromDuration().equals("First Half") ||
                leave.getFromDuration().equals("full")) {
          leave.setToDuration("full");
          leave.setFromDuration("full");
        } else {
          leave.setToDuration("Second Half");
        }
      } else {
        leave.setToDuration("full");
      }
    } else {
      leave.setToDuration("First Half");
      leave.setToDate(staffRejoinForm.getRejoinDate());
    }
    leave.setStatus("rejoined");
    double daysBefore = leave.getNoOfDays();
    double daysAfter = 0;
    try {
      daysAfter = getDays(leave.getFromDate(), leave.getToDate(), leave.isConsiderHolidays(),
              leave.getFromDuration(), leave.getToDuration()
      );
    } catch (ParseException e) {
      e.printStackTrace();
    }
    System.out.println("days after" + daysAfter);
    StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(leave.getTypeOfLeave());
    if (leaveType.getLeaveType().equals("annual")) {
      StaffAnnualLeave l = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(
              leave.getUserId(), leave.getTypeOfLeave(), leaveType.getToDate());
      l.setLeavesApplied(l.getLeavesApplied() - daysBefore + daysAfter);
      l.setLeavesLeft(l.getLeavesLeft() + daysBefore - daysAfter);
      staffAnnualLeaveRepository.save(l);
    } else {
      StaffLifelongLeave l = staffLifelongLeaveRepository.findByUserIdAndLeaveName(
              leave.getUserId(), leave.getTypeOfLeave());
      l.setLeavesApplied(l.getLeavesApplied() - daysBefore + daysAfter);
      l.setLeavesLeft(l.getLeavesLeft() + daysBefore - daysAfter);
      staffLifelongLeaveRepository.save(l);
    }
    leave.setNoOfDays(daysAfter);

    if (!leave.getFromDuration().equals("Second Half")) {
      leave.setPrefix(getPrefix(leave.getFromDate()));
    } else {
      leave.setPrefix(leave.getFromDate());
    }

    if (!leave.getToDuration().equals("First Half")) {
      leave.setSuffix(getSuffix(leave.getToDate()));
    } else {
      leave.setSuffix(leave.getToDate());
    }

    if (staffRejoinForm.getRemarks() != null) leave.setRemarks(staffRejoinForm.getRemarks());

    staffLeaveRepository.save(leave);
  }

  @Override
  @Transactional
  public String creditLeave(StaffLeaveCreditForm staffLeaveCreditForm) throws ConflictException {
    String leaveName = staffLeaveCreditForm.getLeaveName();
    StaffLeaveTypes leave = staffLeaveTypeRepository.findByLeaveName(leaveName);
    for (String s : staffLeaveCreditForm.getFacultyNames()) {

      String userId;
      Optional<StaffBasicProfile> sp = staffRepository.findByName(s);
      System.out.println("Faculty " + s);
      if (sp.isPresent()) {
        StaffBasicProfile st = sp.get();
        userId = st.getUserId();
      } else {
        throw new ConflictException("User " + s + " does not exist. Rollback!");
      }
      if (leave.getLeaveType().equals("annual")) {
        if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(userId, leaveName,
                leave.getToDate()
        )) {
          addToTable(leaveName, userId);
        }
        staffAnnualLeaveRepository.creditLeave(staffLeaveCreditForm.getLeaveToCredit(), userId,
                leave.getToDate(), leaveName
        );
      } else if (leave.getLeaveType().equals("lifelong")) {
        if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(userId, leaveName)) {
          addToTable(leaveName, userId);
        }
        staffLifelongLeaveRepository.creditLeave(staffLeaveCreditForm.getLeaveToCredit(), userId,
                leaveName
        );
      } else {
        throw new ConflictException("can't get leave type.");
      }
    }
    return "Leave Credited";
  }

  @Override
  public long updateLeave(ApplyStaffLeaveForm applyStaffLeaveForm)
          throws ConflictException, ParseException {
    StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(
            applyStaffLeaveForm.getTypeOfLeave());
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fdate = applyStaffLeaveForm.getFromDate();
    String tdate = applyStaffLeaveForm.getToDate();

    if (leaveType.getLeaveType().equals("annual")) {
      try {
        if (simpleDateFormat.parse(fdate)
                .compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0 ||
                simpleDateFormat.parse(leaveType.getToDate())
                        .compareTo(simpleDateFormat.parse(tdate)) < 0) {
          throw new ConflictException("Leave cannot be updated due to date issue.");
        }
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    StaffLeave staffLeave = staffLeaveRepository.findByLeaveId(applyStaffLeaveForm.getLeaveId());
    staffLeave.setFromDate(applyStaffLeaveForm.getFromDate());
    staffLeave.setToDate(applyStaffLeaveForm.getToDate());
    staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
    staffLeave.setModifiedDate(simpleDateFormat.format(new Date()));
    staffLeave.setModifiedBy(applyStaffLeaveForm.getAppliedBy());
    staffLeave.setDetails(applyStaffLeaveForm.getDetails());
    staffLeave.setStatus(applyStaffLeaveForm.getStatus());
    staffLeave.setFromDuration(applyStaffLeaveForm.getFromDuration());
    staffLeave.setToDuration(applyStaffLeaveForm.getToDuration());
    staffLeave.setConsiderHolidays(applyStaffLeaveForm.isConsiderHolidays());
    staffLeave.setSubject(applyStaffLeaveForm.getSubject());
    staffLeave.setTypeOfLeave(applyStaffLeaveForm.getTypeOfLeave());
    staffLeave.setNoOfDays(
            getDays(applyStaffLeaveForm.getFromDate(), applyStaffLeaveForm.getToDate(),
                    applyStaffLeaveForm.isConsiderHolidays(), applyStaffLeaveForm.getFromDuration(),
                    applyStaffLeaveForm.getToDuration()
            ));

    if (!applyStaffLeaveForm.getFromDuration().equals("Second Half")) {
      staffLeave.setPrefix(getPrefix(applyStaffLeaveForm.getFromDate()));
    } else {
      staffLeave.setPrefix(applyStaffLeaveForm.getFromDate());
    }

    if (!applyStaffLeaveForm.getToDuration().equals("First Half")) {
      staffLeave.setSuffix(getSuffix(applyStaffLeaveForm.getToDate()));
    } else {
      staffLeave.setSuffix(applyStaffLeaveForm.getToDate());
    }

    StaffLeave test = staffLeaveRepository.save(staffLeave);
    return test.getLeaveId();
  }

  @Override
  public StaffLeaveAccountResponse getMyLeaveAccount(String username) {
    String name = staffRepository.findNameByUsername(username);
    return getLeaveLeft(name).get(0);
  }

  @Override
  public StaffLeave getLeaveById(Long id) {
    StaffLeave leave = staffLeaveRepository.findByLeaveId(id);
    String name = staffRepository.findNameByUsername(leave.getAppliedBy());
    leave.setAppliedBy(name);
    return leave;
  }

  @Override
  @Transactional
  public String cancelLeave(Long id) {
    StaffLeave leave = staffLeaveRepository.findByLeaveId(id);
    double days = leave.getNoOfDays();
    StaffLeaveTypes lt = staffLeaveTypeRepository.findByLeaveName(leave.getTypeOfLeave());
    if (leave.getStatus().equals("approved")) {
      if (lt.getLeaveType().equals("annual")) {
        StaffAnnualLeave l = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(
                leave.getUserId(), leave.getTypeOfLeave(), lt.getToDate());
        l.setLeavesApplied(l.getLeavesApplied() - days);
        l.setLeavesLeft(l.getLeavesLeft() + days);
        staffAnnualLeaveRepository.save(l);
      } else {
        StaffLifelongLeave l = staffLifelongLeaveRepository.findByUserIdAndLeaveName(
                leave.getUserId(), leave.getTypeOfLeave());
        l.setLeavesApplied(l.getLeavesApplied() - days);
        l.setLeavesLeft(l.getLeavesLeft() + days);
        staffLifelongLeaveRepository.save(l);
      }
    }
    leave.setStatus("cancelled");
    staffLeaveRepository.save(leave);
    return "Leave cancelled";
  }

  public double getDays(String fromDate, String toDate, boolean considerHolidays,
          String fromDuration, String toDuration) throws ParseException {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = df.parse(fromDate);
    Date date2 = df.parse(toDate);

    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal2.setTime(date2);
    // cal2.add(Calendar.DATE, 1);
    double numberOfDays = 0;

    if (!fromDuration.equals("full")) {
      numberOfDays = numberOfDays + 0.5;
      cal1.add(Calendar.DATE, 1);
    }

    if (!fromDate.equals(toDate)) {
      if (!toDuration.equals("full")) {
        numberOfDays = numberOfDays + 0.5;
        cal2.add(Calendar.DATE, -1);
      }
    }
    if (considerHolidays) {
      while (cal1.compareTo(cal2) <= 0) {
        numberOfDays++;
        cal1.add(Calendar.DATE, 1);
      }
      return numberOfDays;
    }
    List<Holiday> holidays = (List<Holiday>) holidayRepository.findAll();
    List<String> dates = new ArrayList<String>();
    for (Holiday h : holidays) {
      dates.add(h.getDate());
    }
    while (cal1.compareTo(cal2) <= 0) {
      Date d = cal1.getTime();
      String strDate = df.format(d);

      if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK)) &&
              (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK)) && !dates.contains(strDate)) {
        numberOfDays++;
      }
      cal1.add(Calendar.DATE, 1);
    }
    // System.out.println(numberOfDays);
    return numberOfDays;
  }

  public String getPrefix(String fromDate) throws ParseException {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = df.parse(fromDate);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    List<Holiday> holidays = (List<Holiday>) holidayRepository.findAll();
    List<String> dates = new ArrayList<String>();
    for (Holiday h : holidays) {
      dates.add(h.getDate());
    }
    Date d;
    String strDate;
    do {
      cal.add(Calendar.DATE, -1);
      d = cal.getTime();
      strDate = df.format(d);
    }
    while (dates.contains(strDate) || Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK) ||
            Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK));
    cal.add(Calendar.DATE, 1);
    d = cal.getTime();
    strDate = df.format(d);
    return strDate;
  }

  public String getSuffix(String toDate) throws ParseException {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = df.parse(toDate);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    List<Holiday> holidays = (List<Holiday>) holidayRepository.findAll();
    List<String> dates = new ArrayList<>();
    for (Holiday h : holidays) {
      dates.add(h.getDate());
    }
    Date d;
    String strDate;
    do {
      cal.add(Calendar.DATE, 1);
      d = cal.getTime();
      strDate = df.format(d);
    }
    while (dates.contains(strDate) || Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK) ||
            Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK));
    cal.add(Calendar.DATE, -1);
    d = cal.getTime();
    strDate = df.format(d);
    return strDate;
  }

  public void addToTable(String leaveName, String userId) {
    StaffLeaveTypes slt = staffLeaveTypeRepository.findByLeaveName(leaveName);
    if (slt.getLeaveType().equals("lifelong")) {
      StaffLifelongLeave staffLifelongLeave = new StaffLifelongLeave();
      staffLifelongLeave.setLeaveName(leaveName);
      staffLifelongLeave.setUserId(userId);
      staffLifelongLeave.setLeavesApplied(0);
      staffLifelongLeave.setLeavesLeft(slt.getNoOfLeaves());
      staffLifelongLeaveRepository.save(staffLifelongLeave);
    } else {
      StaffAnnualLeave staffAnnualLeave = new StaffAnnualLeave();
      staffAnnualLeave.setLeaveName(leaveName);
      staffAnnualLeave.setLeavesApplied(0);
      staffAnnualLeave.setLeavesLeft(slt.getNoOfLeaves());
      staffAnnualLeave.setToDate(slt.getToDate());
      staffAnnualLeave.setUserId(userId);
      staffAnnualLeaveRepository.save(staffAnnualLeave);
    }
  }
}


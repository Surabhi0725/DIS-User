package sgsits.cse.dis.user.serviceImpl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.StudentDto;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.repo.StudentRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.UserServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserServicesImpl implements UserServices {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StaffBasicProfileRepository staffBasicProfileRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<ActiveStaffListResponse> getActiveStaffList() throws NotFoundException {
    List<User> users = userRepository.findAllByEnabledAndUserTypeNot(true, "Student");
    System.out.println(users);
    if (users.isEmpty()) throw new NotFoundException("Activated staff accounts not found");
    List<ActiveStaffListResponse> activeStaffListResponses = new ArrayList<>();
    for (User user : users) {
      Optional<StaffBasicProfile> staffBasicProfile = staffBasicProfileRepository.findByEmail(user.getEmail());
      staffBasicProfile.ifPresent(basicProfile -> activeStaffListResponses.add(new ActiveStaffListResponse(user.getId(), basicProfile.getName(),
              user.getEmail()
      )));
    }

    return activeStaffListResponses;
  }

  @Override
  public String getUserId(String username) {
    Optional<User> dbUser = userRepository.findByUsername(username);
    if (dbUser.isPresent()) {
      User user = dbUser.get();
      return user.getId();
    }
    return null;
  }

  @Override
  public boolean existsByUsername(String username) throws NotFoundException {
    return userRepository.existsByUsername(username);
  }

  @Override
  public boolean findUser(SignUpForm signup) {
    boolean exist = false;
    exist = staffBasicProfileRepository.existsByEmailAndMobileNoAndDob(signup.getEmail(),
            signup.getMobileNo(), signup.getDob()
    );
    if (!exist) {
      exist = studentRepository.existsByEnrollmentIdAndMobileNoAndDob(signup.getUsername(),
              signup.getMobileNo(), signup.getDob()
      );
    }
    return exist;
  }

  @Override
  public String findUserType(SignUpForm signup) {
    String type = null;
    Optional<StaffBasicProfile> staff = staffBasicProfileRepository.findByEmailAndMobileNoAndDob(
            signup.getEmail(), signup.getMobileNo(), signup.getDob());
    if (staff.isPresent()) {
      if (staff.get().getClasss().equals("I") || staff.get().getClasss().equals("II")) {
        type = "faculty";
      }
      if (staff.get().getClasss().equals("III")) {
        type = "staff";
      }
      if (staff.get().getClasss().equals("IV")) {
        type = "attendent";
      }
    } else {
      Optional<StudentProfile> stud = studentRepository.findByEnrollmentIdAndMobileNoAndDob(
              signup.getUsername(), signup.getMobileNo(), signup.getDob());
      if (stud.isPresent()) {
        type = "student";
      }
    }
    return type;
  }

  @Override
  public boolean updateEmailAndUserId(long mobileNo) {
    Optional<User> user = userRepository.findByMobileNo(mobileNo);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    if (user.get().getUserType().equals("student")) {
      Optional<StudentProfile> stud = studentRepository.findByMobileNo(mobileNo);
      stud.get().setUserId(user.get().getId());
      stud.get().setEmail(user.get().getEmail());
      stud.get().setModifiedBy(user.get().getId());
      stud.get().setModifiedDate(simpleDateFormat.format(new Date()));
      studentRepository.save(stud.get());
      return true;
    } else {
      Optional<StaffBasicProfile> staff = staffBasicProfileRepository.findByMobileNo(mobileNo);
      staff.get().setUserId(user.get().getId());
      staff.get().setEmail(user.get().getEmail());
      staff.get().setModifiedBy(user.get().getId());
      staff.get().setModifiedDate(simpleDateFormat.format(new Date()));
      staffBasicProfileRepository.save(staff.get());
      return true;
    }
  }

  public String getByUserName(String userid) {
    System.out.println(userid);
    Optional<User> dbUser = userRepository.findById(userid);
    if (dbUser.isPresent()) {
      User user = dbUser.get();
      System.out.println(user);
      return user.getUsername();
    }
    return null;
  }

  @Override
  public List<StudentDto> getStudentUserNameList() {
    List<User> studentList = userRepository.findByUserType("Student");
    List<StudentDto> studentDtoList = new ArrayList<>();

    for (User user : studentList) {
      studentDtoList.add(new StudentDto(user.getId(), user.getUsername()));
    }
    return studentDtoList;
  }

}


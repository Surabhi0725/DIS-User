package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.dtos.StudentDto;
import sgsits.cse.dis.user.feignClient.TaskAttachment;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.service.StaffService;
import sgsits.cse.dis.user.service.StudentService;
import sgsits.cse.dis.user.service.UserServices;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(value = "User Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")
public class  UserFeignClientController {

  private final UserServices userServicesImpl;
  private final StaffService staffService;

  private final StaffBasicProfileRepository staffBasicProfileRepository;

  @Autowired
  private StudentService studentService;


  public UserFeignClientController(final UserServices userServicesImpl,
          final StaffService staffService,
          final StaffBasicProfileRepository staffBasicProfileRepository) {

    this.userServicesImpl = userServicesImpl;
    this.staffService = staffService;
    this.staffBasicProfileRepository = staffBasicProfileRepository;
  }


  @ApiOperation(value = "Get Student Name from userId")
  @GetMapping(value = "/getStudentNameByUserId/{userId}")
  public StudentDto getNameByUserId(@PathVariable("userId") String userId) {
      return studentService.getNameById(userId);
  }

  @ApiOperation(value = "Get Student Full name List")
  @GetMapping(value = "/getStudentFullNameList")
  public List<StudentDto> getStudentFullNameList() {
    return studentService.getStudentFullNameList();
  }




  @ApiOperation(value = "Staff name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/getStaffNameList", produces = "application/json")
  public ResponseEntity<List<FacultyDataDto>> getStaffData() {

    return new ResponseEntity<>(staffService.getStaffData(), HttpStatus.OK);
  }

  @ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/getFacultyNameList", produces = "application/json")
  public ResponseEntity<List<FacultyDataDto>> getFacultyData() {

    return new ResponseEntity<>(staffService.getFacultyData(), HttpStatus.OK);
  }

  @ApiOperation(value = "get Username for given ID", response = String.class, httpMethod = "GET", produces = "application/json")
  @RequestMapping(value = "/getByUserName/{userid}", method = RequestMethod.GET)
  public String getByUserName(@PathVariable("userid") String userid) {
    return userServicesImpl.getByUserName(userid);
  }

  @ApiOperation(value = "get ID for given username", response = String.class, httpMethod = "GET", produces = "application/json")
  @RequestMapping(value = "/getUserId/{username}", method = RequestMethod.GET)
  public String getUserId(@PathVariable("username") String username) {
    return userServicesImpl.getUserId(username);
  }

  @ApiOperation(value = "get student username list", response = String.class, httpMethod = "GET", produces = "application/json")
  @RequestMapping(value = "/getStudentUserNameList", method = RequestMethod.GET)
  public List<StudentDto> getStudentUserNameList() {
    return userServicesImpl.getStudentUserNameList();
  }

  @ApiOperation(value = "Verify username", response = boolean.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/existsByUsername/{username}")
  public boolean existsByUsername(@PathVariable("username") String username)
          throws NotFoundException {
    return userServicesImpl.existsByUsername(username);
  }

  @ApiOperation(value = "Find User", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
  @PostMapping(value = "/findUser")
  public boolean findUser(@RequestBody SignUpForm signup) {

    return userServicesImpl.findUser(signup);
  }

  @ApiOperation(value = "Find User Type", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
  @PostMapping(value = "/findUserIype")
  public String findUserType(@RequestBody SignUpForm signup) {

    return userServicesImpl.findUserType(signup);
  }

  @ApiOperation(value = "Update email and user Id", response = Boolean.class, httpMethod = "GET", produces = "text/plain")
  @GetMapping(value = "/updateEmailAndUserId")
  public boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo) {

    return userServicesImpl.updateEmailAndUserId(mobileNo);
  }

  @ApiOperation(value = "Get active staff list", response = boolean.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/getActiveStaffList")
  public ResponseEntity<List<ActiveStaffListResponse>> activeStaffListResponse()
          throws NotFoundException {

    return new ResponseEntity<>(userServicesImpl.getActiveStaffList(), HttpStatus.OK);
  }

  @ApiOperation(value = "get user name by id optional", response = String.class, httpMethod = "POST", produces = "application/json")
  @RequestMapping(value = "/getUserNameByIdOptional", method = RequestMethod.POST)
  public ResponseEntity<String> getUserNameByIdOptinal(@RequestBody Optional<String> userId) {
    return new ResponseEntity<String>(staffService.getNameByIdOptional(userId), HttpStatus.OK);
  }

  @ApiOperation(value = "get user name by id", response = String.class, httpMethod = "GET", produces = "application/json")
  @RequestMapping(value = "/getUserNameById/{userId}")
  public ResponseEntity<String> getUserNameById(@PathVariable String userId) {
    return new ResponseEntity<>(staffService.getNameById(userId), HttpStatus.OK);
  }

  @ApiOperation(value = "Update user id with email", response = String.class, httpMethod = "PUT", produces = "application/json")
  @PutMapping(value = "/updateUserIdWithEmail/{userId}/{email}", produces = "application/jspn")
  @Transactional
  public ResponseEntity<String> updateUserIdByEmail(@PathVariable("userId") String userId,
          @PathVariable("email") String email) {

    staffBasicProfileRepository.updateUserIdByEmailId(userId, email);
    return new ResponseEntity<>(userId + " assigned to user with email " + email, HttpStatus.OK);
  }

  //    @ApiOperation(value = "Fetch ME students by year", response = StudentProfile.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/fetchMEStudentsByYear/{year}")
  public List<StudentProfile> fetchMEStudentsByYear(@PathVariable("year") int year) {
    return new ArrayList<StudentProfile>(studentService.fetchMEStudentsByYear(year));
  }
}

package sgsits.cse.dis.user.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.constants.ControllerConstants;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.EnrollmentTemplate;
import sgsits.cse.dis.user.service.StaffService;
import sgsits.cse.dis.user.service.StudentService;
import sgsits.cse.dis.user.serviceImpl.StaffServiceImpl;
import sgsits.cse.dis.user.serviceImpl.StudentServiceImpl;
import sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl.*;
import sgsits.cse.dis.user.utility.ExcelHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "UserProfile controller")
@RestController
public class UserProfileController {

  private final UserWorkExperienceService userWorkExperienceService;
  private final UserResearchWorkService userResearchWorkService;
  private final UserCompetitiveExamService userCompetitiveExamService;
  private final UserCulturalActivityAchievementService userCulturalActivityAchievementService;
  private final UserInternshipService userInternshipService;
  private final UserProjectService userProjectService;
  private final UserQualificationService userQualificationService;
  private final UserTechnicalActivityService userTechnicalActivityService;
  private final UserAddressService userAddressService;
  private final StaffServiceImpl staffService;
  private final StaffService staffServiceImpl;
  private final UserOtherAchievementService userOtherAchievementService;
  private final StudentServiceImpl studentService;
  private final StudentService studentServiceImpl;
  private final JwtResolver jwtResolver = new JwtResolver();
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  @Autowired
  public UserProfileController(final UserWorkExperienceService userWorkExperienceService,
          final UserResearchWorkService userResearchWorkService,
          final UserCompetitiveExamService userCompetitiveExamService,
          final UserCulturalActivityAchievementService userCulturalActivityAchievementService,
          final UserInternshipService userInternshipService,
          final UserProjectService userProjectService,
          final UserQualificationService userQualificationService,
          final UserTechnicalActivityService userTechnicalActivityService,
          final UserAddressService userAddressService, StaffServiceImpl staffService,
          StaffService staffServiceImpl,
          final UserOtherAchievementService userOtherAchievementService,
          final StudentServiceImpl studentService, StudentService studentServiceImpl) {
    this.userWorkExperienceService = userWorkExperienceService;
    this.userResearchWorkService = userResearchWorkService;
    this.userCompetitiveExamService = userCompetitiveExamService;
    this.userCulturalActivityAchievementService = userCulturalActivityAchievementService;
    this.userInternshipService = userInternshipService;
    this.userProjectService = userProjectService;
    this.userQualificationService = userQualificationService;
    this.userTechnicalActivityService = userTechnicalActivityService;
    this.userAddressService = userAddressService;
    this.staffService = staffService;
    this.staffServiceImpl = staffServiceImpl;
    this.userOtherAchievementService = userOtherAchievementService;
    this.studentService = studentService;
    this.studentServiceImpl = studentServiceImpl;
  }

  @ApiOperation(value = "get my user Id", response = ResponseMessage.class, httpMethod = "GET", produces = "text/plain")
  @GetMapping(path = RestAPI.GET_MY_USER_ID, produces = "application/json")
  public ResponseEntity<ResponseMessage> getMyUserId(HttpServletRequest request) {

    return new ResponseEntity<>(
            new ResponseMessage(jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"))),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "User Qualification", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userQualification")
  public ResponseEntity<List<UserProfileDto>> getUserQualification(final HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userQualificationService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User Work Experience", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userWorkExperience")
  public ResponseEntity<List<UserProfileDto>> getUserWorkExperience(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userWorkExperienceService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User Research Work", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userResearchWork")
  public ResponseEntity<List<UserProfileDto>> getUserResearchWork(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userResearchWorkService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User Internship", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userInternship")
  public ResponseEntity<List<UserProfileDto>> getUserInternship(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userInternshipService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User Technical Activity", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userTechnicalActivity")
  public ResponseEntity<List<UserProfileDto>> getUserTechnicalActivity(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userTechnicalActivityService.getUserProfileElement(id),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "User Cultural Activity Achievements", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userCulturalActivityAchievements")
  public ResponseEntity<List<UserProfileDto>> getUserCulturalActivityAchievements(
          HttpServletRequest request, @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userCulturalActivityAchievementService.getUserProfileElement(id),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "User Competitive Exams", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userCompetitiveExams")
  public ResponseEntity<List<UserProfileDto>> getUserCompetitiveExams(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userCompetitiveExamService.getUserProfileElement(id),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "User Project", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userProject")
  public ResponseEntity<List<UserProfileDto>> getUserProject(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userProjectService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User Address", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userAddress")
  public ResponseEntity<List<UserProfileDto>> getUserAddress(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userAddressService.getUserProfileElement(id), HttpStatus.OK);
  }

  @ApiOperation(value = "User OtherAchievement", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/userOtherAchievement")
  public ResponseEntity<List<UserProfileDto>> getUserOtherAchievement(HttpServletRequest request,
          @RequestParam String userId) throws InternalServerError {

    final String id = StringUtils.isBlank(userId) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

    return new ResponseEntity<>(userOtherAchievementService.getUserProfileElement(id),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "User Qualification", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserQualification")
  public ResponseEntity<ResponseMessage> addUserQualification(
          @RequestBody final UserQualificationDto userQualificationDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userQualificationService.addUserProfileElement(userQualificationDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );

    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Work Experience", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserWorkExperience")
  public ResponseEntity<ResponseMessage> addUserWorkExperience(
          @RequestBody final UserWorkExperienceDto userWorkExperienceDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userWorkExperienceService.addUserProfileElement(userWorkExperienceDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Research Work", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserResearchWork")
  public ResponseEntity<ResponseMessage> addUserResearchWork(
          @RequestBody final UserResearchWorkDto userResearchWorkDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userResearchWorkService.addUserProfileElement(userResearchWorkDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Internship", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserInternship")
  public ResponseEntity<ResponseMessage> addUserInternship(
          @RequestBody final UserInternshipDto userInternshipDto, final HttpServletRequest request)
          throws InternalServerError, UnauthorizedException {

    userInternshipService.addUserProfileElement(userInternshipDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Technical Activity", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserTechnicalActivity")
  public ResponseEntity<ResponseMessage> addUserTechnicalActivity(
          @RequestBody final UserTechnicalActivityDto userTechnicalActivityDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userTechnicalActivityService.addUserProfileElement(userTechnicalActivityDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Cultural Activity Achievements", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserCulturalActivityAchievements")
  public ResponseEntity<ResponseMessage> addUserCulturalActivityAchievement(
          @RequestBody final UserCulturalActivityAchievementDto userCulturalActivityAchievementDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userCulturalActivityAchievementService.addUserProfileElement(userCulturalActivityAchievementDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Competitive Exams", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserCompetitiveExams")
  public ResponseEntity<ResponseMessage> addUserCompetitiveExam(
          @RequestBody final UserCompetitiveExamDto userCompetitiveExamDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userCompetitiveExamService.addUserProfileElement(userCompetitiveExamDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Project", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserProject")
  public ResponseEntity<ResponseMessage> addUserProject(
          @RequestBody final UserProjectDto userProjectDto, final HttpServletRequest request)
          throws InternalServerError, UnauthorizedException {

    userProjectService.addUserProfileElement(userProjectDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User Address", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserAddress")
  public ResponseEntity<ResponseMessage> addUserAddress(
          @RequestBody final UserAddressDto userAddressDto, final HttpServletRequest request)
          throws InternalServerError, UnauthorizedException {

    userAddressService.addUserProfileElement(userAddressDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "User OtherAchievement", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addUserOtherAchievement")
  public ResponseEntity<ResponseMessage> addUserOtherAchievement(
          @RequestBody final UserOtherAchievementDto userOtherAchievementDto,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userOtherAchievementService.addUserProfileElement(userOtherAchievementDto,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserCompetitiveExam")
  public ResponseEntity<ResponseMessage> deleteCompetitiveExam(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userCompetitiveExamService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserCulturalActivityAchievement")
  public ResponseEntity<ResponseMessage> deleteCulturalActivityAchievement(
          @RequestParam final long id, final HttpServletRequest request)
          throws InternalServerError, UnauthorizedException {

    userCulturalActivityAchievementService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserInternship")
  public ResponseEntity<ResponseMessage> deleteInternship(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userInternshipService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserProject")
  public ResponseEntity<ResponseMessage> deleteProject(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userProjectService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserQualification")
  public ResponseEntity<ResponseMessage> deleteQualification(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userQualificationService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserResearchWork")
  public ResponseEntity<ResponseMessage> deleteResearchWork(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userResearchWorkService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserTechnicalActivity")
  public ResponseEntity<ResponseMessage> deleteTechnicalActivity(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userTechnicalActivityService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserWorkExperience")
  public ResponseEntity<ResponseMessage> deleteWorkExperience(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userWorkExperienceService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete competitive exam", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserAddress")
  public ResponseEntity<ResponseMessage> deleteAddress(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userAddressService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "delete other achievement ", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/deleteUserOtherAchievement")
  public ResponseEntity<ResponseMessage> deleteOtherAchievement(@RequestParam final long id,
          final HttpServletRequest request) throws InternalServerError, UnauthorizedException {

    userOtherAchievementService.deleteUserProfileElementById(id,
            request.getHeader(ControllerConstants.AUTHORIZATION)
    );

    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Deleted"));
  }

  @ApiOperation(value = "Staff Basic Profile Data", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/staffBasicProfile")
  public ResponseEntity<StaffBasicProfileDto> getStaffBasicProfile(HttpServletRequest request,
          final String userId, final String userType) throws InternalServerError {

    final String id = (StringUtils.isBlank(userId)) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;
    return new ResponseEntity<>(staffService.getStaffBasicProfile(id), HttpStatus.OK);
  }

  @ApiOperation(value = "Get All Student Profile", response = Object.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(value = "/studentBasicProfile")
  public ResponseEntity<StudentBasicProfileDto> getStudentBasicProfile(HttpServletRequest request,
          final String userId, final String userType) throws InternalServerError {

    final String id = (StringUtils.isBlank(userId)) ? jwtResolver.getIdFromJwtToken(
            request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;
    return new ResponseEntity<>(studentService.getStudentBasicProfile(id), HttpStatus.OK);
  }

  @ApiOperation(value = "add or update Staff Basic Profile Data", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addStaffBasicProfile")
  public ResponseEntity<ResponseMessage> addStaffBasicProfile(HttpServletRequest request,
          @RequestBody StaffBasicProfileDto staffBasicProfileDto) throws InternalServerError {
    System.out.println("OK TESTED");
    staffBasicProfileDto.setCreatedBy(
            jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")));
    staffBasicProfileDto.setCreatedDate(simpleDateFormat.format(new Date()));

    staffServiceImpl.addOrUpdateStaffBasicProfile(staffBasicProfileDto);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @ApiOperation(value = "Add or update Student Basic Profile", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/addStudentBasicProfile")
  public ResponseEntity<ResponseMessage> addStudentBasicProfile(HttpServletRequest request,
          @RequestBody StudentBasicProfileDto studentBasicProfileDto) throws InternalServerError {

    studentBasicProfileDto.setCreatedBy(
            jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")));
    studentBasicProfileDto.setCreatedDate(simpleDateFormat.format(new Date()));

    studentServiceImpl.addStudentBasicProfile(studentBasicProfileDto);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Edited"));
  }

  @PostMapping("/uploadStaffBasicProfile/{sheetNo}")
  public ResponseEntity<ResponseMessage> uploadStaffFile(@RequestParam("file") MultipartFile file,
          HttpServletRequest request, @PathVariable int sheetNo) {
    String message = "";

    if (ExcelHelper.hasExcelFormat(file)) {
      try {
        staffService.saveExcelData(file,
                jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")), sheetNo
        );

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        System.out.println(e);
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseMessage(message));
      }
    }

    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @PostMapping("/uploadStudentBasicProfile/{sheetNo}")
  public ResponseEntity<ResponseMessage> uploadStudentFile(@RequestParam("file") MultipartFile file,
          HttpServletRequest request, @PathVariable int sheetNo) {
    String message = "";

    if (ExcelHelper.hasExcelFormat(file)) {
      try {
        System.out.println("ctrlr");
        studentServiceImpl.saveExcelData(file,
                jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")), sheetNo
        );

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseMessage(message));
      }
    }

    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @PostMapping("/uploadEnrollmentTemplate")
  public ResponseEntity<ResponseMessage> uploadEnrollmentTemplate(
          @RequestPart("templateName") String templateName, @RequestPart("file") MultipartFile file)
          throws IOException {

    EnrollmentTemplate schemeFileForm = new EnrollmentTemplate();
    return studentServiceImpl.uploadEnrollmentTemplate(schemeFileForm, file);
  }

  @ApiOperation(value = "Download Template", response = ResponseMessage.class, httpMethod = "GET")
  @GetMapping(path = "/downloadEnrollmentTemplate" + "/{fileName}")
  public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
    EnrollmentTemplate dbFile = studentServiceImpl.getFile(fileName);
    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(dbFile.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + dbFile.getFileName() + "\""
            )
            .body(new ByteArrayResource(dbFile.getData()));
  }

  @ApiOperation(value = "Delete Template", response = ResponseMessage.class, httpMethod = "DELETE")
  @DeleteMapping(path = "/deleteEnrollmentTemplate/{fileName}")
  public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String fileName)
          throws FileNotFoundException {
    return studentServiceImpl.deleteTemplate(fileName);
  }


  //    @ApiOperation(value = "Download Scheme", response = ResponseMessage.class, httpMethod = "GET")
  //    @GetMapping(path = RestAPI.DOWNLOAD+"/{fileName}")
  //    public ResponseEntity<ByteArrayResource> downloadFile( @PathVariable String fileName){
  //        SchemeFile dbFile = schemeServices.getFile(fileName);
  //        return ResponseEntity.ok()
  //                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
  //                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
  //                .body(new ByteArrayResource(dbFile.getData()));
  //    }

  public void getStudentPlacement(HttpServletRequest request) {

  }

  public void getUGProject(HttpServletRequest request) {

  }

  public void getPGProject(HttpServletRequest request) {

  }
}

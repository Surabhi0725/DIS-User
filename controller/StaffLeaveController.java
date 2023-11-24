package sgsits.cse.dis.user.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.*;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.message.response.StaffLeaveResponse;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveTypes;
import sgsits.cse.dis.user.serviceImpl.StaffLeaveServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
// @RequestMapping(path = "/leave")
public class StaffLeaveController {

  JwtResolver jwtResolver = new JwtResolver();
  @Autowired
  private StaffLeaveServiceImpl staffLeaveServiceImpl;

  @ApiOperation(value = "get all leaves", response = StaffLeave.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_ALL_LEAVES_FOR_FACULTY, produces = "application/json")
  public ResponseEntity<List<StaffLeave>> getAllLeaves() {
    return new ResponseEntity<List<StaffLeave>>(staffLeaveServiceImpl.getAllLeaves(),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "get all leave types", response = StaffLeaveTypes.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_LEAVE_TYPES)
  public ResponseEntity<List<StaffLeaveTypes>> getAllLeaveTypes() {
    return new ResponseEntity<List<StaffLeaveTypes>>(staffLeaveServiceImpl.getAllLeaveTypes(),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "apply for leave", response = StaffLeaveResponse.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(path = RestAPI.APPLY_LEAVE, produces = "application/json")
  public ResponseEntity<StaffLeaveResponse> applyLeave(
          @RequestBody ApplyStaffLeaveForm applyStaffLeaveForm, HttpServletRequest request)
          throws ConflictException, ParseException {

    Long leaveId;
    String token = request.getHeader("Authorization");
    applyStaffLeaveForm.setAppliedBy(jwtResolver.getUserNameFromJwtToken(token));
    applyStaffLeaveForm.setUserId(jwtResolver.getIdFromJwtToken(token));
    leaveId = staffLeaveServiceImpl.applyLeave(applyStaffLeaveForm);
    return new ResponseEntity<StaffLeaveResponse>(
            new StaffLeaveResponse("Leave applied successfully.", leaveId), HttpStatus.OK);
  }

  @ApiOperation(value = "creates new staff leave", response = String.class, httpMethod = "POST", produces = "text/plain")
  @PostMapping(path = RestAPI.CREATE_NEW_LEAVE, produces = "text/plain")
  public ResponseEntity<String> createNewLeave(
          @Valid @RequestBody CreateStaffLeaveForm createStaffLeaveForm, HttpServletRequest request)
          throws ConflictException {
    staffLeaveServiceImpl.createNewLeave(createStaffLeaveForm);
    return new ResponseEntity<String>("new leave created", HttpStatus.OK);
  }

  @ApiOperation(value = "apply for leave", response = StaffLeave.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_LEAVE_BY_STATUS, produces = "application/json")
  public List<StaffLeave> getLeaveByStatus(HttpServletRequest request,
          @PathVariable String status) {
    return staffLeaveServiceImpl.getLeavesByStatus(status);
  }

  @ApiOperation(value = "update staff leave status", response = String.class, httpMethod = "PUT", produces = "text/plain")
  @PutMapping(path = RestAPI.UPDATE_STATUS_BY_LEAVE_ID, produces = "text/plain")
  public ResponseEntity<String> updateStatus(@RequestBody UpdateStatusForm updateStatus,
          HttpServletRequest request) throws ConflictException {
    staffLeaveServiceImpl.updateStatusByLeaveId(updateStatus);
    return new ResponseEntity<String>("Status Updated.", HttpStatus.OK);
  }

  @ApiOperation(value = "get leaves left by user name", response = StaffLeaveAccountResponse.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_LEAVES_LEFT_BY_NAME, produces = "application/json")
  public ResponseEntity<List<StaffLeaveAccountResponse>> getLeavesLeft(
          @RequestParam("name") String userName) {
    return new ResponseEntity<List<StaffLeaveAccountResponse>>(
            staffLeaveServiceImpl.getLeaveLeft(userName), HttpStatus.OK);
  }

  @ApiOperation(value = "get leave by id", response = StaffLeave.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_LEAVE_BY_ID, produces = "application/json")
  public ResponseEntity<StaffLeave> getLeaveById(@RequestParam("id") Long id) {
    return new ResponseEntity<StaffLeave>(staffLeaveServiceImpl.getLeaveById(id), HttpStatus.OK);
  }

  @ApiOperation(value = "get all leaves by a faculty", response = StaffLeave.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_MY_LEAVES, produces = "application/json")
  public ResponseEntity<List<StaffLeave>> getMyLeaves(@PathVariable String username) {
    return new ResponseEntity<List<StaffLeave>>(staffLeaveServiceImpl.getMyLeaves(username),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "rejoining after leave", response = String.class, httpMethod = "PUT", produces = "text/plain")
  @PutMapping(path = RestAPI.REJOIN_AFTER_LEAVE, produces = "text/plain")
  public ResponseEntity<String> rejoin(@RequestBody StaffRejoinForm staffRejoinForm,
          HttpServletRequest request) throws ParseException {
    staffLeaveServiceImpl.rejoin(staffRejoinForm);
    return new ResponseEntity<String>("Leave Updated", HttpStatus.OK);
  }

  @ApiOperation(value = "credit leave", response = String.class, httpMethod = "PUT", produces = "text/plain")
  @PutMapping(path = RestAPI.CREDIT_LEAVE, produces = "text/plain")
  public ResponseEntity<String> creditLeave(@RequestBody StaffLeaveCreditForm staffLeaveCreditForm,
          HttpServletRequest request) throws ConflictException {
    return new ResponseEntity<String>(staffLeaveServiceImpl.creditLeave(staffLeaveCreditForm),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "cancel leave", response = String.class, httpMethod = "PUT", produces = "text/plain")
  @PutMapping(path = RestAPI.CANCEL_LEAVE, produces = "text/plain")
  public ResponseEntity<String> cancelLeave(@RequestParam("id") Long id) {
    return new ResponseEntity<String>(staffLeaveServiceImpl.cancelLeave(id), HttpStatus.OK);
  }

  @ApiOperation(value = "update leave", response = String.class, httpMethod = "PUT", produces = "text/plain")
  @PutMapping(path = RestAPI.UPDATE_LEAVE, produces = "text/plain")
  public ResponseEntity<String> updateLeave(@RequestBody ApplyStaffLeaveForm applyStaffLeaveForm,
          HttpServletRequest request) throws ConflictException, ParseException {
    String token = request.getHeader("Authorization");
    applyStaffLeaveForm.setAppliedBy(jwtResolver.getUserNameFromJwtToken(token));
    return new ResponseEntity<String>(
            "Leave updated for leave id " + staffLeaveServiceImpl.updateLeave(applyStaffLeaveForm),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "get leaves left using JWT token", response = StaffLeaveAccountResponse.class, httpMethod = "GET", produces = "application/json")
  @GetMapping(path = RestAPI.GET_MY_LEAVE_ACCOUNT, produces = "application/json")
  public ResponseEntity<StaffLeaveAccountResponse> getMyLeaveAccount(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    return new ResponseEntity<StaffLeaveAccountResponse>(
            staffLeaveServiceImpl.getMyLeaveAccount(jwtResolver.getUserNameFromJwtToken(token)),
            HttpStatus.OK
    );
  }
}



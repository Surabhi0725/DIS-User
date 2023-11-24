package sgsits.cse.dis.user.service;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.RequestParam;
import sgsits.cse.dis.user.dtos.StudentDto;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;

import java.util.List;

/**
 * The interface User services.
 */
public interface UserServices {
  List<ActiveStaffListResponse> getActiveStaffList() throws NotFoundException;

  /**
   * Exists by username boolean.
   *
   * @param userName the user name
   *
   * @return the boolean
   *
   * @throws NotFoundException the not found exception
   */
  String getUserId(String username);

  boolean existsByUsername(String userName) throws NotFoundException;

  /**
   * Find user boolean.
   *
   * @param signup the signup
   *
   * @return the boolean
   */
  boolean findUser(SignUpForm signup);

  /**
   * Find user type string.
   *
   * @param signup the signup
   *
   * @return the string
   */
  String findUserType(SignUpForm signup);

  /**
   * Update email and user id boolean.
   *
   * @param mobileNo the mobile no
   *
   * @return the boolean
   */
  boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo);

  String getByUserName(String userid);

    List<StudentDto> getStudentUserNameList();
}

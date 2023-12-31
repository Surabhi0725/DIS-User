package sgsits.cse.dis.user.service;

import org.springframework.dao.DataIntegrityViolationException;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.dtos.StaffBasicProfileDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.request.AddNewUser;

import java.util.List;
import java.util.Optional;

public interface StaffService {

  List<FacultyDataDto> getFacultyData();

  List<FacultyDataDto> getStaffData();

  List<Object[]> getAllEmployeeNamesAndUserId();

  List<Object[]> getAllUsernameAndEmail();

  StaffBasicProfileDto getStaffBasicProfile(final String userId) throws InternalServerError;

  void addOrUpdateStaffBasicProfile(final StaffBasicProfileDto StaffBasicProfileDto)
          throws InternalServerError;

  String addNewMember(AddNewUser addNewUser, String addedBy)
          throws ConflictException, DataIntegrityViolationException;

  List<FacultyDataDto> getStaffWithName(String name);

  void updateUserIdByEmail(String userId, String email);

  String getNameByIdOptional(Optional<String> userId);

  String getNameById(String userId);
}

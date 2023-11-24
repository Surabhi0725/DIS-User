package sgsits.cse.dis.user.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.EnrollmentTemplate;
import sgsits.cse.dis.user.model.StudentProfile;

import java.util.List;

@Component
public interface StudentService {

  StudentBasicProfileDto getStudentBasicProfile(final String userId) throws InternalServerError;

  void addStudentBasicProfile(StudentBasicProfileDto studentBasicProfileDto)
          throws InternalServerError;

  void saveExcelData(MultipartFile file, String addedBy, int sheetNo) throws InternalServerError;

  List<PgProjectDetailDto> getPgProjectDetails(final String userId);

  List<StudentAttendanceDto> getStudentAttendanceRecord(final String userId);

  List<StudentLeaveDto> getStudentLeaveRecord(final String userId);

  List<StudentPlacementDto> getStudentPlacementRecord(final String userId);

  List<UgProjectDetailDto> geUgProjectDetails(final String userId);

  List<StudentProfile> fetchMEStudentsByYear(int year);

  ResponseEntity<ResponseMessage> uploadEnrollmentTemplate(EnrollmentTemplate schemeFileForm,
          MultipartFile file);

  EnrollmentTemplate getFile(String fileName);

  ResponseEntity<ResponseMessage> deleteTemplate(String fileName);

  List<StudentDto> getStudentFullNameList();

  StudentDto getNameById(String userId);
}

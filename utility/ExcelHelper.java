package sgsits.cse.dis.user.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StudentProfile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

  public static boolean hasExcelFormat(MultipartFile file) {

    return TYPE.equals(file.getContentType());
  }

  public static List<StudentProfile> excelToStudents(InputStream is, String createdBy,
          int sheetNo) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try {
      Workbook workbook = new XSSFWorkbook(is);
      Sheet sheet = workbook.getSheet(workbook.getSheetName(sheetNo));
      Iterator<Row> rows = sheet.iterator();
      List<StudentProfile> students = new ArrayList<StudentProfile>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        StudentProfile student = new StudentProfile();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {

            case 0: // enrollment id
              student.setEnrollmentId(currentCell.getStringCellValue());
              break;


            case 1: //full name
              student.setFullName(currentCell.getStringCellValue());
              break;

            case 2: // admission year
              student.setAdmissionYear((int) currentCell.getNumericCellValue());
              break;

            case 3: //course id
              student.setCourseId(currentCell.getStringCellValue());
              break;

            case 4: // Mobile Number
              student.setMobileNo((long) currentCell.getNumericCellValue());
              break;

            case 5://email
              student.setEmail(currentCell.getStringCellValue());
              break;

            case 6: // Dob
              java.sql.Date dob = new java.sql.Date(currentCell.getDateCellValue().getDate());
              student.setDob(dob);
              break;

            case 7://father name
              student.setFatherName(currentCell.getStringCellValue());
              break;

            case 8://father Contact
              student.setFatherContact((long) currentCell.getNumericCellValue());
              break;

            case 9://father email
              student.setFatherEmail(currentCell.getStringCellValue());
              break;

            case 10:// mother name
              student.setMotherName(currentCell.getStringCellValue());
              break;

            case 11://mother contact
              student.setMotherContact((long) currentCell.getNumericCellValue());
              break;

            case 12:// mother email
              student.setMotherEmail(currentCell.getStringCellValue());
              break;

            case 13:// category
              student.setCategory(currentCell.getStringCellValue());
              break;

            case 14:// gender
              student.setGender(currentCell.getStringCellValue());
              break;

            case 15: //blood group
              student.setBloodGroup(currentCell.getStringCellValue());
              break;

            case 16: //Scheme Year
              student.setSchemeYear((int) currentCell.getNumericCellValue());
              break;

            case 17: //Scheme Semester
              student.setSchemeSemester((int) currentCell.getNumericCellValue());
              break;

            default:
              break;
          }
          //                    System.out.println(cellIdx);
          cellIdx++;
        }
        student.setCreatedBy(createdBy);
        student.setCreatedDate(simpleDateFormat.format(new Date()));
        students.add(student);
      }

      workbook.close();

      return students;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }

  public static List<StaffBasicProfile> excelToStaff(InputStream is, String createdBy,
          int sheetNo) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try {
      Workbook workbook = new XSSFWorkbook(is);
      Sheet sheet = workbook.getSheet(workbook.getSheetName(sheetNo));
      Iterator<Row> rows = sheet.iterator();
      List<StaffBasicProfile> staff = new ArrayList<StaffBasicProfile>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        StaffBasicProfile member = new StaffBasicProfile();

        int cellIdx = 0;

        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {

            case 0:// employeeId;
              member.setEmployeeId(String.valueOf((int) currentCell.getNumericCellValue()));
              break;


            case 1: //name
              member.setName(currentCell.getStringCellValue());
              break;


            case 2: // nameAcronym
              member.setNameAcronym(currentCell.getStringCellValue());
              break;


            case 3: //currentDesignation
              member.setCurrentDesignation(currentCell.getStringCellValue());
              break;

            case 4: //classs
              member.setClasss(currentCell.getStringCellValue());
              break;


            case 5: //type
              member.setType(currentCell.getStringCellValue());
              break;


            case 6: //email
              member.setEmail(currentCell.getStringCellValue());
              break;

            case 7: //dob
              java.sql.Date dob = new java.sql.Date(currentCell.getDateCellValue().getDate());
              member.setDob(dob);
              break;

            case 8: // pan number
              member.setPanNumber(currentCell.getStringCellValue());
              break;

            case 9: //aadhar number
              member.setAadharNumber(String.valueOf((int) currentCell.getNumericCellValue()));
              break;

            case 10: //BloodGroup
              member.setBloodGroup(currentCell.getStringCellValue());
              break;

            case 11: //Gender
              member.setGender(currentCell.getStringCellValue());
              break;

            case 12: // motherName
              member.setMotherName(currentCell.getStringCellValue());
              break;

            case 13: //fathername
              member.setFatherName(currentCell.getStringCellValue());
              break;

            case 14: // MobileNo
              member.setMobileNo((long) currentCell.getNumericCellValue());
              break;

            case 15: //alternateMobileNo
              member.setAlternateMobileNo((long) currentCell.getNumericCellValue());
              break;

            case 16: //Joining date
              java.sql.Date joiningDate = new java.sql.Date(
                      currentCell.getDateCellValue().getDate());
              member.setJoiningDate(joiningDate);
              break;

            case 17: //Area of spec
              member.setAreaOfSpecialization(currentCell.getStringCellValue());
              break;

            default:
              break;
          }
          member.setCreatedBy(createdBy);
          member.setCreatedDate(simpleDateFormat.format(new Date()));
          //                    System.out.println(cellIdx);
          cellIdx++;
        }

        staff.add(member);
      }

      workbook.close();

      return staff;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
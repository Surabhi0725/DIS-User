package sgsits.cse.dis.user.service;

import org.springframework.http.ResponseEntity;
import sgsits.cse.dis.user.dtos.ExternalExaminerDto;
import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.ExternalExaminer;
import sgsits.cse.dis.user.model.PanelOfPractical;

import java.io.FileNotFoundException;
import java.util.List;

public interface PanelOfPracticalService {

  List<ExternalExaminer> getAllExternals();

  List<String> getAllInternals();

  List<PanelOfPractical> getAllPOP();

  void addPanelOfPractical(PanelOfPracticalDto panelOfPracticalDto) throws InternalServerError;

  void addExternalExaminer(ExternalExaminerDto externalExaminerDto) throws InternalServerError;

  void updateExternalExaminer(ExternalExaminerDto externalExaminerDto, Long id)
          throws EventDoesNotExistException, ConflictException;

  ExternalExaminer getExternalById(Long id);

  PanelOfPractical getPOPById(String id);

  ResponseEntity<ResponseMessage> deletePOP(String id) throws FileNotFoundException;

  void updatePOP(PanelOfPracticalDto panelOfPracticalDto, String id)
          throws ConflictException, EventDoesNotExistException;
}

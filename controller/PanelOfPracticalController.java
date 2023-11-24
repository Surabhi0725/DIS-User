package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgsits.cse.dis.user.dtos.ExternalExaminerDto;
import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.ExternalExaminer;
import sgsits.cse.dis.user.model.PanelOfPractical;
import sgsits.cse.dis.user.service.PanelOfPracticalService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "Staff controller")
@RestController
public class PanelOfPracticalController {

  @Autowired
  PanelOfPracticalService panelOfPracticalService;

  @ApiOperation(value = "Get all Panel of Practicals", httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/panelOfPractical", produces = "application/json")
  public ResponseEntity<List<PanelOfPractical>> getAllPOP() {
    return new ResponseEntity<List<PanelOfPractical>>(panelOfPracticalService.getAllPOP(),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "Get all External Examiners", httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/externalExaminer", produces = "application/json")
  public ResponseEntity<List<ExternalExaminer>> getAllExternals() {
    return new ResponseEntity<List<ExternalExaminer>>(panelOfPracticalService.getAllExternals(),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "Get all Internal Examiners", httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/internalExaminer", produces = "application/json")
  public ResponseEntity<List<String>> getAllInternalExaminers() {
    return new ResponseEntity<List<String>>(panelOfPracticalService.getAllInternals(),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "Add Panel of practical", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/panelOfPractical")
  public ResponseEntity<ResponseMessage> addPanelOfPractical(HttpServletRequest request,
          @RequestBody PanelOfPracticalDto panelOfPracticalDto) throws InternalServerError {
    panelOfPracticalService.addPanelOfPractical(panelOfPracticalDto);
    return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseMessage("Panel of Practical Successfully Added"));
  }

  @ApiOperation(value = "Get Panel of Practical by id", httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/panelOfPractical/{id}", produces = "application/json")
  public ResponseEntity<PanelOfPractical> getPOPById(@PathVariable String id) {
    return new ResponseEntity<PanelOfPractical>(panelOfPracticalService.getPOPById(id),
            HttpStatus.OK
    );
  }

  @ApiOperation(value = "Delete Panel of Practical by id", httpMethod = "DELETE", produces = "application/json")
  @DeleteMapping(path = "/panelOfPractical/{id}", produces = "application/json")
  public ResponseEntity<ResponseMessage> deletePOP(@PathVariable String id)
          throws FileNotFoundException {
    return panelOfPracticalService.deletePOP(id);
  }

  @ApiOperation(value = "Update Panel of Practical By id", response = Object.class, httpMethod = "PUT", produces = "application/json")
  @PutMapping(value = "/panelOfPractical/{id}")
  public ResponseEntity<ResponseMessage> updatePOP(HttpServletRequest request,
          @RequestBody PanelOfPracticalDto panelOfPracticalDto, @PathVariable String id)
          throws InternalServerError, ConflictException, EventDoesNotExistException {
    panelOfPracticalService.updatePOP(panelOfPracticalDto, id);
    return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseMessage("Panel of Practical Updated Added"));
  }

  @ApiOperation(value = "Add External Examiner", response = Object.class, httpMethod = "POST", produces = "application/json")
  @PostMapping(value = "/externalExaminer")
  public ResponseEntity<ResponseMessage> addExternalExaminer(HttpServletRequest request,
          @RequestBody ExternalExaminerDto externalExaminerDto) throws InternalServerError {
    panelOfPracticalService.addExternalExaminer(externalExaminerDto);
    return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseMessage("External Successfully Added"));
  }

  @ApiOperation(value = "Update External Examiner By id", response = Object.class, httpMethod = "PUT", produces = "application/json")
  @PutMapping(value = "/externalExaminer/{id}")
  public ResponseEntity<ResponseMessage> updateExternalExaminer(HttpServletRequest request,
          @RequestBody ExternalExaminerDto externalExaminerDto, @PathVariable Long id)
          throws InternalServerError, ConflictException, EventDoesNotExistException {
    panelOfPracticalService.updateExternalExaminer(externalExaminerDto, id);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("External Updated Added"));
  }

  @ApiOperation(value = "Get External Examiner by id", httpMethod = "GET", produces = "application/json")
  @GetMapping(path = "/externalExaminer/{id}", produces = "application/json")
  public ResponseEntity<ExternalExaminer> getExternalById(@PathVariable Long id) {
    return new ResponseEntity<ExternalExaminer>(panelOfPracticalService.getExternalById(id),
            HttpStatus.OK
    );
  }
}

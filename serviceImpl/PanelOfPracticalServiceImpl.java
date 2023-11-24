package sgsits.cse.dis.user.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.ExternalExaminerDto;
import sgsits.cse.dis.user.dtos.PanelOfPracticalDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.model.ExternalExaminer;
import sgsits.cse.dis.user.model.PanelOfPractical;
import sgsits.cse.dis.user.repo.ExternalExaminerRepository;
import sgsits.cse.dis.user.repo.PanelOfPracticalRepository;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.service.PanelOfPracticalService;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class PanelOfPracticalServiceImpl implements PanelOfPracticalService {

  private final PanelOfPracticalRepository panelOfPracticalRepository;
  private final StaffBasicProfileRepository staffBasicProfileRepository;
  private final ExternalExaminerRepository externalExaminerRepository;

  public PanelOfPracticalServiceImpl(PanelOfPracticalRepository panelOfPracticalRepository,
          StaffBasicProfileRepository staffBasicProfileRepository,
          ExternalExaminerRepository externalExaminerRepository) {
    this.panelOfPracticalRepository = panelOfPracticalRepository;
    this.staffBasicProfileRepository = staffBasicProfileRepository;
    this.externalExaminerRepository = externalExaminerRepository;
  }

  @Override
  public List<ExternalExaminer> getAllExternals() {
    return (List<ExternalExaminer>) externalExaminerRepository.findAll();
  }

  @Override
  public List<String> getAllInternals() {
    return staffBasicProfileRepository.findNames();
  }

  @Override
  public List<PanelOfPractical> getAllPOP() {
    return (List<PanelOfPractical>) panelOfPracticalRepository.findAll();
  }

  @Override
  public void addPanelOfPractical(PanelOfPracticalDto panelOfPracticalDto)
          throws InternalServerError {

    try {
      PanelOfPractical panelOfPractical = new PanelOfPractical();
      panelOfPractical.setId(panelOfPracticalDto.getId());
      panelOfPractical.setInternalFaculty1(panelOfPracticalDto.getInternalFaculty1());
      panelOfPractical.setInternalFaculty2(panelOfPracticalDto.getInternalFaculty2());
      panelOfPractical.setExternalFaculty(panelOfPracticalDto.getExternalFaculty());
      panelOfPractical.setSubjectCode(panelOfPracticalDto.getSubjectCode());
      panelOfPractical.setSubjectName(panelOfPracticalDto.getSubjectName());
      panelOfPractical.setLabAssistant(panelOfPracticalDto.getLabAssistant());
      panelOfPractical.setLabTechnician(panelOfPracticalDto.getLabTechnician());
      panelOfPractical.setLabTechnician(panelOfPracticalDto.getLabTechnician());
      panelOfPractical.setCreationDate(new Date());
      panelOfPracticalRepository.save(panelOfPractical);
    } catch (Exception e) {
      System.out.println(e);
      throw new InternalServerError("Cannot add Panel of Practical");
    }
  }

  @Override
  public void addExternalExaminer(ExternalExaminerDto externalExaminerDto)
          throws InternalServerError {
    try {
      ExternalExaminer externalExaminer = new ExternalExaminer();
      externalExaminer.setId(externalExaminerDto.getId());
      externalExaminer.setName(externalExaminerDto.getName());
      externalExaminer.setMobileNo(externalExaminerDto.getMobileNo());
      externalExaminer.setEmailId(externalExaminerDto.getEmailId());
      externalExaminer.setDesignation(externalExaminerDto.getDesignation());
      externalExaminer.setBankName(externalExaminerDto.getBankName());
      externalExaminer.setBranchAddress(externalExaminerDto.getBranchAddress());
      externalExaminer.setAccountNumber(externalExaminerDto.getAccountNumber());
      externalExaminer.setIfscCode(externalExaminerDto.getIfscCode());
      externalExaminerRepository.save(externalExaminer);
    } catch (Exception e) {
      System.out.println(e);
      throw new InternalServerError("Cannot add External");
    }
  }

  @Override
  public void updateExternalExaminer(ExternalExaminerDto externalExaminerDto, Long id)
          throws EventDoesNotExistException, ConflictException {

    if (externalExaminerRepository.existsById(id)) {
      ExternalExaminer existing = externalExaminerRepository.findByid(id).get();
      System.out.println(existing);
      ExternalExaminer externalExaminer = new ExternalExaminer(existing.getId(),
              externalExaminerDto.getName(), externalExaminerDto.getMobileNo(),
              externalExaminerDto.getEmailId(), externalExaminerDto.getDesignation(),
              externalExaminerDto.getBankName(), externalExaminerDto.getBranchAddress(),
              externalExaminerDto.getAccountNumber(), externalExaminerDto.getIfscCode()
      );

      externalExaminerRepository.save(externalExaminer);

      if (externalExaminer.equals(null)) {
        throw new ConflictException("External with email [" + id + "] couldn't be updated");
      }
    } else {
      throw new EventDoesNotExistException("External with email [" + id + "] not found.");
    }
  }

  @Override
  public ExternalExaminer getExternalById(Long id) {
    return externalExaminerRepository.findByid(id).get();
  }

  @Override
  public PanelOfPractical getPOPById(String id) {
    return panelOfPracticalRepository.findByid(id).get();
  }

  @Override
  public ResponseEntity<ResponseMessage> deletePOP(String id) throws FileNotFoundException {
    Optional<PanelOfPractical> pop = panelOfPracticalRepository.findByid(id);

    if (pop.isPresent()) {
      panelOfPracticalRepository.delete(pop.get());
      String message = "The panel of practical is deleted successfully.";
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } else {
      throw new FileNotFoundException("Panel not found with id " + id);
    }
  }

  @Override
  public void updatePOP(PanelOfPracticalDto panelOfPracticalDto, String id)
          throws ConflictException, EventDoesNotExistException {
    Optional<PanelOfPractical> pop = panelOfPracticalRepository.findByid(id);

    if (pop.isPresent()) {
      PanelOfPractical existing = pop.get();
      //            System.out.println(existing);

      PanelOfPractical panelOfPractical = new PanelOfPractical(existing.getId(),
              panelOfPracticalDto.getSubjectCode(), panelOfPracticalDto.getSubjectName(),
              panelOfPracticalDto.getInternalFaculty1(), panelOfPracticalDto.getInternalFaculty2(),
              panelOfPracticalDto.getExternalFaculty(), panelOfPracticalDto.getLabAssistant(),
              panelOfPracticalDto.getLabTechnician(), existing.getCreationDate()
      );

      panelOfPracticalRepository.save(panelOfPractical);

      if (panelOfPractical.equals(null)) {
        throw new ConflictException("Panel with id [" + id + "] couldn't be updated");
      }
    } else {
      throw new EventDoesNotExistException("Panel with id [" + id + "] not found.");
    }
  }
}

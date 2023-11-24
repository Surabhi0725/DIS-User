package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreatePanelOfTheoryForm;
import sgsits.cse.dis.user.model.PanelOfTheory;
import sgsits.cse.dis.user.repo.PanelOfTheoryRepository;
import sgsits.cse.dis.user.service.PanelOfTheoryService;

import java.util.List;

@Component
public class PanelofTheoryServicesImpl implements PanelOfTheoryService {

  @Autowired
  PanelOfTheoryRepository panelOfTheoryRepository;

  @Override
  public List<PanelOfTheory> getAllPanelOfTheory() {
    return (List<PanelOfTheory>) panelOfTheoryRepository.findAll();
  }

  @Override
  public String createPanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm)
          throws ConflictException {
    PanelOfTheory panelOfTheory = new PanelOfTheory();
    panelOfTheory.setCourse(createPanelOfTheoryForm.getCourse());
    panelOfTheory.setSubjectCode(createPanelOfTheoryForm.getSubjectCode());
    panelOfTheory.setFaculties(createPanelOfTheoryForm.getFaculties());
    panelOfTheory.setSubjectName(createPanelOfTheoryForm.getSubjectName());
    panelOfTheory.setYear(createPanelOfTheoryForm.getYear());
    PanelOfTheory test = panelOfTheoryRepository.save(panelOfTheory);
    if (test.equals(null)) throw new ConflictException("Unable to create panel.");
    return "Created panel successfully.";
  }

  public String updatePanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm)
          throws ConflictException {
    if (!panelOfTheoryRepository.existsBySubjectCodeAndYear(
            createPanelOfTheoryForm.getSubjectCode(), createPanelOfTheoryForm.getYear())) {
      throw new ConflictException("The given Panel does not exist.");
    }

    PanelOfTheory panelOfTheory = new PanelOfTheory();
    panelOfTheory.setCourse(createPanelOfTheoryForm.getCourse());
    panelOfTheory.setSubjectCode(createPanelOfTheoryForm.getSubjectCode());
    panelOfTheory.setFaculties(createPanelOfTheoryForm.getFaculties());
    panelOfTheory.setSubjectName(createPanelOfTheoryForm.getSubjectName());
    panelOfTheory.setYear(createPanelOfTheoryForm.getYear());
    PanelOfTheory test = panelOfTheoryRepository.save(panelOfTheory);
    if (test.equals(null)) throw new ConflictException("Unable to update panel.");

    return "Updated successfully";
  }

  @Override
  public void deletePanelOfTheory(String subjectCode, String year) throws ConflictException {
    if (panelOfTheoryRepository.deleteBySubjectCodeAndYear(subjectCode, year) <= 0) {
      throw new ConflictException("Cannot delete panel");
    }
  }
}

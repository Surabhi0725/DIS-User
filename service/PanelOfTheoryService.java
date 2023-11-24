package sgsits.cse.dis.user.service;

import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreatePanelOfTheoryForm;
import sgsits.cse.dis.user.model.PanelOfTheory;

import java.util.List;

@Component
public interface PanelOfTheoryService {

  List<PanelOfTheory> getAllPanelOfTheory();

  String createPanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm)
          throws ConflictException;

  String updatePanelOfTheory(CreatePanelOfTheoryForm createPanelOfTheoryForm)
          throws ConflictException;

  void deletePanelOfTheory(String subjectCode, String year) throws ConflictException;
}

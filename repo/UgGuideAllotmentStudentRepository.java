package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import sgsits.cse.dis.user.model.UgGuideAllotmentStudent;

import java.util.List;

public interface UgGuideAllotmentStudentRepository
        extends CrudRepository<UgGuideAllotmentStudent, String> {
  List<UgGuideAllotmentStudent> findByBatchDetailsId(String batchDetailsId);

  List<UgGuideAllotmentStudent> findByStudentId(String studentId);
}

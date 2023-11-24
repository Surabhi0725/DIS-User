package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import sgsits.cse.dis.user.model.PgGuideAllotmentStudent;

import java.util.List;

public interface PgGuideAllotmentStudentRepository
        extends CrudRepository<PgGuideAllotmentStudent, String> {
  List<PgGuideAllotmentStudent> findByBatchDetailsId(String batchDetailsId);

  List<PgGuideAllotmentStudent> findByStudentId(String studentId);
}

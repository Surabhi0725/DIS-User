package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sgsits.cse.dis.user.model.PgGuideAllotmentGuide;

import java.util.List;

public interface PgGuideAllotmentGuideRepository
        extends CrudRepository<PgGuideAllotmentGuide, String> {
  List<PgGuideAllotmentGuide> findBySession(String session);

  List<PgGuideAllotmentGuide> findByBatchIdAndSession(String batchId, String session);

  List<PgGuideAllotmentGuide> findByGuideId(String guideId);

  List<PgGuideAllotmentGuide> findByCoGuideId(String coGuideId);

  @Query(value = "UPDATE pg_guide_allotment_guide_details SET guide_id = ?1 where session = ?2 and batch_id = ?3 ", nativeQuery = true)
  @Modifying
  void updateGuideBySessionAndBatchId(String guideId, String session, String batchId);

  @Query(value = "UPDATE pg_guide_allotment_guide_details SET co_guide_id = ?1 where session = ?2 and batch_id = ?3 ", nativeQuery = true)
  @Modifying
  void updateCoGuideBySessionAndBatchId(String coGuideId, String session, String batchId);

  @Query(value = "UPDATE pg_guide_allotment_guide_details SET modified_by = ?1, modified_date = ?2 where session = ?3 and batch_id = ?4 ", nativeQuery = true)
  @Modifying
  void updateModifiedByAndModifiedDateBySessionAndBatchId(String modifiedBy, String modifiedDate,
          String session, String batchId);
}

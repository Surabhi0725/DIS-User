package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.PanelOfPractical;

import java.util.Optional;

@Repository
public interface PanelOfPracticalRepository extends CrudRepository<PanelOfPractical, String> {

  Optional<PanelOfPractical> findByid(String id);
}

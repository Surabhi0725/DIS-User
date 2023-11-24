package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Holiday;

@Repository("")
public interface HolidayRepository extends CrudRepository<Holiday, Integer> {}

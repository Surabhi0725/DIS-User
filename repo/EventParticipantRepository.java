package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.EventParticipant;

@Repository
public interface EventParticipantRepository extends CrudRepository<EventParticipant, String> {}
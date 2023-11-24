package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Event;

import java.util.List;

@Repository()
public interface EventRepository extends CrudRepository<Event, String> {

  Event findByEventId(String eventId);

  List<Event> findAllByParticipants_ParticipantId(String participantId);
}

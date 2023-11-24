package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.EventAttachment;

@Repository
public interface EventAttachmentRepository extends CrudRepository<EventAttachment, String> {}

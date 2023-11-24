package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Notification;

/**
 * The interface Notification repository.
 */
@Repository("notificationServiceRepository")
public interface NotificationRepository extends CrudRepository<Notification, String> {}

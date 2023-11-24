package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserTasks;

import java.util.List;

@Repository
public interface UserTaskRepository extends CrudRepository<UserTasks, String> {
  List<UserTasks> findByUserId(String userId);

  List<UserTasks> findByTaskId(String taskId);

  @Modifying
  long deleteTaskById(String id);

  //	@Query(value="SELECT user_tasks.user_id,staff_basic_profile.name as username, "
  //			+ "user_tasks.task_id, task.name as taskname ,"
  //			+ "user_tasks.deadline,user_tasks.description ,"
  //			+ "user_tasks.status,user_tasks.created_date "
  //			+ "FROM staff_basic_profile,task,user_tasks "
  //			+ "WHERE user_tasks.task_id = task.id AND  user_tasks.user_id=staff_basic_profile.user_id",nativeQuery = true )
  @Query(value = "SELECT user_tasks.user_id,staff_basic_profile.name as username, " +
          "user_tasks.task_id, task.name as taskname ,user_tasks.deadline,user_tasks.description ," +
          "user_tasks.status,user_tasks.created_date,user_tasks.id " +
          "FROM staff_basic_profile,task,user_tasks WHERE user_tasks.task_id = task.id AND " +
          " user_tasks.user_id=staff_basic_profile.user_id;", nativeQuery = true)
  List<Object[]> findAssignTaskInfo();

  @Query(value = "UPDATE user_tasks SET status =?1 WHERE id = ?2", nativeQuery = true)
  @Modifying
  void updateStatusById(String status, String id);

  List<UserTasks> findByStatus(String status);
}

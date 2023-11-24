package sgsits.cse.dis.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.TaskCategory;

@Repository
public interface TaskCategoryRepository extends CrudRepository<TaskCategory, String> {

  //	@Query(value = "SELECT *  FROM task_category", nativeQuery = true)
  //	List<Task> getDistinctName();
}

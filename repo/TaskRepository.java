package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {

  Task findIdByName(String name);

  Task findNameById(String id);

  //	@Query(value = "SELECT id,name FROM task WHERE category = ?1", nativeQuery = true)
  //	List<TaskCategoryResponse> findIdAndNameByCategoryId(String categoryId);
  //
  //	@Query(value = "SELECT DISTINCT category FROM task", nativeQuery = true)
  //	Optional<Task> getDistinctTask();
  @Query(value = "SELECT * FROM task WHERE category = ?1", nativeQuery = true)
  List<Task> findbyCategoryId(String categoryId);
}

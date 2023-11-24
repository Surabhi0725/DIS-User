package sgsits.cse.dis.user.service;

import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import sgsits.cse.dis.user.dtos.TaskStatusList;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.SearchTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;

import java.util.List;

public interface TaskService {
  List<TaskCategoryResponse> getTaskCategoryList();

  //List<Object[]> getAssignTasksInfo();
  List<SearchTaskResponse> getAssignTasksInfo();

  String assignTask(AssignTaskForm assignTaskForm, String assignedByUserId)
          throws ConflictException, DataIntegrityViolationException;

  List<CategorySpecificTaskResponse> getTasksFromCategoryId(String category)
          throws NotFoundException;

  List<SearchTaskResponse> searchTaskByUserId(String userId) throws NotFoundException;

  List<SearchTaskResponse> searchTaskByTaskId(String taskId) throws NotFoundException;

  void deleteTask(String id) throws ConflictException;

  void updateStatus(String status, String id);

  TaskStatusList fetchTaskStatusList();
}

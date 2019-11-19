package com.trilogyed.taskerservice.dao;

import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;

import java.util.List;

public interface TaskerDao {

   Task createTask(Task task);
   Task getTask(int id);
   List<Task> getAllTasks();
   List<Task> getTasksByCategory(String category);
   void updateTask(Task task);
   void deleteTask(int id);

}

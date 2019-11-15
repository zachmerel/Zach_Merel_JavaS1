package com.trilogyed.taskerservice.service;

import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import com.trilogyed.taskerservice.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    private TaskerDao dao;

    private AdserverClient adserverClient;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdserverClient adserverClient) {
        this.dao = dao;
        this.adserverClient = adserverClient;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(adserverClient.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();
        taskList.forEach(task -> tvmList.add(buildViewModel(task)));

        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskListByCategory = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmListByCategory = new ArrayList<>();
        taskListByCategory
                .forEach(task -> tvmListByCategory.add(buildViewModel(task)));

        return tvmListByCategory;
    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);

//        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(adserverClient.getAd());
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        //TODO convert task viewmodel into task
        Task taskToUpdate = new Task();
        taskToUpdate.setId(taskViewModel.getId());
        taskToUpdate.setCategory(taskViewModel.getCategory());
        taskToUpdate.setDueDate(taskViewModel.getDueDate());
        taskToUpdate.setCreateDate(taskViewModel.getCreateDate());
        taskToUpdate.setDescription(taskViewModel.getDescription());
        dao.updateTask(taskToUpdate);
    }

    public TaskViewModel buildViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(adserverClient.getAd());

        return tvm;
    }

    //
    // TASK API
    //


    public Task createTask(Task task) {
        return dao.createTask(task);
    }

    public Task getTask(int id) {
        return dao.getTask(id);
    }

    public List<Task> getAllTasks() {
        return dao.getAllTasks();
    }

    public List<Task> getTasksByCategory(String category) {
        return dao.getTasksByCategory(category);
    }
}

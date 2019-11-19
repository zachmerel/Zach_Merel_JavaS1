package com.trilogyed.taskerservice.controller;

import com.trilogyed.taskerservice.exception.NotFoundException;
import com.trilogyed.taskerservice.model.TaskViewModel;
import com.trilogyed.taskerservice.service.TaskerServiceLayer;
import com.trilogyed.taskerservice.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    private final AdserverClient adserverClient;

    @Autowired
    TaskerServiceLayer service;

    @Autowired
    public TaskerController(AdserverClient adserverClient) {
        this.adserverClient = adserverClient;
    }

    //DELETE TASK
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    //CREATE TASK
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskViewModel){
        return service.newTask(taskViewModel);
    }

    //UPDATE TASK
    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@RequestBody @Valid TaskViewModel taskViewModel){
        service.updateTask(taskViewModel);
    }

    //FIND TASK BY ID
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTaskById(@PathVariable int id){
        TaskViewModel taskViewModel = service.fetchTask(id);
        if(taskViewModel == null)
            throw new NotFoundException("Task could not be retrieved for id " + id);
        return taskViewModel;
    }

//    //FIND ALL TASKS
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        return service.fetchAllTasks();
    }

//    //FIND TASKS BY CATEGORY
    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasksByCategory(@PathVariable String category){
        List<TaskViewModel> taskViewModelList = service.fetchTasksByCategory(category);
        if(taskViewModelList.size() == 0){
            throw new NotFoundException("There are no tasks listed for category " + category);
        }
        return taskViewModelList;
    }
}

package com.trilogyed.taskerservice.service;


import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import com.trilogyed.taskerservice.util.feign.AdserverClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerServiceTest {

    private TaskerServiceLayer taskerServiceLayer;
    private TaskerDao taskerDao;
    private AdserverClient adserverClient;

    @Before
    public void setUp() throws Exception {
        taskerDao = mock(TaskerDao.class);
        adserverClient = mock(AdserverClient.class);

        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adserverClient);
    }

    @Test
    public void shouldReturnTaskById() {
        //arrange
        Task task = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        String ad = "Home Equity Loans @ 3.87% APR";
        TaskViewModel taskViewModelIExpect = new TaskViewModel(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad);

        //MOCK
        Task taskForTaskViewModel = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");


        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(taskForTaskViewModel.getId());
        taskViewModel.setDescription(taskForTaskViewModel.getDescription());
        taskViewModel.setCreateDate(taskForTaskViewModel.getCreateDate());
        taskViewModel.setDueDate(taskForTaskViewModel.getDueDate());
        taskViewModel.setCategory(taskForTaskViewModel.getCategory());
        taskViewModel.setAdvertisement(ad);

        when(taskerDao.getTask(1)).thenReturn(taskForTaskViewModel);
        when(adserverClient.getAd()).thenReturn(ad);

        //act
        TaskViewModel taskViewModelIGot = taskerServiceLayer.fetchTask(taskViewModelIExpect.getId());
        //assert
        assertEquals(taskViewModelIGot, taskViewModelIExpect);
    }

    @Test
    public void shouldCreateANewTask() {
        //arrange
        Task taskToInsert = new Task("Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");

        Task taskAfterInsert = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        String ad = "Home Equity Loans @ 3.87% APR";
        TaskViewModel taskViewModelIExpect = new TaskViewModel(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad);

        //MOCK
        Task taskForTaskViewModel = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");


        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(taskForTaskViewModel.getId());
        taskViewModel.setDescription(taskForTaskViewModel.getDescription());
        taskViewModel.setCreateDate(taskForTaskViewModel.getCreateDate());
        taskViewModel.setDueDate(taskForTaskViewModel.getDueDate());
        taskViewModel.setCategory(taskForTaskViewModel.getCategory());
        taskViewModel.setAdvertisement(ad);

        when(taskerDao.getTask(1)).thenReturn(taskForTaskViewModel);
        when(adserverClient.getAd()).thenReturn(ad);


        //act
        TaskViewModel taskViewModelIGot = taskerServiceLayer.newTask(taskViewModelIExpect);
        //assert
        assertEquals(taskViewModelIExpect, taskViewModelIGot);
    }

    @Test
    public void shouldGetAllTasks() {
        //arrange
        Task task1 = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        String ad1 = "Home Equity Loans @ 3.87% APR";
        TaskViewModel taskViewModelIExpect1 = new TaskViewModel(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad1);


        Task task2 = new Task(2, "Moe Lawn", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        TaskViewModel taskViewModelIExpect2 = new TaskViewModel(2, "Moe Lawn", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad1);


        List<TaskViewModel> listOfTaskViewModelsIExpect = new ArrayList<>();
        listOfTaskViewModelsIExpect.add(taskViewModelIExpect1);
        listOfTaskViewModelsIExpect.add(taskViewModelIExpect2);

        //MOCK
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        when(taskerDao.getAllTasks()).thenReturn(taskList);

        when(adserverClient.getAd()).thenReturn(ad1);


        //act
        List<TaskViewModel> listOfTaskViewModelsIGot = taskerServiceLayer.fetchAllTasks();
        //assert
        assertEquals(listOfTaskViewModelsIExpect, listOfTaskViewModelsIGot);
    }

    @Test
    public void shouldGetAllTasksByCategory() {
        //arrange
        Task task1 = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        String ad1 = "Home Equity Loans @ 3.87% APR";
        TaskViewModel taskViewModelIExpect1 = new TaskViewModel(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad1);

        Task task2 = new Task(2, "Moe Lawn", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        TaskViewModel taskViewModelIExpect2 = new TaskViewModel(2, "Moe Lawn", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad1);

        Task task3 = new Task(3, "Do Summative", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Class");
        TaskViewModel taskViewModelIExpect3 = new TaskViewModel(3, "Moe Lawn", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Class", ad1);


        List<TaskViewModel> listOfTaskViewModelsIExpect = new ArrayList<>();
        listOfTaskViewModelsIExpect.add(taskViewModelIExpect1);
        listOfTaskViewModelsIExpect.add(taskViewModelIExpect2);


        //MOCK

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        when(taskerDao.getTasksByCategory("Chore")).thenReturn(taskList);
        when(adserverClient.getAd()).thenReturn(ad1);


        //act
        List<TaskViewModel> listOfTaskViewModelsIGot = taskerServiceLayer.fetchTasksByCategory("Chore");
        //assert
        assertEquals(listOfTaskViewModelsIExpect, listOfTaskViewModelsIGot);
    }

    @Test
    public void shouldBuildAViewModel() {
        //arrange
        Task task1 = new Task(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore");
        String ad1 = "Home Equity Loans @ 3.87% APR";
        TaskViewModel taskViewModelIExpect1 = new TaskViewModel(1, "Do Laundry", LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 1), "Chore", ad1);

        //MOCK
        when(adserverClient.getAd()).thenReturn(ad1);

        //act
        TaskViewModel taskViewModelIGot = taskerServiceLayer.buildViewModel(task1);

        //assert
        assertEquals(taskViewModelIExpect1, taskViewModelIGot);
    }

}

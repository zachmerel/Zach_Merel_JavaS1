package com.trilogyed.taskerservice.dao;

import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    private TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        //clean out the test db
        List<Task> tList = dao.getAllTasks();

        tList.stream()
                .forEach(taskViewModel -> dao.deleteTask(taskViewModel.getId()));
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void addGetDeleteTask() {

        Task taskIExpect = new Task();
        taskIExpect.setDescription("Do laundry");
        taskIExpect.setCreateDate(LocalDate.of(2019,1,1));
        taskIExpect.setDueDate(LocalDate.of(2019,1,1));
        taskIExpect.setCategory("Chore");

        taskIExpect = dao.createTask(taskIExpect);

        Task taskIGot = dao.getTask(taskIExpect.getId());

        assertEquals(taskIExpect, taskIGot);

        dao.deleteTask(taskIExpect.getId());

        taskIGot = dao.getTask(taskIExpect.getId());

        assertNull(taskIGot);

    }


    @Test
    public void getAllTasks() {

        Task task = new Task();
        task.setDescription("Do laundry");
        task.setCreateDate(LocalDate.of(2019,1,1));
        task.setDueDate(LocalDate.of(2019,1,1));
        task.setCategory("Chore");

        dao.createTask(task);

        Task task2 = new Task();
        task2.setDescription("Mow lawn");
        task2.setCreateDate(LocalDate.of(2019,1,1));
        task2.setDueDate(LocalDate.of(2019,1,1));
        task2.setCategory("Chore");

        dao.createTask(task2);

        List<Task> taskList = dao.getAllTasks();

        assertEquals(taskList.size(), 2);

    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setDescription("Do laundry");
        task.setCreateDate(LocalDate.of(2019,1,1));
        task.setDueDate(LocalDate.of(2019,1,1));
        task.setCategory("Chore");

        dao.createTask(task);

        Task task2 = new Task();
        task2.setDescription("Mow lawn");
        task2.setCreateDate(LocalDate.of(2019,1,1));
        task2.setDueDate(LocalDate.of(2019,1,1));
        task2.setCategory("Chore");

        dao.createTask(task2);

        Task task3 = new Task();
        task3.setDescription("Do summative 8");
        task3.setCreateDate(LocalDate.of(2019,1,1));
        task3.setDueDate(LocalDate.of(2019,1,1));
        task3.setCategory("Class");

        dao.createTask(task3);

        List<Task> choreTaskList = dao.getTasksByCategory("Chore");
        assertEquals(choreTaskList.size(), 2);

        List<Task> classTaskList = dao.getTasksByCategory("Class");
        assertEquals(choreTaskList.size(), 2);
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setDescription("Do laundry");
        task.setCreateDate(LocalDate.of(2019,1,1));
        task.setDueDate(LocalDate.of(2019,1,1));
        task.setCategory("Chore");

        task = dao.createTask(task);

        task.setDescription("test update task");
        task.setCreateDate(LocalDate.of(1963,11,22));
        task.setDueDate(LocalDate.of(2016,11,7));
        task.setCategory("update");

        dao.updateTask(task);

        Task task2 = dao.getTask(task.getId());

        assertEquals(task2,task);
    }


// Testing should be covered by addGetDeleteTask
//    @Test
//    public void createTask() {
//    }
//
//    @Test
//    public void getTask() {
//    }
//
//    @Test
//    public void deleteTask() {
//    }
}
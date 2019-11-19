package com.trilogyed.taskerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;
    @NotEmpty(message = "You must enter a task description." )
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;
    @NotNull(message = "You must enter a date")
    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate createDate;
    @NotNull(message = "You must enter a date")
    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dueDate;
    @Size(max = 50,message = "Category must be less than 50 characters")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Task(int id, String description, LocalDate createDate, LocalDate dueDate, String category) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.category = category;
    }

    public Task(String description, LocalDate createDate, LocalDate dueDate, String category) {
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.category = category;
    }

    public Task() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                '}';
    }
}


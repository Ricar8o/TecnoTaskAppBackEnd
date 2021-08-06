package com.tecno.taskapp.service;

import java.util.List;

import com.tecno.taskapp.data.model.Task;
import com.tecno.taskapp.exception.TaskNotFoundException;

public interface TaskService {
    
    Task getTask(String id) throws TaskNotFoundException;
    List<Task> getTasks();
    Task createTask(Task task);
    void delete(String id);
}
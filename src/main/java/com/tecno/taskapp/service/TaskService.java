package com.tecno.taskapp.service;

import java.util.List;

import com.tecno.taskapp.data.model.Task;

public interface TaskService {
    
    List<Task> getTasks();
    Task createTask(Task task);
}
package com.tecno.taskapp.service.impl;

import java.util.List;

import com.tecno.taskapp.data.TaskRepository;
import com.tecno.taskapp.data.model.Task;
import com.tecno.taskapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        Task created = taskRepository.save(task);
        return created;
    }
    
}

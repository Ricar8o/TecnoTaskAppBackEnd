package com.tecno.taskapp.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tecno.taskapp.data.TaskRepository;
import com.tecno.taskapp.data.model.Task;
import com.tecno.taskapp.exception.TaskNotFoundException;
import com.tecno.taskapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    static final List<String> allowed = Arrays.asList("primary", "secondary", "success", "danger", "warning", "info", "light" , "dark");

    @Override
    public Task getTask(String id) throws TaskNotFoundException{
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            return task.get();
        }
        else{
            throw new TaskNotFoundException(id);
        }
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        if (!allowed.contains(task.getType())){
            task.setType("secondary");
        } 
        Task created = taskRepository.save(task);
    
        return created;
    }

    @Override
    public void delete(String id) {
        taskRepository.deleteById(id);;
    }
    
}

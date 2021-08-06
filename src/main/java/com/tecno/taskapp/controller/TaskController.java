package com.tecno.taskapp.controller;

import java.util.List;

import com.tecno.taskapp.data.model.Task;
import com.tecno.taskapp.exception.TaskNotFoundException;
import com.tecno.taskapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/tasks" )
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getTask(@PathVariable String id){
        try {
            return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK) ;
        } catch (TaskNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND) ;
        }
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping
    public Task PutTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id){
        try {
            taskService.getTask(id);
            taskService.delete(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK) ;
        } catch (TaskNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND) ;
        }
        
    }
}

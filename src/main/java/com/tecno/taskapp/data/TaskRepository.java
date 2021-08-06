package com.tecno.taskapp.data;

import com.tecno.taskapp.data.model.Task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task,String>{
    
}

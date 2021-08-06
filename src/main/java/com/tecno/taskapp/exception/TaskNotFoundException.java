package com.tecno.taskapp.exception;

public class TaskNotFoundException extends Exception {

    private static final long serialVersionUID = 3844371229474477486L;

    public TaskNotFoundException(String id) {
        super("Could not find task " + id);
    }
    
}
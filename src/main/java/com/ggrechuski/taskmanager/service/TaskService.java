package com.ggrechuski.taskmanager.service;

import com.ggrechuski.taskmanager.repository.TaskRepository;
import com.ggrechuski.taskmanager.model.Task;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private final TaskRepository repository;
    private List<Task> tasksList;

    public TaskService(TaskRepository repository) throws IOException{
        this.repository = repository;
        this.tasksList = repository.load();
    }

    private int generatorID(){
        if(tasksList.isEmpty())
            return 1;
        else {
            List<Integer> ids = tasksList.stream()
                    .map(t -> t.getId())
                    .collect(Collectors.toList());

            return Collections.max(ids) + 1;
        }
    }

    public void addTask(String description) throws IOException {
        Task task = new Task(generatorID(), description, false);
        tasksList.add(task);
        repository.save(tasksList);
    }

    public String listTasks(){
        return tasksList.stream()
                .map(Task::toString)
                .collect(Collectors.joining("\n"));
    }
}
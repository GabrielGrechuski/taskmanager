package com.ggrechuski.taskmanager.model;

public class Task {
    private Integer id;
    private String name;
    private String description;
    private Boolean completed;

    public Task(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Task(Integer id, String name, String description, Boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    // Getters and Setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }
    public Boolean getCompleted(){ return completed; }
    public void setCompleted(Boolean completed){ this.completed = completed; }
}

package com.ggrechuski.taskmanager.model;

public class Task {
    private Integer id;
    private String description;
    private Boolean completed;

    public Task(Integer id, String description, Boolean completed) {
        this.id = id;
        this.description = description;
    }

    public Task(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }
    public Boolean getCompleted(){ return completed; }
    public void setCompleted(Boolean completed){ this.completed = completed; }

    @Override
    public String toString(){
        return "ID: " + getId() + " - Description: " + getDescription() + " - Completed: " + String.valueOf(getCompleted());
    }
}

package com.ggrechuski.taskmanager.repository;

import com.ggrechuski.taskmanager.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    // Check if the folder exists and create it if necessary
    private void ensureDataDirectoryExists(){
        String pathFolder = "data";
        File folder = new File(pathFolder);

        if(!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Checks if the file exists and creates it if necessary
    private void ensureFileExists() throws IOException{
        ensureDataDirectoryExists();

        String pathFile = "data/tasks.txt";
        File tasks  = new File(pathFile);

        if(!tasks.exists()) {
            tasks.createNewFile();
        }
    }

    // Transforms a task into a line of text
    public String convertTaskToLine(Task task){
        return task.getId() + "," + task.getDescription() + "," + task.getCompleted();
    }

    // Transforms a line of text into a task
    public Task convertLineToTask(String line){
        String[] fields = line.split(",");
        return new Task(Integer.parseInt(fields[0]), fields[1], Boolean.parseBoolean(fields[2]));
    }

    // Loads tasks from the persistence file into an ArrayList of tasks
    public List<Task> load() throws IOException{
        ensureFileExists();

        List<Task> tasks = new ArrayList<Task>();

        try(BufferedReader br = new BufferedReader(new FileReader("data/tasks.txt"))){
            String line =  br.readLine();

            while(line != null){
                tasks.add(convertLineToTask(line));
                line =  br.readLine();
            }
        }
        catch (IOException e){
            throw new IOException("Error reading file in: data/tasks.txt");
        }
        return tasks;
    }

    // It receives the list and writes it to the file, overwriting the current content
    public void save(List<Task> tasks) throws IOException{
        ensureFileExists();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/tasks.txt"))){
            for(Task task : tasks){
                bw.write(convertTaskToLine(task));
                bw.newLine();
            }
        } catch (Exception e) {
            throw new IOException("Error writing file in: data/tasks.txt");
        }
    }
}

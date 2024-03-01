package com.example.myBackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; // Can be the name of the task or project
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Task parentTask; // Reference to the parent task/project

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Task> subTasks = new ArrayList<>(); // List of sub-tasks/projects

    // Constructors, getters, and setters

    public Task() {
    }

    // Methods to manage sub-tasks
    public void addSubTask(Task subTask) {
        subTasks.add(subTask);
        subTask.setParentTask(this);
    }

    public void removeSubTask(Task subTask) {
        subTasks.remove(subTask);
        subTask.setParentTask(null);
    }

    // Getters and Setters
}
package TaskManagementSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private final String id;
    private final String name;
    private final String description;
    private boolean completed;
    private final String category;
    private LocalDateTime dueDate;
    private Priority priority;

    public Task(String id, String name, String description, LocalDateTime dueDate2, String category2, Priority priority2){
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
        this.category = category2;
        this.dueDate = dueDate2;
        this.priority = priority2;
    }

    public boolean setCompleted(){
        this.completed = true;
        return completed;
    }

    public void markPending(){
        this.completed = false;
    }

    public String getId(){
        return id;
    }

    public LocalDateTime getDueDate(){
        return dueDate;
    }

    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s | Due: %s | %s",
                completed ? "✔" : "✗", name, priority, category, dueDate, description);
    }
}

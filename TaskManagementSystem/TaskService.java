package TaskManagementSystem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.UUID;

public class TaskService {
    private TaskRepository repository = new TaskRepository();

    public Task addTask(String title, String description, LocalDateTime dueDate, String category, Priority priority) {
        Task task = new Task(UUID.randomUUID().toString(), title, description, dueDate, category, priority);
        repository.addTask(task);
        return task;
    }

    public void markTaskCompleted(String id) {
        Task t = repository.getTask(id);
        if (t != null) t.setCompleted();
    }

    public void deleteTask(String id) {
        repository.deleteTask(id);
    }

    public List<Task> listTasks(boolean showCompleted) {
        return repository.getAllTask().stream()
                .filter(t -> showCompleted || !t.setCompleted())
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public List<Task> filterByCategory(String category) {
        return repository.getAllTask().stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}


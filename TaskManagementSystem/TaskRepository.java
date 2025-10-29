package TaskManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task){
        taskMap.put(task.getId(), task);
    }

    public Task getTask(String id){
        return taskMap.get(id);
    }

    public void deleteTask(String id){
        taskMap.remove(id);
    }

    public List<Task> getAllTask(){
        return new ArrayList<>(taskMap.values());    
    }
}

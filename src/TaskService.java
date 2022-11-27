import java.time.LocalDate;
import java.util.*;

public class TaskService {

    private Map<Integer, Task> taskList = new HashMap<>();

//    public TaskService(Map<Integer,Task> taskList) {
//        this.taskList = taskList;
//    }

    public Map<Integer, Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(Map<Integer, Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        taskList.put(task.getTaskId(),task);
    }
//    public void addTask(DailyTask task) {
//        taskList.put(task.getTaskId(),task);
//    }

    public void removeTask(Integer id) {
        this.getTaskList().remove(id);
    }

    public List<Task> getTasksListOnDate(LocalDate date) {
        List<Task> tasksListOnDate = new ArrayList<>();
        for (Task task : taskList.values()) {
            if (task.isAvailable(date)) {
                tasksListOnDate.add(task);
            }
        }
        return tasksListOnDate;
    }

    public Map<Integer, Task> getAllTasks(TaskService tasks) {
        Map<Integer, Task> allTasks = tasks.getAllTasks(tasks);
        return allTasks;

    }

    public static void printData(TaskService tasks) {
        for (Map.Entry<Integer, Task> taskEntry : tasks.getTaskList().entrySet()) {
            System.out.println(taskEntry);
        }
    }

    @Override
    public String toString() {
        return "Список задач:" +getTaskList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return getTaskList().equals(that.getTaskList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskList());
    }
}


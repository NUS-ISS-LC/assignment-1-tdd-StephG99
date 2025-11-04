package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
      Task t = tasks.get(description);
      t.setComplete(true);
   }

   public boolean getStatus(String description) {
      return getTask(description).isComplete();
   }

   public Task getTask(String description) {
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      Collection<Task> res = new ArrayList();

      for (Task task : tasks.values()) {
         if(task.isComplete()) {
            res.add(task);
         }
      }
      return res;
   }
}

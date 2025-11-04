package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;


import static org.junit.Assert.*;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList toDoList;
    private Task t1, t2;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();
        t1 = new Task("Do Assignment");
        t2 = new Task("Buy Groceries");
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        toDoList = null;
    }

    @Test
    public void testAddTask() {
        toDoList.addTask(t1);
        assertEquals(t1, toDoList.getTask("Do Assignment"));
    }

    @Test
    public void testGetStatus() {
        toDoList.addTask(t1);
        boolean status = toDoList.getStatus(t1.getDescription());
        assertEquals(t1.isComplete(), status);
    }

    
    @Test
    public void testRemoveTask() {
        toDoList.addTask(t1);
        Task removedTask = toDoList.removeTask(t1.getDescription());

        assertEquals(t1, removedTask);

        assertNull(toDoList.getTask(t1.getDescription()));

        assertTrue(toDoList.getAllTasks().isEmpty());
    }

    @Test
    public void testGetCompletedTasks() {
        toDoList.addTask(t1);
        toDoList.addTask(t2);

        t1.setComplete(true);

        Collection<Task> completed = toDoList.getCompletedTasks();

        assertEquals(1, completed.size());
        assertTrue(completed.contains(t1));
        assertFalse(completed.contains(t2));
    }
}
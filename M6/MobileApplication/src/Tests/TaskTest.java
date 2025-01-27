package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Task;

class TaskTest {
	
	// The following tests provide 100% coverage for the Task class

	@Test
	void testTaskClass() {
		Task task = new Task("111", "First Task", "This is the first task");
		assertTrue(task.getTaskId().equals("111"));
		assertTrue(task.getTaskName().equals("First Task"));
		assertTrue(task.getTaskDescription().equals("This is the first task"));
	}
	
// ----------------------------------------------- TESTS FOR taskID ----------------------------------------
	
	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "First Task", "First Task");
		});
	}
	
	@Test
	void testTaskIdIsNotNull() {
		Task task = new Task("001", "task 1", "this is task 1");
		assertNotNull(task.getTaskId());
	}
	
	@Test 
	void testTaskIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "First Task", "First task");
		});
	}
	
	@Test
	void testTaskIdIsLessThan10Characters() {
		Task task = new Task("001", "First Task", "this is the first task");
		assertTrue(task.getTaskId().length()<10);
	}
	
	@Test
	void testTaskIdIsExactly10Characters() {
		Task task = new Task("1000110001", "first task", "this is first task");
		assertTrue(task.getTaskId().length()==10);
	}

// ----------------------------------------------- TESTS FOR taskName ---------------------------------------
	
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("112", null, "First First Task");
		});
	}
	
	@Test 
	void testTaskNameIsNotNull() {
		Task task = new Task("002", "second task", "this is second task");
		assertNotNull(task.getTaskName());
	}
	
	@Test 
	void testTaskNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "This name is way too long", "First task");
		});
	}
	
	@Test
	void testTaskNameIsLessThan20Characters() {
		Task task = new Task("003", "task three", "this is third task");
		assertTrue(task.getTaskName().length()<20);
	}
	
	@Test
	void testTaskNameIsExactly20Characters() {
		Task task = new Task("004", "task four4task four4", "this is task four");
		assertTrue(task.getTaskName().length()==20);
	}
	
// ------------------------------------------- TESTS FOR taskDescription -------------------------------------
	
	@Test
	void testTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("112", "Task Name", null);
		});
	}
	
	@Test
	void testTaskDescriptionIsNotNull() {
		Task task = new Task("005", "task five", "this is task five");
		assertNotNull(task.getTaskDescription());
	}
	
	@Test 
	void testTaskDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Task name", "First taskFirst taskFirst taskFirst taskFirst taskFirst task");
		});
	}
	
	@Test
	void testTaskDescriptionIsLessThan50Characters() {
		Task task = new Task("006", "task six", "this is task six");
		assertTrue(task.getTaskDescription().length()<50);
	}
	
	@Test 
	void testTaskDescriptionIsExactly50Characters() {
		Task task = new Task("007", "task seven", "this is task seven07this is task seven07seven00707");
		assertTrue(task.getTaskDescription().length()==50);
	}
	
// ----------------------------- tests for the setter method for the task's name -------------------------------
	
	@Test
	void testSetTaskNameIsNull() {
		Task task = new Task("111", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName(null);
		});
	}
	
	@Test
	void testSetTaskName() {
		Task task = new Task("201", "task 201", "this is task 201");
		assertNotNull(task.getTaskName());
	}
	
	@Test
	void testSetTaskNameIsTooLong() {
		Task task = new Task("111", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName("This task name is way too long");
		});
	}
	
	@Test
	void testSetTaskNameIsLessThan20Characters() {
		Task task = new Task("202", "task 202", "this is task 202");
		assertTrue(task.getTaskName().length()<20);
	}
	
	@Test 
	void testSetTaskNameIsExactly20Characters() {
		Task task = new Task("204", "task 204    task 204", "this is task 204");
		assertTrue(task.getTaskName().length()==20);
	}
	
	@Test
	void testSetTaskNameSets() {
		Task task = new Task("111", "First Task", "This is the first task");
		task.setTaskName("New Task");
		assertEquals(task.getTaskName(), "New Task");
	}
	
// ----------------------- tests for the setter method for the task's description -------------------------------
	
	@Test
	void testSetTaskDescriptionIsNull() {
		Task task = new Task("111", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskDescription(null);
		});
	}
	
	@Test
	void testSetTaskDescriptionIsNotNull() {
		Task task = new Task("205", "task 205", "this is task 205");
		assertNotNull(task.getTaskDescription());
	}
		
	@Test
	void testSetTaskDescriptionIsTooLong() {
		Task task = new Task("111", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskDescription("First TaskFirst TaskFirst TaskFirst TaskFirst TaskFirst Task");
		});
	}
	
	@Test
	void testSetTaskDescriptionIsLessThan50Characters() {
		Task task = new Task("206", "task 206", "this is task 206");
		assertTrue(task.getTaskDescription().length()<50);
	}
	
	@Test
	void testSetTaskDescriptionIsExactly50Characters() {
		Task task = new Task("207", "task 207", "this is 207this is 207this is 207this is 207this i");
		assertTrue(task.getTaskDescription().length()==50);
	}
		
	@Test
	void testSetTaskDescriptionSets() {
		Task task = new Task("111", "First Task", "This is the first task");
		task.setTaskDescription("New Task Description");
		assertEquals(task.getTaskDescription(), "New Task Description");
	}
// ---------------------------------- tests for the toString method ----------------------------------------------
	
	@Test
	void testToStringMethod() {
		Task task = new Task("111", "First Task", "This is the first task");
		assertEquals(task.toString(), "Task [Id=" + "111" + ", Task Name=" + "First Task" + ", Task Description=" + "This is the first task" + "]");
	}
}
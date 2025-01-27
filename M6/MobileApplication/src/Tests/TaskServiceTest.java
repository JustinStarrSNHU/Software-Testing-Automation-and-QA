package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Task;
import Application.TaskService;

class TaskServiceTest {
	
	// The following tests provide 100% coverage for the TaskService class
	
	TaskService taskService = new TaskService();

// -------------------------------------------- tests for addTask -----------------------------------------------
	
	@Test
	void testAddTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(null, "First Task", "This is the first task");
		});
	}
	
	@Test
	void testAddTaskIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("12345678901", "First Task", "This is the first task");
		});
	}
	
	@Test
	void testAddTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("111", null, "This is the first task");
		});
	}
	
	@Test
	void testAddTaskNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("111", "First TaskFirst TaskFirst Task", "This is the first task");
		});
	}
	
	@Test
	void testAddTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("111", "First Task", null);
		});
	}
	
	@Test
	void testAddTaskDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("111", "First Task", "First TaskFirst TaskFirst TaskFirst TaskFirst TaskFirst Task");
		});
	}
	
	@Test
	void testAddTaskWithSameIdDoesNotAddTask() {
		taskService.addTask("300", "300 Task", "This is the 300th task"); //adds a new task
		try {
			taskService.addTask("300", "300 Task", "This is the 300th task"); // tries to add a new task with a taskId that has already been used
			fail("Exception Not Thrown"); // if the id is not found, the test fails
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Task ID Already In Use"); //exception is thrown if the taskId is found
		}
	}
	
	@Test 
	void testAddTaskWithSameIdSecondTest() {
		taskService.addTask("200", "task 200", "this is task 200");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("200", "T",  "T 201 201");
		});
	}
	
	@Test
	void testAddValidTask() {
		Task testTask = taskService.addTask("301", "301 Task", "This is the 301st task");
		assertEquals("301", testTask.getTaskId());
		assertEquals("301 Task", testTask.getTaskName());
		assertEquals("This is the 301st task", testTask.getTaskDescription());
		
	}
	
// ----------------------------------------- tests for deleteTask --------------------------------------------
	
	@Test
	void testDeleteTaskIdIsNull() {
		taskService.addTask("123", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask(null);
		});
	}
	
	@Test
	void testDeleteTaskIdIsTooLong() {
		taskService.addTask("1233", "First Task", "This is the first task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("12345678901");
		});
	}
	
	@Test
	void testDeleteTaskDeletesTask() {
		taskService.addTask("222", "Second Task", "This is the second task");
		taskService.deleteTask("222");
		assertNull(taskService.deleteTask("222"));
	}
	
// The following test expects a null result because a null value is returned when either a task is deleted or when a task is not found.
// The following test proves that when the task Id was not found a null value is returned and no task was deleted.
// If the test ran as assertNotNull, it would fail.
	
	@Test
	void testDeleteTaskDidNotDelete() {
		taskService.addTask("223", "Second Task", "This is the second task");
		taskService.deleteTask("223");
		assertNull(taskService.deleteTask("224"));
	}
	
// ----------------------------------------- tests for updateTaskName --------------------------------------------
	
	@Test
	void testUpdateTaskNameIdIsNull() {
		taskService.addTask("333", "Third Task", "This is the third task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName(null, "new task name");
		});
	}
	
	@Test
	void testUpdateTaskNameIdIsTooLong() {
		taskService.addTask("334", "Third Task", "This is the third task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("12345678901", "new task name");
		});
	}
	
	@Test
	void testUpdateTaskNameNewNameIsNull() {
		taskService.addTask("335", "Third Task", "This is the third task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("335", null);
		});
	}
	
	@Test
	void testUpdateTaskNameNewNameIsTooLong() {
		taskService.addTask("336", "Third Task", "This is the third task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("336", "new task name is way too long");
		});
	}
	
	@Test
	void testUpdateTaskNameDidNotUpdate() {
		taskService.addTask("337", "Third Task", "This is the third task");
		assertNull(taskService.updateTaskName("338", "New task name"));
	}
	
	@Test
	void testUpdateTaskNameDidUpdate() {
		taskService.addTask("339", "Third Task", "This is the third task");
		assertNotNull(taskService.updateTaskName("339", "New task name"));
	}
	
// -------------------------------------- tests for updateTaskDescription -----------------------------------------
	
	@Test
	void testUpdateTaskDescriptionIdIsNull() {
		taskService.addTask("444", "Fourth Task", "This is the fourth task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription(null, "new task name");
		});
	}
	
	@Test
	void testUpdateTaskDescriptionIdIsTooLong() {
		taskService.addTask("445", "Fourth Task", "This is the fourth task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("12345678901", "new task name");
		});
	}
	
	@Test
	void testUpdateTaskDescriptionNewDescriptionIsNull() {
		taskService.addTask("446", "Fourth Task", "This is the fourth task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("446", null);
		});
	}
	
	@Test
	void testUpdateTaskDescriptionNewDescriptionIsTooLong() {
		taskService.addTask("447", "Fourth Task", "This is the fourth task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("447", "new task description is way too long because we need it to be extremely long for this test");
		});
	}
	
	@Test
	void testUpdateTaskDescriptionDidNotUpdate() {
		taskService.addTask("448", "Fourth Task", "This is the fourth task");
		assertNull(taskService.updateTaskDescription("441", "New task name"));
	}
	
	@Test
	void testUpdateTaskDescriptionDidUpdate() {
		taskService.addTask("449", "Fourth Task", "This is the fourth task");
		assertNotNull(taskService.updateTaskDescription("449", "New task name"));
	}
	
}
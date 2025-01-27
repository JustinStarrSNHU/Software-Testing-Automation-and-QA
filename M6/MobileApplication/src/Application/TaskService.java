package Application;

import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;

// TaskService class

public class TaskService {
	
	// Array List for Tasks
	private static List<Task> tasks = new ArrayList<Task>();
	
	// addTask method. Checks if the task already exists in the task list by taskId. If the taskId does not already exist a new task is created with that Id.
	public Task addTask(String taskId, String taskName, String taskDescription) {
		
		Task task = null;
		
		// used to iterate over the tasks list and make comparisons.
		ListIterator<Task> litr = tasks.listIterator();
		
		while(litr.hasNext() ) {
			task = litr.next();
			if(taskId != null && taskId.equals(task.getTaskId())) {
				throw new IllegalArgumentException("Task ID Already In Use"); // exception is thrown if the taskId already exists.
			}
		}
		// if the taskId does not exist a new task is created and added to the list of tasks.
		task = new Task(taskId, taskName, taskDescription);
		tasks.add(task);
		return task; // returns type task.
	}
	
	// deleteTask method. Deleted a task if the passed in taskId is found in the list of tasks.
	public Task deleteTask(String taskId) {
		
		Task task = null;
		
		Task tempTask = null;
		
		// used to iterate over the list of tasks and make comparisons.
		ListIterator<Task> litr = tasks.listIterator();
		
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid Task ID"); // exception is thrown if the passed in taskId is null or greater than 10 characters in length.
		}
		
		// checks if the taskId exists. If the taskId is found, the task is removed from the list of tasks.
		while (litr.hasNext()) {
			tempTask = litr.next();
			if(taskId.equals(tempTask.getTaskId())) {
				task = tempTask;
				tasks.remove(task);
				return task; // returns type task when the task is removed.
			}
		}
		return task; // returns type task when the task is not removed from the list.
	}
	
	// updateTaskName method. Updates the tasks name if the passed in taskId is found in the list of tasks.
	public Task updateTaskName(String taskId, String taskName) {
		
		Task task = null;
		
		Task tempTask = null;
		
		// used to iterate over the list of tasks and make comparisons.
		ListIterator<Task> litr = tasks.listIterator();
		
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid Task ID"); // exception is thrown if the passed in taskId is null or the length of the passed in taskId is greater than 10 characters.
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name"); // exception is thrown if the passed in taskName is null or the length of the passed in taskName is greater than 20 characters.
		}
		
		// checks if the passed in taskId exists. If the taskId is found, the taskName is updated to the passed in taskName.
		while(litr.hasNext()) {
			tempTask = litr.next();
			if(taskId.equals(tempTask.getTaskId())) {
				task = tempTask;
				task.setTaskName(taskName);
				return task; // returns type task when the taskName is updated.
			}
		}
		return task; // returns type task when the taskName is not updated.
	}
	
	// update taskDescription method. Updated the tasks description if the passed in taskId is found in the list of tasks.
	public Task updateTaskDescription(String taskId, String taskDescription) {
		
		Task task = null;
		
		Task tempTask;
		
		// used to iterate over the list of tasks and make comparisons.
		ListIterator<Task> litr = tasks.listIterator();
		
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid Task ID"); // exception is thrown if the passed in taskId is null or the length of the passed in taskId is greater than 10 characters.
		}
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description"); // exception is thrown if the passed in taskDescription is null or the length of the passed in taskDescription is greater than 50 characters.
		}
		
		// checks if the passed in taskId exists. If  found, the tasks description is updated to the passed in taskDescription.
		while(litr.hasNext()) {
			tempTask = litr.next();
			if(taskId.equals(tempTask.getTaskId())) {
				task = tempTask;
				task.setTaskDescription(taskDescription);
				return task; // returns type task when the taskDescription is updated.
			}
		}
		return task; // returns type task when the taskDescription is not updated.
	}
}
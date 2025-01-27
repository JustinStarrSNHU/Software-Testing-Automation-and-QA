package Application;

// Task class

public class Task {
	private String taskId;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskId, String taskName, String taskDescription) {
		
		// the following IllegalArgumentExceptions are thrown when a task object is created that does not meet specifications.
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid Task Id"); // the taskId cannot be null or greater than 10 characters in length.
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");  // the taskName cannot be null and it cannot be greater than 20 characters in length.
		}
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description"); // the taskDescription cannot be null and it cannot be greater than 50 characters in length.
		}
		
		
		//if no exceptions are thrown the object's attributes are set.
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	// getter method for the task's Id. There is no setter method because the Id shall not be updatable.
	public String getTaskId() {
		return taskId;
	}
	
	// getter method for the task's name.
	public String getTaskName() {
		return taskName;
	}
	
	// setter method for the task's name because it is updateable.
	public void setTaskName(String taskName) {
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name"); // exception is thrown if the taskName being updated is null or greater than 20 characters in length.
		}
		this.taskName = taskName; // if no exception is thrown, the task's name is updated.
	}
	
	// getter method for the task's description
	public String getTaskDescription() {
		return taskDescription;
	}
	
	// setter method for the task's description because it is updateable.
	public void setTaskDescription(String taskDescription) {
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description"); // exception is thrown if the task description is null or greater than 50 characters in length.
		}
		this.taskDescription = taskDescription; // if no exception is thrown the task's description is updated.
	}
	
	// toString method creates a readable string with the task's set attributes
	public String toString() {
		return ("Task [Id=" + taskId + ", Task Name=" + taskName + ", Task Description=" + taskDescription + "]");
	}
}

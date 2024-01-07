package com.task.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task   //  THIS IS MODEL CLASS OR ENTITY CLASS OF OUR PROJECT 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// unique 
	
	private Long taskId;
	
	private String Title;
	
	private String Description;
	
	private LocalDate dueDate;
	
	private boolean Completed;

	
	
	
	
	
	public Task(Long taskId, String title, String description, LocalDate dueDate, boolean completed) 
	{
		
		super();
		this.taskId = taskId;
		Title = title;
		Description = description;
		this.dueDate = dueDate;
		Completed = completed;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return Completed;
	}

	public void setCompleted(boolean completed) {
		Completed = completed;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", Title=" + Title + ", Description=" + Description + ", dueDate=" + dueDate
				+ ", Completed=" + Completed + "]";
	}
	
	
	
}

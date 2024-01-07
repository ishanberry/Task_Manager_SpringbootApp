package com.task.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.task.model.Task;
import com.task.respository.TaskRepository;

@Service
public class TaskService 
{
   //  this service class which will have actual bussiness logic or project logic 
	
	
	@Autowired
	TaskRepository taskRepository;// this contains the object of task repository 
	
	
	public List<Task> getAllTasks()
	{ 
		return taskRepository.findAll();  //  return all task =READ
	}
	
	
																													//	public Optional<Task> getTaskById(Long id) {
																														//	    return taskRepository.findById(id);          for similar logic above but optional is used 
																														//	}  
	public Task getTaskById(@PathVariable Long taskId) // return the task it will find by id if present if not       
	{
		return taskRepository.findById(taskId).orElse(null);
		                                                          //READ 
	}
	
	// CREATE  or save tha task 
	public Task saveTask (Task task)
	{
		return taskRepository.save(task);
		
	}
	
	

	
	
	public void deleteTask(Long taskId) 
		{
		
		   taskRepository.deleteById(taskId);
		
		}
	
	
}
/*
 * commented code 
 * 
 */
//public Task updateTask( Long taskId, Task Completed)
//{	Optional<Task> existingTaskOptional = taskRepository.findById(taskId);
//	
//	if (existingTaskOptional.isPresent())
//	{
//		Task existingTask = existingTaskOptional.get();
//        existingTask.setTitle(Completed.getTitle());
//        existingTask.setDescription(Completed.getDescription());
//        existingTask.setDueDate(Completed.getDueDate());
//        existingTask.setCompleted(Completed.isCompleted());
//        
//        return taskRepository.save(existingTask);
//        
//        
//        
//	}
//	else{
//		return null; //throw an exception or handle this case as appropriate ? ? 
//		
//	}
//	
//}	



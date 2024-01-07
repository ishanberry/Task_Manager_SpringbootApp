	package com.task.controller;
	
	import java.util.Date;
	
	import java.util.List;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.ModelAndView;
	
	import com.task.model.Task;
	import com.task.services.TaskService;
	
	//@RestController // this is use when we have to build resful api 
	@Controller    //  this is used when we have build backend with some template engine 
	// @RequestMapping("/tasks")
	public class TaskController 
	{
		@Autowired
	
		private TaskService taskService;
	
	
		
		@GetMapping(value = "/tasks")
		public String getAllTasks( Model model)
		{              	System.out.println("/working ");
				
				//model.addAttribute("tasks1", tasks);
				model.addAttribute("tasks" ,taskService.getAllTasks());
//					 model.addAttribute("newTask", new Task());
					return "index";	
			}
		
	
		
		@GetMapping(value = "/tasks/{taskId}") // eg /tasks/123-- task assigned to 123 will be present from db 
		public String getTaskById(@PathVariable Long taskId,Model model )
		{
			 System.out.println("get task by id working ");
			model.addAttribute("task",taskService.getTaskById(taskId));
			return "view";	
					
		}
		
		// Display the form for adding a task
	    @GetMapping("/tasks/add")
	    public String showAddTaskForm(Model model) {
	        model.addAttribute("task", new Task());
	        return "addTask";
	    }
		
		@PostMapping(value = "/tasks/save")
		public String createTask( @ModelAttribute Task task,Model model)
		{		
			//taskService.saveTask(task);
			System.out.println("add controller working ");
			// model.addAttribute("newTask", new Task());
			model.addAttribute("task",taskService.saveTask(task));
			return "redirect:/tasks";
			
		}
		//  display the form for updating the task 
		@GetMapping("/tasks/update/{taskId}")
	    public String showupdateform(@PathVariable Long taskId,Model model) {
			
			Task task = taskService.getTaskById(taskId);
			model.addAttribute("task", task != null ? task : new Task());
	        return "update";
	    }
		
		@PostMapping(value = "/tasks/update/{taskId}" )
		
		public String updateTask(@PathVariable Long taskId,@ModelAttribute Task task ,Model model)
		{	taskService.getTaskById(taskId);
			task.setTaskId(taskId);
			System.out.println("update controller working ");
			Task updatedTask =taskService.saveTask(task);
			model.addAttribute("taskId", taskId);
			
			if (updatedTask!=null) 
			{
				model.addAttribute("message","task updated successfully ! ");
				
			}
			else {
				model.addAttribute("error","Failed to update  The Task. ! ");
			}
			
			return "redirect:/tasks";
		}	
		@GetMapping(value = "/tasks/delete/{taskId}" )
		public String deleteTask(@PathVariable Long taskId ,Model model)
		{	          // /tasks/delete/id
			System.out.println("delete controller workig n");
			taskService.deleteTask(taskId);
			model.addAttribute("taskId",taskId);
			model.addAttribute("message ", "task deleted successfully !");
			// redirect to main page 
			
			return "redirect:/tasks" ; 
	 				 
		}
		
		
		
		
		
		}
	

//	
	
	
//
	
	
	/* commented code 
	 * 
	 *  THIS SPECIFICALY WORK FOR RESTFUL API TYPE 
	 * 	
	 * @RequestBody Task task 
	 * 
	 * 
	 * 
	 * 
	 * package com.task.controller;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.task.model.Task;
import com.task.services.TaskService;

//@RestController // this is use when we have to build resful api 
@Controller    //  this is used when we have build backend with some template engine 
@RequestMapping("/tasks")
public class TaskController 
{
	@Autowired
	
	private TaskService taskService;
	 
//
//	    @GetMapping(value = "/about")
//	    public String test() {
//	        System.out.println("isnside about handlwer ");
//	    	return "about"; // Assuming you have a "test.html" Thymeleaf template
//	    }
	

	
	
	@GetMapping()
	public List<Task> getAllTasks( Model model)
	{			List<Task> tasks =taskService.getAllTasks();
				model.addAttribute("tasks" ,taskService.getAllTasks());
				return "task";	
		}
	
	@GetMapping(value = "/{taskId}") // eg /tasks/123-- task assigned to 123 will be present from db 
	public Task getTaskById(@PathVariable Long taskId )
	{
		return taskService.getTaskById(taskId);
	}
	
	@PostMapping()
	public Task createTask(@RequestBody Task task)
	{
		return taskService.saveTask(task);
		
	}
	@PutMapping(value = "/{taskId}")
	public Task updateTask(@PathVariable Long taskId,@RequestBody Task task)
	{
		task.setTaskId(taskId);
		return taskService.saveTask(task);
		
	}
	@DeleteMapping(value = "/tasks/{id}" )
	public void deleteTask(@PathVariable Long taskId)
	{
		
		 taskService.deleteTask(taskId);
	}
	
	
	
	
	
	
	
}

	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	

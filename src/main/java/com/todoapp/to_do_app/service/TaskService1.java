package com.todoapp.to_do_app.service;

import com.todoapp.to_do_app.payloads.TaskDTO;
import com.todoapp.to_do_app.payloads.TaskResponse;



public interface TaskService1 {
    TaskDTO addNewTask(TaskDTO taskDTO);
    TaskResponse getAllTasks();
    TaskDTO deleteTask(Long task_id);
    TaskDTO taskCompleted(Long taskId);
    TaskDTO deleteTaskByName(String taskName);
}

package com.todoapp.to_do_app.service;

import com.todoapp.to_do_app.Exception.APIException;
import com.todoapp.to_do_app.Exception.NoTaskFoundException;
import com.todoapp.to_do_app.model.Task;
import com.todoapp.to_do_app.payloads.TaskDTO;
import com.todoapp.to_do_app.payloads.TaskResponse;
import com.todoapp.to_do_app.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService1{

   @Autowired
   private TaskRepository taskRepository;

   @Autowired
    private ModelMapper modelMapper;

    public TaskDTO addNewTask(TaskDTO taskDTO) {
        Task newTask = modelMapper.map(taskDTO , Task.class);
        Task addNewTask = taskRepository.save(newTask);
        return modelMapper.map(addNewTask, TaskDTO.class);
    }

    public TaskResponse getAllTasks() {

        List<Task> tasks = taskRepository.findAll();
        if(tasks.isEmpty()) {
            throw new APIException("No Task added till now");
        }
        List<TaskDTO> taskDTOS = tasks.stream().map(task ->
                modelMapper.map(task, TaskDTO.class)).toList();
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskDTOList(taskDTOS);
        return taskResponse;
    }

    public TaskDTO deleteTask(Long task_id) {
        Task deleteTask = taskRepository.findById(task_id)
                .orElseThrow(() ->
                        new NoTaskFoundException(task_id));
        TaskDTO deleteTaskDTO = modelMapper.map(deleteTask, TaskDTO.class);
        taskRepository.deleteById(task_id);
        return deleteTaskDTO;
    }

    public TaskDTO taskCompleted(Long taskId) {
        Task taskCompleted = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new NoTaskFoundException(taskId));
        if (taskCompleted.getStatus()) {
            taskCompleted.setStatus(false);
            taskRepository.save(taskCompleted);
            return modelMapper.map(taskCompleted, TaskDTO.class);
        }else{
            taskCompleted.setStatus(true);
        }
        taskRepository.save(taskCompleted);
        return modelMapper.map(taskCompleted, TaskDTO.class);
    }

    public TaskDTO deleteTaskByName(String taskName) {
        Task toBeDeleted = taskRepository.findBytaskName(taskName)
                .orElseThrow(() -> new NoTaskFoundException(taskName));
        TaskDTO deletedTaskDTO = modelMapper.map(toBeDeleted, TaskDTO.class);
        taskRepository.delete(toBeDeleted);
        return deletedTaskDTO;
    }


}

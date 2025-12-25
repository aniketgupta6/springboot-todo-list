package com.todoapp.to_do_app.Controller;

import com.todoapp.to_do_app.payloads.TaskDTO;
import com.todoapp.to_do_app.payloads.TaskResponse;
import com.todoapp.to_do_app.service.TaskService1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
     private final TaskService1 taskService1;

    @PostMapping("/add")
    public ResponseEntity<TaskDTO> addNewTask(@RequestBody TaskDTO task){
        TaskDTO newTask = taskService1.addNewTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
    @GetMapping("/tasks")
    public ResponseEntity<TaskResponse> getAllTasks() {
        TaskResponse taskResponse = taskService1.getAllTasks();
        return new ResponseEntity<>(taskResponse, HttpStatus.OK);
    }
    @DeleteMapping("/remove/byId/{task_id}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable Long task_id){
        TaskDTO deletedTask = taskService1.deleteTask(task_id);
        return new ResponseEntity<>(deletedTask,HttpStatus.OK);
    }

    @DeleteMapping("/remove/byName/{taskName}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable String taskName){
        TaskDTO deleted = taskService1.deleteTaskByName(taskName);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @PutMapping("/completed/{task_id}")
    public ResponseEntity<TaskDTO> taskCompleted(@PathVariable Long task_id){
        TaskDTO completedTask = taskService1.taskCompleted(task_id);
        return new ResponseEntity<>(completedTask, HttpStatus.OK);
    }

}

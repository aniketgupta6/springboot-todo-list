package com.todoapp.to_do_app.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TaskResponse {
    private List<TaskDTO> taskDTOList;

    public TaskResponse(){
    }
    public TaskResponse(List<TaskDTO> taskDTOList){
        this.taskDTOList=taskDTOList;
    }

}

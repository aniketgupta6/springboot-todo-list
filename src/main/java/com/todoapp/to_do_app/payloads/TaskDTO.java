package com.todoapp.to_do_app.payloads;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {
    private Long taskId;
    private String taskName;
    private Boolean status;

    public TaskDTO(){

    }
    public TaskDTO(Long taskId,String taskName,Boolean status){
        this.taskId=taskId;
        this.taskName=taskName;
        this.status=status;
    }

}

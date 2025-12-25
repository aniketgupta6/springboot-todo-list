package com.todoapp.to_do_app.Exception;

public class NoTaskFoundException extends RuntimeException{
   Long taskId;
   String taskName;

   public NoTaskFoundException(Long taskId){
       super("Task with Task Id: "+taskId+" is not founded");
   }
   public NoTaskFoundException(String taskName){
       super("Task with Task NAme:"+taskName+"is not founded");

   }
}

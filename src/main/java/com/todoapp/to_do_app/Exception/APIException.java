package com.todoapp.to_do_app.Exception;

public class APIException extends RuntimeException {
    public APIException(){}
    public APIException(String msg){
        super(msg);
    }
}

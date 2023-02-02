package com.example.springproject4.Exception;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}

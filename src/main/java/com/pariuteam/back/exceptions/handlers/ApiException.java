package com.pariuteam.back.exceptions.handlers;

public class ApiException extends RuntimeException{
    private int httpStatus;
    private String message;
    private String code;
}

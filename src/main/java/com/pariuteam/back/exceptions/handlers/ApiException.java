package com.pariuteam.back.exceptions.handlers;

public class ApiException extends Exception{
    private int httpStatus;
    private String message;
    private String code;
}

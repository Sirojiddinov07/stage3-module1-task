package com.mjc.school.repository.servise.exeptions;

public class ValidatorException extends Exception{
    public ValidatorException(String message){
        super("ERROR MASSAGE: " + message);
    }
}

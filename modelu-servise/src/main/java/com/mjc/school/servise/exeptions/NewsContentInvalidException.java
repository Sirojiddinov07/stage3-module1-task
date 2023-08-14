package com.mjc.school.servise.exeptions;

public class NewsContentInvalidException extends Exception{
    public NewsContentInvalidException(String message){
        super("ERROR MASSAGE: " + message);
    }
}

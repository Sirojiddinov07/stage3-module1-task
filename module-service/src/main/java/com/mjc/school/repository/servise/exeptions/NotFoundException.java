package com.mjc.school.repository.servise.exeptions;

public class NotFoundException extends Exception{
    public NotFoundException(String massage){
        super("ERROR MASSAGE: "+ massage);
    }
}

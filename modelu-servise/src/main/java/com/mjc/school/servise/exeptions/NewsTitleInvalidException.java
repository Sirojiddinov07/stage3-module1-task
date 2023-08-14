package com.mjc.school.servise.exeptions;

public class NewsTitleInvalidException extends Exception{
    public NewsTitleInvalidException(String massage){
        super("ERROR MASSAGE: "+ massage);
    }
}

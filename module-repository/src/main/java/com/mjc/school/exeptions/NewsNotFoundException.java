package com.mjc.school.exeptions;

public class NewsNotFoundException extends Exception{
    public NewsNotFoundException(String errorMassage){
        super("ERROR MASSAGE: "+ errorMassage);
    }
}

package com.mjc.school.exeptions;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException (String errorMassage){
        super("ERROR MASSAGE: "+ errorMassage);
    }
}

package com.mjc.school.exeptions;

public class IdMustBeNmberExeption extends Exception {
    public IdMustBeNmberExeption(String ms, Throwable throwable){
        super("ERROR MESSAGE: " + ms, throwable);
    }

}

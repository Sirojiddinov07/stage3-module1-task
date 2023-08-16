package com.mjc.school;

import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.model.NewsModel;

import java.util.List;

public  interface Repository<T> {

    List<T> readAll();


    T reaById(Long id) throws NewsNotFoundException;

    T create(T t) throws AuthorNotFoundException;


    boolean deleteById(Long id) throws NewsNotFoundException;

    NewsModel udate(NewsModel newsModel) throws  AuthorNotFoundException, NewsNotFoundException;

    int getNexId();


}

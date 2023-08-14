package com.mjc.school;

import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.model.NewsModel;

import java.util.List;

public  interface Repository<T> {
    public abstract List<T> readAll();

    public abstract T reaById(Long id) throws NewsNotFoundException;

    T create(T t) throws AuthorNotFoundException;

    T udate(NewsModel newsModel) throws  AuthorNotFoundException, NewsNotFoundException;

    boolean deleteById(Long id) throws NewsNotFoundException;

    int getNexId();
}

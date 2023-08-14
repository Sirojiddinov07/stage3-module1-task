package com.mjc.school.utils;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.model.NewsModel;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DataSource {

    @Getter
    private final List<NewsModel> newsModelList;



    @Getter
    private final List<AuthorModel> authorModelList;


    private final AtomicInteger idSequence = new AtomicInteger(0);

    public DataSource(){
        DataInitializer dataInitializer = new DataInitializer(idSequence);
        authorModelList = dataInitializer.initializeAuthorList();
        newsModelList = dataInitializer.initializeNewList(authorModelList);
    }

    public int getNextNewsId(){
        return idSequence.incrementAndGet();
    }
}

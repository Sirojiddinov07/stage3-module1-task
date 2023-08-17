package com.mjc.school.repository.impl;

import com.mjc.school.repository.servise.DTO.NewsDtoReq;
import com.mjc.school.repository.servise.DTO.NewsDtoRes;
import com.mjc.school.repository.servise.exeptions.ValidatorException;
import com.mjc.school.repository.servise.ipml.NewsService;

import java.util.List;

public class NewsController {

    private final NewsService newsService;

    public NewsController() {
        newsService = NewsService.getInstance();
    }

    public List<NewsDtoRes> getAll() {
        return newsService.readAll();
    }

    public NewsDtoRes getById(long id) throws ValidatorException {
        return newsService.readById(id);
    }

    public NewsDtoRes create(NewsDtoReq dtoRequest) throws ValidatorException {
        return newsService.create(dtoRequest);
    }

    public NewsDtoRes update(NewsDtoReq dtoRequest) throws ValidatorException {
        return newsService.update(dtoRequest);
    }

    public boolean delete(long id) throws Exception {
        return newsService.delete(id);
    }

}
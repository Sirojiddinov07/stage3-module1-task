package com.mjc.school;


import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;

import java.util.List;

public interface Controller <T> {

    List<T> readAllNews();

    T readById(Long id) throws NewsNotFoundException;

    T createNews(NewsCreateDtoReq news) throws NewsTitleInvalidException, NewsContentInvalidException, AuthorNotFoundException;

    T updateNews(NewsUpdateDtoReq news ) throws AuthorNotFoundException, NewsNotFoundException, NewsTitleInvalidException, NewsContentInvalidException;



    Boolean deleteNews(Long id) throws NewsNotFoundException;

}
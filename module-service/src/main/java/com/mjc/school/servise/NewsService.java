package com.mjc.school.servise;

import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;

import java.util.List;

public interface NewsService<T> {
    List<T> readAll();

    T readById(Long id) throws NewsNotFoundException;

    T create(NewsCreateDtoReq news) throws NewsTitleInvalidException, NewsContentInvalidException, AuthorNotFoundException;

    T update(NewsUpdateDtoReq news) throws NewsNotFoundException, AuthorNotFoundException, NewsTitleInvalidException, NewsContentInvalidException;

    Boolean delete(Long id) throws NewsNotFoundException;
}

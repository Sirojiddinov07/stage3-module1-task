package com.mjc.school.impl;

import com.mjc.school.Controller;
import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.DTO.NewsDto;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.NewsService;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;

import java.util.List;

public class NewsController  implements Controller<NewsDto> {

    private final NewsService newsService = new NewsService() {
        @Override
        public List readAll() {
            return null;
        }

        @Override
        public Object readById(Long id) throws NewsNotFoundException {
            return null;
        }

        @Override
        public Object create(NewsCreateDtoReq news) throws NewsTitleInvalidException, NewsContentInvalidException, AuthorNotFoundException {
            return null;
        }

        @Override
        public Object update(NewsUpdateDtoReq news) throws NewsNotFoundException, AuthorNotFoundException, NewsTitleInvalidException, NewsContentInvalidException {
            return null;
        }

        @Override
        public Boolean delete(Long id) throws NewsNotFoundException {
            return null;
        }
    };

    @Override
    public List<NewsDto> readAllNews() {
        return newsService.readAll();
    }

    @Override
    public NewsDto readById(Long id) throws NewsNotFoundException {
        return (NewsDto) newsService.readById(id);
    }

    @Override
    public NewsDto createNews(NewsCreateDtoReq news) throws
            NewsTitleInvalidException, NewsContentInvalidException, AuthorNotFoundException {
        return (NewsDto) newsService.create(news);
    }

    @Override
    public NewsDto updateNews(NewsUpdateDtoReq news) throws
            AuthorNotFoundException,
            NewsNotFoundException,
            NewsTitleInvalidException,
            NewsContentInvalidException {
        return (NewsDto) newsService.update(news);
    }

    @Override
    public Boolean deleteNews(Long id) throws NewsNotFoundException {
        return newsService.delete(id);
    }
}
package com.mjc.school.repository.servise.ipml;


import com.mjc.school.repository.implement.RepositoryImpl;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.servise.DTO.NewsDtoReq;
import com.mjc.school.repository.servise.DTO.NewsDtoRes;
import com.mjc.school.repository.servise.exeptions.ValidatorException;
import com.mjc.school.repository.servise.mapper.NewsMapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.mjc.school.repository.servise.exeptions.ExceptionConstants.NEWS_ID_DOES_NOT_EXIST;


public class NewsService {
    private final RepositoryImpl newsRepository;

    private static NewsService instance;

    private final Validator newsValidator;

    public NewsService() {
        newsValidator = getInstance().newsValidator;
        newsRepository = RepositoryImpl.getInstance();
    }

    public static NewsService getInstance() {
        if (instance == null) {
            instance = new NewsService();
        }
        return instance;
    }

    public List<NewsDtoRes> readAll() {
        return NewsMapper.INSTANCE.newsListToDtoList(newsRepository.readAll());
    }

    public NewsDtoRes readById(Long id) throws ValidatorException {
        Validator.validateNewsId(id);
        validateNewsExistence(id);
        return NewsMapper.INSTANCE.newsToDto(newsRepository.readById(id));
    }

    public NewsDtoRes create(NewsDtoReq news) throws ValidatorException {
        Validator.validateDtoRequest(news);
        NewsModel model = NewsMapper.INSTANCE.dtoToNews(news);
        model.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return NewsMapper.INSTANCE.newsToDto(newsRepository.create(model));
    }

    public NewsDtoRes update(NewsDtoReq news) throws ValidatorException {
        Validator.validateDtoRequest(news);
        NewsModel model = NewsMapper.INSTANCE.dtoToNews(news);
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return NewsMapper.INSTANCE.newsToDto(newsRepository.update(model));
    }

    public Boolean delete(Long id) throws ValidatorException {
        validateNewsExistence(id);
        return newsRepository.delete(id);
    }

    private void validateNewsExistence(long id) throws ValidatorException {
        if (!newsRepository.ifIdExist(id)) {
            throw new ValidatorException(String.format(NEWS_ID_DOES_NOT_EXIST.getCodeMsg(), id));
        }
    }
}
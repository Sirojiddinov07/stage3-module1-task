package com.mjc.school.servise.ipml;

import com.mjc.school.Repository;
import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.implement.RepoImpl;
import com.mjc.school.model.NewsModel;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.DTO.NewsDto;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;
import com.mjc.school.servise.mapper.NewsModelDTOMapper;
import com.mjc.school.servise.validators.NewsRequestValidator;
import com.mjc.school.servise.NewsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService<NewsDto> {

    private final NewsRequestValidator newsValidator = new NewsRequestValidator();

    private final Repository<NewsModel> newsRepository = new RepoImpl();

    private final NewsModelDTOMapper mapper = new NewsModelDTOMapper();

    @Override
    public List<NewsDto> readAll() {
        List<NewsDto> newsDtoList = new ArrayList<>();
        for (NewsModel newsModel : newsRepository.readAll()) {
            newsDtoList.add(mapper.mapModelToDto(newsModel));
        }
        return newsDtoList;
    }

    @Override
    public NewsDto readById(Long id) throws NewsNotFoundException {
        NewsModel newsModel = newsRepository.reaById(id);
        return mapper.mapModelToDto(newsModel);
    }

    @Override
    public NewsDto create(NewsCreateDtoReq news) throws
            NewsTitleInvalidException,
            NewsContentInvalidException, AuthorNotFoundException {

        newsValidator.validateNewsCreateDTORequest(news);

        NewsDto newNews =
                new NewsDto(
                        (long) newsRepository.getNexId(),
                        news.getTitle(),
                        news.getContent(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        news.getAuthorId());
        return mapper.mapModelToDto(newsRepository.create(
                mapper.mapDtoToModel(newNews)
        ));
    }

    @Override
    public NewsDto update(NewsUpdateDtoReq news) throws
            NewsNotFoundException,
            AuthorNotFoundException,
            NewsTitleInvalidException,
            NewsContentInvalidException {

        newsValidator.validateNewsUpdateDTORequest(news);

        return mapper.mapModelToDto(
                newsRepository.udate(
                        mapper.mapRequestDtoToModel(news)
                ));
    }

    @Override
    public Boolean delete(Long id) throws NewsNotFoundException {
        return newsRepository.deleteById(id);
    }
}

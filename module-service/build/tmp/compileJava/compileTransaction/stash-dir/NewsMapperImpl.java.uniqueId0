package com.mjc.school.repository.servise.mapper;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.servise.DTO.NewsDtoReq;
import com.mjc.school.repository.servise.DTO.NewsDtoRes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T21:36:31+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public List<NewsDtoRes> newsListToDtoList(List<NewsModel> newsLIst) {
        if ( newsLIst == null ) {
            return null;
        }

        List<NewsDtoRes> list = new ArrayList<NewsDtoRes>( newsLIst.size() );
        for ( NewsModel newsModel : newsLIst ) {
            list.add( newsToDto( newsModel ) );
        }

        return list;
    }

    @Override
    public NewsDtoRes newsToDto(NewsModel news) {
        if ( news == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        Long authorId = null;

        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        createDate = news.getCreateDate();
        lastUpdateDate = news.getLastUpdateDate();
        authorId = news.getAuthorId();

        NewsDtoRes newsDtoRes = new NewsDtoRes( id, title, content, createDate, lastUpdateDate, authorId );

        return newsDtoRes;
    }

    @Override
    public NewsModel dtoToNews(NewsDtoReq newsRequest) {
        if ( newsRequest == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( newsRequest.id() );
        newsModel.setTitle( newsRequest.title() );
        newsModel.setContent( newsRequest.content() );
        newsModel.setAuthorId( newsRequest.authorId() );

        return newsModel;
    }
}

package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T22:29:50+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsModel NewsModelFromDto(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        Long authorId = null;

        id = newsDto.getId();
        title = newsDto.getTitle();
        content = newsDto.getContent();
        createDate = newsDto.getCreateDate();
        lastUpdateDate = newsDto.getLastUpdateDate();
        authorId = newsDto.getAuthorId();

        NewsModel newsModel = new NewsModel( id, title, content, createDate, lastUpdateDate, authorId );

        return newsModel;
    }

    @Override
    public NewsDto NewsModelToDto(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto.NewsDtoBuilder newsDto = NewsDto.getBuilder();

        newsDto.setId( newsModel.getId() );
        newsDto.setTitle( newsModel.getTitle() );
        newsDto.setContent( newsModel.getContent() );
        newsDto.setCreateDate( newsModel.getCreateDate() );
        newsDto.setLastUpdateDate( newsModel.getLastUpdateDate() );
        newsDto.setAuthorId( newsModel.getAuthorId() );

        return newsDto.build();
    }
}

package com.mjc.school.repository.servise.mapper;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.servise.DTO.NewsDtoReq;
import com.mjc.school.repository.servise.DTO.NewsDtoRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    List<NewsDtoRes> newsListToDtoList(List<NewsModel> newsLIst);

    NewsDtoRes newsToDto(NewsModel news);

    @Mappings(value = {@Mapping(target = "createDate", ignore = true), @Mapping(target = "lastUpdateDate", ignore = true)})
    NewsModel dtoToNews(NewsDtoReq newsRequest);
}

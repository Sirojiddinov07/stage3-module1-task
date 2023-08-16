package com.mjc.school.servise.mapper;

import com.mjc.school.model.NewsModel;
import com.mjc.school.servise.DTO.NewsDto;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import org.modelmapper.ModelMapper;

public class NewsModelDTOMapper {
    private final ModelMapper mapper = new ModelMapper();

    public NewsDto mapModelToDto(NewsModel newsModel) {
        return mapper.map(newsModel, NewsDto.class);
    }

    public NewsModel mapDtoToModel(NewsDto news) {
        return mapper.map(news, NewsModel.class);
    }

    public NewsModel mapRequestDtoToModel(NewsUpdateDtoReq news) {
        return mapper.map(news, NewsModel.class);
    }

}

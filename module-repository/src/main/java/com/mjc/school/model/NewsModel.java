package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsModel {
    Long id;
    String title;
    String content;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
    AuthorModel author;


    public NewsModel(Long id){
        this.id = id;
    }



//    @Override
//    public boolean equals(Object o){
//        if (this == o)
//            return true;
//        if (o == null || getClass()!= o.getClass());
//        return false;
//        NewsModel newsModel = (NewsModel) o;
//        return id.equals(newsModel.id);
//}
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}

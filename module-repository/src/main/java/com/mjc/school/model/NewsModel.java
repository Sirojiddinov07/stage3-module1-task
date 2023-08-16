package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewsModel)) {
            return false;
        }
        NewsModel other = (NewsModel) obj;
        return Objects.equals(id, other.id);


        }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }
}

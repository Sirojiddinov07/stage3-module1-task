package com.mjc.school.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class NewsModel {
    Long id;
    String title;
    String content;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
    private Long authorId;


    public NewsModel(){
        this.id = id;
    }

    public NewsModel(long id, String title, String content, LocalDateTime now, LocalDateTime now1, AuthorModel authorModel) {
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

package com.mjc.school.model;

import java.time.LocalDateTime;
import java.util.Objects;


public class NewsModel {
    Long id;
    String title;
    String content;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
    AuthorModel author;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
}

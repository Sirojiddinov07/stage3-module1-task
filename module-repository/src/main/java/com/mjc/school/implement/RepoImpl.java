package com.mjc.school.implement;

import com.mjc.school.Repository;
import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.model.AuthorModel;
import com.mjc.school.model.NewsModel;
import com.mjc.school.utils.DataSource;

import java.util.List;

public class RepoImpl implements Repository<NewsModel> {

    private DataSource dataSource = new DataSource();



    @Override
    public NewsModel create (NewsModel newsModel) throws AuthorNotFoundException {
        checkAuthorId(newsModel.getAuthor().getId());
        dataSource.getNewsModelList().add(newsModel);
        return newsModel;
    }



    @Override
    public List<NewsModel> readAll(){
        return dataSource.getNewsModelList();

    }
    @Override
    public NewsModel reaById(Long id) throws NewsNotFoundException {
        int indexOfNews = checkNewsId(id);
        return dataSource.getNewsModelList().get(indexOfNews);
    }


    @Override
    public  NewsModel udate(NewsModel newsModel) throws  AuthorNotFoundException, NewsNotFoundException{
        int indexOfNews = checkNewsId(newsModel.getId());
        NewsModel newsModel1 = dataSource.getNewsModelList().get(indexOfNews);
        newsModel1.setTitle(newsModel.getTitle());
        newsModel1.setContent(newsModel.getContent());
        checkAuthorId(newsModel.getAuthor().getId());
        newsModel1.setAuthor(newsModel.getAuthor());
        newsModel1.setCreateDate(newsModel.getCreateDate());
        newsModel1.setLastUpdateDate(newsModel.getLastUpdateDate());
        return newsModel1;
    }



    @Override
    public int getNexId(){
        return dataSource.getNextNewsId();
    }




    @Override
    public boolean deleteById(Long id) throws NewsNotFoundException{
        checkNewsId(id);
        return dataSource.getNewsModelList().remove(new NewsModel());
    }

    private int  checkNewsId(Long id) throws NewsNotFoundException{
        List<NewsModel> newsModelList = dataSource.getNewsModelList();
        int indexOfNews = newsModelList.indexOf(new NewsModel());
        if (indexOfNews == -1){
            throw new NewsNotFoundException("News not exist with id " + id );
        }return  indexOfNews;
    }


    private int checkAuthorId(Long id) throws AuthorNotFoundException{
        List<AuthorModel> authorModelList = dataSource.getAuthorModelList();
        int indexOfNews = authorModelList.indexOf(new AuthorModel(id));
        if (indexOfNews == -1){
            throw new AuthorNotFoundException("Author not exist with id " + id );
        }
        return  indexOfNews;
    }
}


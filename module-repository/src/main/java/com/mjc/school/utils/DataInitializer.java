package com.mjc.school.utils;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.model.NewsModel;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DataInitializer {
    
    private  static  final  String Filename_Authors = "/author.txt";
    private  static  final  String Filename_Titles = "/news.txt";
    private  static  final  String Filename_News_Content = "/content.txt";
    
    private final AtomicInteger idSequence;
    
    public DataInitializer(AtomicInteger idSequence ){
        this.idSequence = idSequence;
    }
    
    @SneakyThrows
    public List<NewsModel>initializeNewList(List<AuthorModel> authorModelList){
        List<NewsModel> newsModelList = new ArrayList<>();
        
        List<String> titLines = readLinesFromFile(Filename_Titles);
        List<String> contentLines = readLinesFromFile(Filename_News_Content);

        for (String titLin : titLines){
            int id = idSequence.incrementAndGet();
            String title = titLin.substring(0,titLin.indexOf(','));
            String content = contentLines.get(id-1);
            int authorId = Integer.parseInt(titLin.substring(titLin.indexOf(",")+1).trim());
            newsModelList.add(new NewsModel(
                     (long) id, title, content, LocalDateTime.now(),LocalDateTime.now(),
                    authorModelList.get(authorId-1)));
        }
        return newsModelList;
    }


    @SneakyThrows
    public List<AuthorModel>initializeAuthorList(){
        List<AuthorModel> authorModelList = new ArrayList<>();
        long authorIdSequence = 0;
        List<String> lines = readLinesFromFile(Filename_Authors);

        for (String line :lines) {
            authorModelList.add(new AuthorModel(++authorIdSequence, line));
        }
        return authorModelList;
    }





    private List<String> readLinesFromFile(String filename)
            throws IOException {
        InputStream inputStream = DataInitializer.class.getResourceAsStream(filename);
        if (inputStream == null) {
            throw new RuntimeException(
                    String.format(filename));
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }
}



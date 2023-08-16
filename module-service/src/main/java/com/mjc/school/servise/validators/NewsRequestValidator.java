package com.mjc.school.servise.validators;

import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;

public class NewsRequestValidator {
    public void  validateNewsCreateDTORequest(NewsCreateDtoReq dtoReq)throws
            NewsContentInvalidException, NewsTitleInvalidException {
        checkTitle(dtoReq.getTitle());
        checkContent(dtoReq.getContent());
    }



    public void  validateNewsUpdateDTORequest(NewsUpdateDtoReq dtoReq)throws
            NewsContentInvalidException, NewsTitleInvalidException {

        checkTitle(dtoReq.getTitle());
        checkContent(dtoReq.getContent());
    }


    private void checkTitle (String title)throws NewsTitleInvalidException {
        if (title == null || title.length() < 5 || title.length() > 30) {
            throw new
                    NewsTitleInvalidException("Title cannot be null and less than 5 and more than 30  " +
                    "" + "Title is " + title);
        }
    }
    private void checkContent(String content)throws NewsContentInvalidException{
        if (content == null || content.length() < 5 || content.length()>255){throw new
                NewsContentInvalidException("Content cannot be null and less than 5 and more than 255  " +
                "" + "Content is " + content );

        }
}
}

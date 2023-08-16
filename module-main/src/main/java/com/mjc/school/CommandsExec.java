package com.mjc.school;

import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.IdMustBeNmberExeption;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.impl.NewsController;
import com.mjc.school.servise.DTO.NewsCreateDtoReq;
import com.mjc.school.servise.DTO.NewsDto;
import com.mjc.school.servise.DTO.NewsUpdateDtoReq;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;

public class CommandsExec {

    private final NewsController newsController = new NewsController();

    private final TerminalCommandsReader commandsReader = new TerminalCommandsReader();

    public void executeCommand(Commands command) throws
            IdMustBeNmberExeption, NewsNotFoundException,
            AuthorNotFoundException, NewsTitleInvalidException,
            NewsContentInvalidException {

        if (command == Commands.EXIT)
            System.exit(0);

        System.out.println(command.desc);
        switch (command) {
            case GET_ALL -> {
                for (NewsDto news : newsController.readAllNews()) {
                    System.out.println(news);
                }
            }
            case GET_BY_ID -> System.out.println(
                    newsController.readById(
                            requestNewsId()
                    ));
            case CREATE -> System.out.println(
                    newsController.createNews(
                            new NewsCreateDtoReq(
                                    requestNewsTitle(),
                                    requestNewsContent(),
                                    requestAuthorId()
                            )));
            case UPDATE -> System.out.println(
                    newsController.updateNews(
                            new NewsUpdateDtoReq(
                                    requestNewsId(),
                                    requestNewsTitle(),
                                    requestNewsContent(),
                                    requestAuthorId()
                            )));
            case REMOVE_BY_ID -> System.out.println(
                    newsController.deleteNews(
                            requestNewsId()
                    ));
        }
    }

    private long requestNewsId() throws IdMustBeNmberExeption {
        try {
            return Long.parseLong(commandsReader.requestResponseByPrompt("Enter news id:"));
        } catch (NumberFormatException e) {
            throw new IdMustBeNmberExeption("News Id must be number", e);
        }
    }

    private long requestAuthorId() throws IdMustBeNmberExeption {
        try {
            return Long.parseLong(commandsReader.requestResponseByPrompt("Enter author id:"));
        } catch (NumberFormatException e) {
            throw new IdMustBeNmberExeption("Author Id must be number", e);
        }
    }

    private String requestNewsContent() {
        return commandsReader.requestResponseByPrompt("Enter news content:");
    }

    private String requestNewsTitle() {
        return commandsReader.requestResponseByPrompt("Enter news title:");
    }
}


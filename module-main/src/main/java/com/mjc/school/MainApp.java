package com.mjc.school;

import com.mjc.school.exeptions.AuthorNotFoundException;
import com.mjc.school.exeptions.IdMustBeNmberExeption;
import com.mjc.school.exeptions.NewsNotFoundException;
import com.mjc.school.servise.exeptions.NewsContentInvalidException;
import com.mjc.school.servise.exeptions.NewsTitleInvalidException;

public class MainApp {

    private static final String Command_Not_Found ="Command Not Found";



    public static void main(String[] args) {
        TerminalCommandsReader terminalCommandsReader = new TerminalCommandsReader();
        CommandsExec commandsExecutor = new CommandsExec();
        while (true){
            terminalCommandsReader.getCommand().ifPresent(cmd ->{
                try {
                    commandsExecutor.executeCommand(cmd);
                }catch (NewsNotFoundException |
                        AuthorNotFoundException |
                        NewsTitleInvalidException |
                        NewsContentInvalidException |
                        IdMustBeNmberExeption e) {
                    System.out.println(e.getMessage());
                }
                    }
            );
        }
        }
    }


package com.mjc.school;

public class MainApp {

    private static final String Command_Not_Found ="Command Not Found";



    public static void main(String[] args) {
        TerminalCommandsReader terminalCommandsReader = new TerminalCommandsReader();
        CommandsExecutor commandsExecutor = new CommandsExecutor();

        while (true){
            terminalCommandsReader.getCommand().ifPresent(cmd ->{
                try {
                    commandsExec.g
                }
            });
        }
    }
}

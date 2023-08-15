package com.mjc.school;

import java.util.Optional;
import java.util.Scanner;

public class TerminalCommandsReader {

    private static final String PROMPT_ENTER_NUMBER_OF_OPERATION
            = "Enter the number of operation:";

    private final Scanner sc = new Scanner(System.in);

    public Optional<Commands> getCommand() {
        printCommandPrompt();
        if (sc.hasNextLine()) {
            try {
                int commandCode = Integer.parseInt(sc.nextLine());
                Commands command = getCommandByCode(commandCode);
                return Optional.ofNullable(command);
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    public String requestResponseByPrompt(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private Commands getCommandByCode(int commandCode) {
        for (Commands cmd : Commands.values()) {
            if (cmd.i == commandCode)
                return cmd;
        }
        return null;
    }

    private void printCommandPrompt() {
        StringBuilder sb = new StringBuilder();
        sb.append(PROMPT_ENTER_NUMBER_OF_OPERATION).append('\n');
        for (Commands cmd : Commands.values()) {
            sb
                    .append(cmd.i)
                    .append(" - ")
                    .append(cmd.desc)
                    .append('\n');
        }
        System.out.print(sb);
    }
}
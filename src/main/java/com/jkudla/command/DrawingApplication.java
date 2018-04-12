package com.jkudla.command;

import com.jkudla.command.command.CommandConstants;
import com.jkudla.command.command.CommandController;
import com.jkudla.command.exception.WrongCommandException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DrawingApplication {

    private static final String ENTER_COMMAND = "Enter command: ";


    public static void main(String[] args) {
        receiveCommands(System.in, System.out);
    }

    public static void receiveCommands(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);

        showInitialLine(out);
        while(scanner.hasNextLine()){
            String command = getTrimmedAndUpperCasedCommand(scanner);
            if(command.equals(CommandConstants.QUIT)){
                return;
            }
            try {
                CommandController.sendCommand(command);
            } catch (WrongCommandException e) {
                //TODO: display message
            }
            showInitialLine(out);
        }
    }

    private static void showInitialLine(PrintStream out) {
        out.println(ENTER_COMMAND);
    }

    private static String getTrimmedAndUpperCasedCommand(Scanner scanner) {
        return scanner.next().trim().toUpperCase();
    }
}

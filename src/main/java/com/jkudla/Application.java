package com.jkudla;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.jkudla.command.CommandConstants.QUIT;

public class Application {

    private static final String ENTER_COMMAND = "Enter command: ";


    public static void main(String[] args) {
        receiveCommands(System.in, System.out);
    }

    public static void receiveCommands(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        out.println(ENTER_COMMAND);
        while(scanner.hasNextLine()){
            String nextCommand = scanner.next().trim().toUpperCase();
            if(nextCommand.equals(QUIT)){
                return;
            }
            out.println(ENTER_COMMAND);
        }
    }
}

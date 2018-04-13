package com.jkudla.drawingTest;

import com.jkudla.drawingTest.command.CommandConstants;
import com.jkudla.drawingTest.command.CommandController;
import com.jkudla.drawingTest.exception.WrongCommandException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DrawingApplication {

    private static final String ENTER_COMMAND = "Enter drawingTest: ";


    public static void main(String[] args) {
        receiveCommands(System.in, System.out);
    }

    public static void receiveCommands(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);

        showInitialLine(out);
        while(scanner.hasNextLine()){
            String command = scanner.next();
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
}

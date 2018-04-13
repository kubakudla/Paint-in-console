package com.jkudla.drawingTest;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.command.CommandConstants;
import com.jkudla.drawingTest.command.CommandController;
import com.jkudla.drawingTest.exception.WrongCommandException;
import com.jkudla.drawingTest.exception.WrongParametersException;

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
        Board board = new Board();

        showInitialLine(out);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equals(CommandConstants.QUIT)) {
                return;
            }
            try {
                CommandController.sendCommand(board, command);
                board.print();
            } catch (WrongCommandException | WrongParametersException e) {
                System.out.println(e.getMessage() + "\n");
            }
            showInitialLine(out);
        }
    }

    private static void showInitialLine(PrintStream out) {
        out.println(ENTER_COMMAND);
    }
}

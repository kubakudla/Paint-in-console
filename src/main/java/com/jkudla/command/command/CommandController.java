package com.jkudla.command.command;

import com.jkudla.command.drawing.DrawingEnum;
import com.jkudla.command.exception.WrongCommandException;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jkudla.command.command.CommandConstants.COMMAND_LETTER_REGEX;
import static com.jkudla.command.command.CommandConstants.PARAMETERS_LETTER_REGEX;

public class CommandController {

    public static void sendCommand(String command) throws WrongCommandException {

        char commandLetter = findCommandLetter(command);
        String parameters = findParameters(command);
        Optional<DrawingEnum> foundDrawing = Arrays.stream(DrawingEnum.values()).filter(d -> d.getCommandLetter() == commandLetter).findFirst();
        if (foundDrawing.isPresent()) {
            DrawingEnum drawing = foundDrawing.get();
            drawing.validate(parameters);
            drawing.draw(parameters);
        } else {
            //TODO: description
            throw new WrongCommandException();
        }
    }

    public static char findCommandLetter(String command) throws WrongCommandException {
        Pattern pattern = Pattern.compile(COMMAND_LETTER_REGEX);
        Matcher matcher = pattern.matcher(command);

        if (matcher.matches()) {
            return matcher.group(1).charAt(0);
        }
        //TODO: description
        throw new WrongCommandException();
    }

    private static String findParameters(String command) {
        Pattern pattern = Pattern.compile(PARAMETERS_LETTER_REGEX);
        Matcher matcher = pattern.matcher(command);

        if (matcher.matches()) {
            //TODO:
        }
        return "";
    }
}

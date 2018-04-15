package com.jkudla.drawingTest.command;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.DrawingEnum;
import com.jkudla.drawingTest.exception.WrongCommandException;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandController {

    static final String MAX_OPERATION_LENGTH = "Maximum operation name length is: ";
    static final String WRONG_OPERATION = "Wrong operation name: ";
    static final String NO_OPERATION = "Couldn't find operation name: ";
    static final String ALLOWED_OPERATIONS = "Allowed operations: " + Arrays.stream(DrawingEnum.values()).map(DrawingEnum::getOperation).collect(Collectors.toList());

    public static Board sendCommand(Board board, String command) throws WrongCommandException, WrongParametersException {
        command = command.trim();
        String operation = findOperation(command);
        List<String> parameters = findParameters(command);
        Optional<DrawingEnum> foundDrawing = findDrawingByOperationName(operation);
        if (foundDrawing.isPresent()) {
            DrawingEnum drawing = foundDrawing.get();
            drawing.validate(parameters);
            drawing.draw(board, parameters);
        } else {
            throw new WrongCommandException(WRONG_OPERATION + operation + " " + ALLOWED_OPERATIONS);
        }
        return board;
    }

    static Optional<DrawingEnum> findDrawingByOperationName(String operation) {
        return Arrays.stream(DrawingEnum.values()).filter(d -> d.getOperation().equalsIgnoreCase(operation)).findFirst();
    }

    public static String findOperation(String command) throws WrongCommandException {
        // all commands are upper case, let's make it case insensitive
        command = command.toUpperCase();
        Pattern pattern = Pattern.compile(CommandConstants.COMMAND_LETTER_REGEX);
        Matcher matcher = pattern.matcher(command);

        String operation;
        if (matcher.find()) {
            operation = matcher.group(0);
            if (operation.length() > CommandConstants.MAX_OPERATION_NAME_LENGTH) {
                throw new WrongCommandException(MAX_OPERATION_LENGTH + CommandConstants.MAX_OPERATION_NAME_LENGTH);
            }
            return operation;
        }
        throw new WrongCommandException(NO_OPERATION + ALLOWED_OPERATIONS);
    }

    static List<String> findParameters(String command) {
        String[] parameterArray = command.split("\\s+");
        parameterArray = removeOperation(parameterArray);

        List<String> parameters = Arrays.asList(parameterArray);
        return parameters;
    }

    private static String[] removeOperation(String[] parameterArray) {
        return Arrays.copyOfRange(parameterArray, 1, parameterArray.length);
    }
}
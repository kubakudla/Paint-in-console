package com.jkudla.drawingTest.drawing;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.line.Line;
import com.jkudla.drawingTest.drawing.line.LineValidator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

public enum DrawingEnum {
    LINE("L", new Line(), new LineValidator());

    private String operation;

    private Drawing drawing;

    private Validator validator;

    DrawingEnum(String operation, Drawing drawing, Validator validator) {
        this.operation = operation;
        this.drawing = drawing;
        this.validator = validator;
    }

    public String getOperation() {
        return operation;
    }

    public void validate(List<String> parameters) throws WrongParametersException {
        validator.validate(parameters);
    }

    public void draw(Board board, List<String> parameters) {
        drawing.draw(board, parameters);
    }


}

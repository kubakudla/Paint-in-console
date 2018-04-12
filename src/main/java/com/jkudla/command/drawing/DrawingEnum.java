package com.jkudla.command.drawing;

import com.jkudla.command.drawing.line.Line;
import com.jkudla.command.drawing.line.LineValidator;

public enum DrawingEnum {
    LINE('L', new Line(), new LineValidator());

    private char commandLetter;

    private Drawing drawing;

    private Validator validator;

    DrawingEnum(char commandLetter, Drawing drawing, Validator validator) {
        this.commandLetter = commandLetter;
        this.drawing = drawing;
        this.validator = validator;
    }

    public char getCommandLetter() {
        return commandLetter;
    }

    public void validate(String parameters){
        validator.validate(parameters);
    }

    public void draw(String parameters){
        drawing.draw(parameters);
    }


}

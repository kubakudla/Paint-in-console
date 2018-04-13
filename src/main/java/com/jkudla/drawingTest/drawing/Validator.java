package com.jkudla.drawingTest.drawing;

import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

public interface Validator {

    void validate(List<String> parameters) throws WrongParametersException;
}

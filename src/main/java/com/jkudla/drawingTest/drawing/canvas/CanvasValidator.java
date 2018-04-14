package com.jkudla.drawingTest.drawing.canvas;

import com.jkudla.drawingTest.drawing.AbstractValidator;
import com.jkudla.drawingTest.drawing.Validator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

import static com.jkudla.drawingTest.drawing.canvas.Canvas.H;
import static com.jkudla.drawingTest.drawing.canvas.Canvas.W;
import static com.jkudla.drawingTest.util.ParameterUtil.isIntegerOfSize;

public class CanvasValidator extends AbstractValidator implements Validator {

    private static final int NB_OF_PARAMETERS = 2;

    static final int MIN_HEIGHT = 1;
    static final int MAX_HEIGHT = MAX_VAL_Y - 1;

    public static final String WRONG_PARAMETERS_W = "Wrong width parameter, accepted are values from: " + MIN_VAL_X + " to: " + MAX_VAL_X;

    public static final String WRONG_PARAMETERS_H = "Wrong height parameter, accepted are values from: " + MIN_HEIGHT + " to: " + MAX_HEIGHT;

    public CanvasValidator() {
        super(NB_OF_PARAMETERS);
    }

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        super.validate(parameters);
        if (!isXCorrect(parameters.get(W))) {
            throw new WrongParametersException(WRONG_PARAMETERS_W);
        } else if (!isIntegerOfSize(parameters.get(H), MIN_HEIGHT, MAX_HEIGHT)) {
            throw new WrongParametersException(WRONG_PARAMETERS_H);
        }
    }
}
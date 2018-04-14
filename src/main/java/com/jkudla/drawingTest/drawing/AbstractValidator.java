package com.jkudla.drawingTest.drawing;

import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static com.jkudla.drawingTest.board.Board.BOARD_MIN_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MIN_Y;
import static com.jkudla.drawingTest.util.ParameterUtil.isIntegerOfSize;

public abstract class AbstractValidator {

    public static final Integer MIN_VAL_X = BOARD_MIN_X;
    public static final Integer MAX_VAL_X = BOARD_MAX_X - 1;
    public static final Integer MIN_VAL_Y = BOARD_MIN_Y;
    public static final Integer MAX_VAL_Y = BOARD_MAX_Y - 1;

    private int nbOfParameters;

    public static final String WRONG_NB_OF_PARAMETERS = "Wrong number of parameters, required: ";
    public static final String WRONG_PARAMETERS_X = "Wrong x parameters, accepted are values from: " + MIN_VAL_X + " to: " + MAX_VAL_X;
    public static final String WRONG_PARAMETERS_Y = "Wrong y parameters, accepted are values from: " + MIN_VAL_Y + " to: " + MAX_VAL_Y;

    public AbstractValidator(int nbOfParameters) {
        this.nbOfParameters = nbOfParameters;
    }

    public void validate(List<String> parameters) throws WrongParametersException {
        if (parameters.size() != nbOfParameters) {
            throw new WrongParametersException(WRONG_NB_OF_PARAMETERS + nbOfParameters);
        }
    }

    protected boolean isXCorrect(String x) {
        return isIntegerOfSize(x, MIN_VAL_X, MAX_VAL_X);
    }

    protected boolean isYCorrect(String y) {
        return isIntegerOfSize(y, MIN_VAL_Y, MAX_VAL_Y);
    }
}

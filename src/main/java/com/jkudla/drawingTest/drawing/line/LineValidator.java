package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.drawing.Validator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static com.jkudla.drawingTest.board.Board.BOARD_MIN_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MIN_Y;
import static com.jkudla.drawingTest.drawing.line.Line.X1;
import static com.jkudla.drawingTest.drawing.line.Line.X2;
import static com.jkudla.drawingTest.drawing.line.Line.Y1;
import static com.jkudla.drawingTest.drawing.line.Line.Y2;
import static com.jkudla.drawingTest.util.ParameterUtil.isIntegerOfSize;

public class LineValidator implements Validator {

    private static final Integer MIN_VAL_X = BOARD_MIN_X;
    private static final Integer MAX_VAL_X = BOARD_MAX_X - 1;
    private static final Integer MIN_VAL_Y = BOARD_MIN_Y;
    private static final Integer MAX_VAL_Y = BOARD_MAX_Y - 1;
    private static final int NB_OF_PARAMETERS = 4;

    static final String WRONG_NB_OF_PARAMETERS = "Wrong number of parameters, required: ";
    static final String WRONG_PARAMETERS_X = "Wrong x parameters, accepted are values from: " + MIN_VAL_X + " to: " + MAX_VAL_X;
    static final String WRONG_PARAMETERS_Y = "Wrong y parameters, accepted are values from: " + MIN_VAL_Y + " to: " + MAX_VAL_Y;
    static final String WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY = "Wrong parameters, only vertical or horizontal line can be drawn";

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        if (parameters.size() != NB_OF_PARAMETERS) {
            throw new WrongParametersException(WRONG_NB_OF_PARAMETERS + NB_OF_PARAMETERS);
        } else if (areXParametersCorrect(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_X);
        } else if (areYParametersCorrect(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_Y);
        } else if (!isItHorizontalOrVerticalLine(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY);
        }
    }

    private boolean isItHorizontalOrVerticalLine(List<String> parameters) {
        return x1EqualsX2(parameters) || y1EqualsY2(parameters);
    }

    private boolean areXParametersCorrect(List<String> parameters) {
        IntPredicate xFilterCondition = n -> n % 2 == 0;
        return areParametersCorrect(parameters, MIN_VAL_X, MAX_VAL_X, xFilterCondition);
    }

    private boolean areYParametersCorrect(List<String> parameters) {
        IntPredicate yFilterCondition = n -> n % 2 == 1;
        return areParametersCorrect(parameters, MIN_VAL_Y, MAX_VAL_Y, yFilterCondition);
    }

    private boolean areParametersCorrect(List<String> parameters, Integer minVal, Integer maxVal, IntPredicate filterCondition) {
        List<String> xParameters = IntStream.range(0, parameters.size())
            .filter(filterCondition).mapToObj(parameters::get).collect(Collectors.toList());
        return xParameters.stream().filter(p -> !isIntegerOfSize(p, minVal, maxVal)).count() > 0;
    }

    private boolean x1EqualsX2(List<String> parameters) {
        int x1 = Integer.parseInt(parameters.get(X1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int y2 = Integer.parseInt(parameters.get(Y2));
        return x1 == x2 && y2 > y1;
    }

    private boolean y1EqualsY2(List<String> parameters) {
        int x1 = Integer.parseInt(parameters.get(X1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int y2 = Integer.parseInt(parameters.get(Y2));
        return y1 == y2 && x2 > x1;
    }

}
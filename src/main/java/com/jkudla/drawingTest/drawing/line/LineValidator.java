package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.drawing.AbstractValidator;
import com.jkudla.drawingTest.drawing.Validator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

import static com.jkudla.drawingTest.drawing.line.Line.X1;
import static com.jkudla.drawingTest.drawing.line.Line.X2;
import static com.jkudla.drawingTest.drawing.line.Line.Y1;
import static com.jkudla.drawingTest.drawing.line.Line.Y2;

public class LineValidator extends AbstractValidator implements Validator {

    private static final int NB_OF_PARAMETERS = 4;

    static final String WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY = "Wrong coordinates - can't form a horizontal/vertical line.";

    public LineValidator() {
        super(NB_OF_PARAMETERS);
    }

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        super.validate(parameters);
        if (!areX1X2ParametersCorrect(parameters.get(X1), parameters.get(X2))) {
            throw new WrongParametersException(WRONG_PARAMETERS_X);
        } else if (!areY1Y2ParametersCorrect(parameters.get(Y1), parameters.get(Y2))) {
            throw new WrongParametersException(WRONG_PARAMETERS_Y);
        } else if (!isItCorrectLine(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY);
        }
    }

    private boolean isItCorrectLine(List<String> parameters) {
        int x1 = Integer.parseInt(parameters.get(X1));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y2 = Integer.parseInt(parameters.get(Y2));
        return isItVerticalLine(x1, y1, x2, y2)
            || isItHorizontalLine(x1, y1, x2, y2)
            || isItAPoint(x1, y1, x2, y2);
    }

    private boolean isItVerticalLine(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y2 > y1;
    }

    private boolean isItHorizontalLine(int x1, int y1, int x2, int y2) {
        return y1 == y2 && x2 > x1;
    }

    private boolean isItAPoint(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }
}
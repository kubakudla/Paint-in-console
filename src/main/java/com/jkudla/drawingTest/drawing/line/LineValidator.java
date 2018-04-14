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

    static final String WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY = "Wrong parameters, only vertical or horizontal line can be drawn";

    public LineValidator() {
        super(NB_OF_PARAMETERS);
    }

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        super.validate(parameters);
        if (!areXParametersCorrect(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_X);
        } else if (!areYParametersCorrect(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_Y);
        } else if (!isItHorizontalOrVerticalLine(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY);
        }
    }

    private boolean isItHorizontalOrVerticalLine(List<String> parameters) {
        return x1EqualsX2(parameters) || y1EqualsY2(parameters);
    }

    private boolean areXParametersCorrect(List<String> parameters) {
        return isXCorrect(parameters.get(X1))
            && isXCorrect(parameters.get(X2));
    }

    private boolean areYParametersCorrect(List<String> parameters) {
        return isYCorrect(parameters.get(Y1))
            && isYCorrect(parameters.get(Y2));
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
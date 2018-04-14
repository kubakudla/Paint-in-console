package com.jkudla.drawingTest.drawing.rectangle;

import com.jkudla.drawingTest.drawing.AbstractValidator;
import com.jkudla.drawingTest.drawing.Validator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

import static com.jkudla.drawingTest.drawing.rectangle.Rectangle.X1;
import static com.jkudla.drawingTest.drawing.rectangle.Rectangle.X2;
import static com.jkudla.drawingTest.drawing.rectangle.Rectangle.Y1;
import static com.jkudla.drawingTest.drawing.rectangle.Rectangle.Y2;

public class RectangleValidator extends AbstractValidator implements Validator {

    private static final int NB_OF_PARAMETERS = 4;
    static final String WRONG_PARAMETERS_NOT_A_RECTANGLE = "Wrong parameters - can't form a rectangle";

    public RectangleValidator() {
        super(NB_OF_PARAMETERS);
    }

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        super.validate(parameters);
        if (!areX1X2ParametersCorrect(parameters.get(X1), parameters.get(X2))) {
            throw new WrongParametersException(WRONG_PARAMETERS_X);
        } else if (!areY1Y2ParametersCorrect(parameters.get(Y1), parameters.get(Y2))) {
            throw new WrongParametersException(WRONG_PARAMETERS_Y);
        } else if (!isItCorrectRectangle(parameters)) {
            throw new WrongParametersException(WRONG_PARAMETERS_NOT_A_RECTANGLE);
        }
    }

    private boolean isItCorrectRectangle(List<String> parameters) {
        int x1 = Integer.parseInt(parameters.get(X1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int y2 = Integer.parseInt(parameters.get(Y2));

        return x2 > x1 && y2 > y1;
    }
}

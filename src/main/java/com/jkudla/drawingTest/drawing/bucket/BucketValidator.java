package com.jkudla.drawingTest.drawing.bucket;

import com.jkudla.drawingTest.drawing.AbstractValidator;
import com.jkudla.drawingTest.drawing.Validator;
import com.jkudla.drawingTest.exception.WrongParametersException;

import java.util.List;

import static com.jkudla.drawingTest.drawing.bucket.Bucket.COLOUR;
import static com.jkudla.drawingTest.drawing.bucket.Bucket.X;
import static com.jkudla.drawingTest.drawing.bucket.Bucket.Y;

public class BucketValidator extends AbstractValidator implements Validator {

    private static final int NB_OF_PARAMETERS = 3;

    public static final String WRONG_COLOUR_LENGTH = "Wrong colour length, should be 1 character.";

    public BucketValidator() {
        super(NB_OF_PARAMETERS);
    }

    @Override
    public void validate(List<String> parameters) throws WrongParametersException {
        super.validate(parameters);
        if (!isXCorrect(parameters.get(X))) {
            throw new WrongParametersException(WRONG_PARAMETERS_X);
        } else if (!isYCorrect(parameters.get(Y))) {
            throw new WrongParametersException(WRONG_PARAMETERS_Y);
        } else if (!isColourCorrect(parameters.get(COLOUR))) {
            throw new WrongParametersException(WRONG_COLOUR_LENGTH);
        }
    }

    private boolean isColourCorrect(String colour) {
        return colour.length() == 1;
    }
}
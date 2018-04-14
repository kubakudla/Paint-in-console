package com.jkudla.drawingTest.drawing.canvas;

import com.jkudla.drawingTest.exception.WrongParametersException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static com.jkudla.drawingTest.drawing.AbstractValidator.MAX_VAL_X;
import static com.jkudla.drawingTest.drawing.AbstractValidator.MIN_VAL_X;
import static com.jkudla.drawingTest.drawing.AbstractValidator.WRONG_NB_OF_PARAMETERS;
import static com.jkudla.drawingTest.drawing.canvas.CanvasValidator.MAX_HEIGHT;
import static com.jkudla.drawingTest.drawing.canvas.CanvasValidator.MIN_HEIGHT;
import static com.jkudla.drawingTest.drawing.canvas.CanvasValidator.WRONG_PARAMETERS_H;
import static com.jkudla.drawingTest.drawing.canvas.CanvasValidator.WRONG_PARAMETERS_W;

public class CanvasValidatorTest {

    private CanvasValidator canvasValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        canvasValidator = new CanvasValidator();
    }

    @Test
    public void test_validateLineParameters_success() throws WrongParametersException {
        canvasValidator.validate(Arrays.asList("5", "3"));
    }

    @Test
    public void test_validateLineParameters_failNotEnoughParameteres() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        canvasValidator.validate(Arrays.asList("5"));
    }

    @Test
    public void test_validateLineParameters_failTooManyParameteres() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        canvasValidator.validate(Arrays.asList("5", "3", "3"));
    }

    @Test
    public void test_validateLineParameters_failWidthTooSmall() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_W);
        canvasValidator.validate(Arrays.asList(String.valueOf(MIN_VAL_X - 1), "2"));
    }

    @Test
    public void test_validateLineParameters_failWidthTooBig() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_W);
        canvasValidator.validate(Arrays.asList(String.valueOf(MAX_VAL_X + 1), "2"));
    }

    @Test
    public void test_validateLineParameters_failHeightTooSmall() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_H);
        canvasValidator.validate(Arrays.asList("8", String.valueOf(MIN_HEIGHT - 1)));
    }

    @Test
    public void test_validateLineParameters_failHeightTooBig() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_H);
        canvasValidator.validate(Arrays.asList("8", String.valueOf(MAX_HEIGHT + 1)));
    }
}
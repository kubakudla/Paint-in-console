package com.jkudla.drawingTest.drawing.rectangle;

import com.jkudla.drawingTest.exception.WrongParametersException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static com.jkudla.drawingTest.drawing.AbstractValidator.WRONG_NB_OF_PARAMETERS;
import static com.jkudla.drawingTest.drawing.AbstractValidator.WRONG_PARAMETERS_X;
import static com.jkudla.drawingTest.drawing.AbstractValidator.WRONG_PARAMETERS_Y;
import static com.jkudla.drawingTest.drawing.rectangle.RectangleValidator.WRONG_PARAMETERS_NOT_A_RECTANGLE;

public class RectangleValidatorTest {

    private RectangleValidator rectangleValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        rectangleValidator = new RectangleValidator();
    }

    @Test
    public void test_validateRectangleParameters_success() throws WrongParametersException {
        rectangleValidator.validate(Arrays.asList("1", "2", "5", "4"));
    }

    @Test
    public void test_validateRectangleParameters_failNotEnoughParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        rectangleValidator.validate(Arrays.asList("1", "2", "5"));
    }

    @Test
    public void test_validateRectangleParameters_failTooManyParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        rectangleValidator.validate(Arrays.asList("1", "2", "5", "4", "3"));
    }

    @Test
    public void test_validateRectangleParameters_failX1BiggerThanX2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_NOT_A_RECTANGLE);
        rectangleValidator.validate(Arrays.asList("7", "2", "5", "4"));
    }

    @Test
    public void test_validateRectangleParameters_failY1BiggerThanY2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_NOT_A_RECTANGLE);
        rectangleValidator.validate(Arrays.asList("1", "9", "5", "4"));
    }

    @Test
    public void test_validateRectangleParameters_failTooBigX1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        rectangleValidator.validate(Arrays.asList("" + BOARD_MAX_X, "2", "5", "4"));
    }

    @Test
    public void test_validateRectangleParameters_failTooBigY1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        rectangleValidator.validate(Arrays.asList("1", "" + BOARD_MAX_Y, "5", "2"));
    }

    @Test
    public void test_validateRectangleParameters_failTooBigX2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        rectangleValidator.validate(Arrays.asList("1", "2", "" + BOARD_MAX_X, "5"));
    }

    @Test
    public void test_validateRectangleParameters_failTooBigY2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        rectangleValidator.validate(Arrays.asList("8", "3", "5", "" + BOARD_MAX_Y));
    }

}

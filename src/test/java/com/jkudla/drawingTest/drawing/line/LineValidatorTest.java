package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.exception.WrongParametersException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static com.jkudla.drawingTest.drawing.line.LineValidator.WRONG_NB_OF_PARAMETERS;
import static com.jkudla.drawingTest.drawing.line.LineValidator.WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY;
import static com.jkudla.drawingTest.drawing.line.LineValidator.WRONG_PARAMETERS_X;
import static com.jkudla.drawingTest.drawing.line.LineValidator.WRONG_PARAMETERS_Y;

public class LineValidatorTest {

    private LineValidator lineValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        lineValidator = new LineValidator();
    }

    @Test
    public void test_validateLineParameters_successHorizontalLine() throws WrongParametersException {
        lineValidator.validate(Arrays.asList("1", "2", "5", "2"));
    }

    @Test
    public void test_validateLineParameters_successVerticalLine() throws WrongParametersException {
        lineValidator.validate(Arrays.asList("1", "2", "1", "6"));
    }

    @Test
    public void test_validateLineParameters_failNotEnoughParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        lineValidator.validate(Arrays.asList("8", "2", "5"));
    }

    @Test
    public void test_validateLineParameters_failTooManyParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        lineValidator.validate(Arrays.asList("8", "2", "5", "2", "3"));
    }

    @Test
    public void test_validateLineParameters_failHorizontalLineX1BiggerThanX2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY);
        lineValidator.validate(Arrays.asList("8", "2", "5", "2"));
    }

    @Test
    public void test_validateLineParameters_failVerticalLineY1BiggerThanY2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_HORIZONAL_OR_VERTICAL_ONLY);
        lineValidator.validate(Arrays.asList("1", "9", "1", "6"));
    }

    @Test
    public void test_validateLineParameters_failNegativeX1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        lineValidator.validate(Arrays.asList("-8", "2", "5", "2"));
    }

    @Test
    public void test_validateLineParameters_failNegativeY1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        lineValidator.validate(Arrays.asList("8", "-2", "5", "2"));
    }

    @Test
    public void test_validateLineParameters_failNegativeX2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        lineValidator.validate(Arrays.asList("8", "2", "-5", "2"));
    }

    @Test
    public void test_validateLineParameters_failTooBigX1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        lineValidator.validate(Arrays.asList("" + (BOARD_MAX_X + 1), "2", "5", "2"));
    }

    @Test
    public void test_validateLineParameters_failTooBigY1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        lineValidator.validate(Arrays.asList("8", "" + (BOARD_MAX_Y + 1), "5", "2"));
    }

    @Test
    public void test_validateLineParameters_failTooBigX2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        lineValidator.validate(Arrays.asList("1", "2", "" + (BOARD_MAX_X + 1), "2"));
    }

    @Test
    public void test_validateLineParameters_failTooBigY2() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        lineValidator.validate(Arrays.asList("8", "3", "5", "" + (BOARD_MAX_Y + 1)));
    }
}
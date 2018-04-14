package com.jkudla.drawingTest.drawing.bucket;

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
import static com.jkudla.drawingTest.drawing.bucket.BucketValidator.WRONG_COLOUR_LENGTH;

public class BucketValidatorTest {

    private BucketValidator bucketValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        bucketValidator = new BucketValidator();
    }

    @Test
    public void test_validateBucketParameters_successBucket() throws WrongParametersException {
        bucketValidator.validate(Arrays.asList("1", "2", "g"));
    }

    @Test
    public void test_validateBucketParameters_failNotEnoughParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        bucketValidator.validate(Arrays.asList("8", "2"));
    }

    @Test
    public void test_validateBucketParameters_failTooManyParameters() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_NB_OF_PARAMETERS);
        bucketValidator.validate(Arrays.asList("8", "2", "g", "2"));
    }

    @Test
    public void test_validateBucketParameters_failTooBigX1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_X);
        bucketValidator.validate(Arrays.asList("" + (BOARD_MAX_X + 1), "2", "o"));
    }

    @Test
    public void test_validateBucketParameters_failTooBigY1() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_PARAMETERS_Y);
        bucketValidator.validate(Arrays.asList("8", "" + (BOARD_MAX_Y + 1), "o"));
    }

    @Test
    public void test_validateBucketParameters_failColourWrongColourLength() throws WrongParametersException {
        thrown.expect(WrongParametersException.class);
        thrown.expectMessage(WRONG_COLOUR_LENGTH);
        bucketValidator.validate(Arrays.asList("8", "2", "ab"));
    }
}

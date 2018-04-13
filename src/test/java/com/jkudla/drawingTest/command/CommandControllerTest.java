package com.jkudla.drawingTest.command;

import com.jkudla.drawingTest.exception.WrongCommandException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jkudla.drawingTest.command.CommandController.MAX_OPERATION_LENGTH;
import static com.jkudla.drawingTest.command.CommandController.NO_OPERATION;
import static com.jkudla.drawingTest.command.CommandController.findOperation;
import static com.jkudla.drawingTest.command.CommandController.findParameters;
import static org.junit.Assert.assertEquals;

public class CommandControllerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /** FIND OPERATION */

    @Test
    public void test_findOperationName_SucessNoParameters() throws WrongCommandException {
        //given
        String command = "Z";

        //when
        String operation = findOperation(command);

        //then
        assertEquals("Z", operation);
    }

    @Test
    public void test_findOperationName_SucessWithParameters() throws WrongCommandException {
        //given
        String command = "C 342 fsd";

        //when
        String operation = findOperation(command);

        //then
        assertEquals("C", operation);
    }

    @Test
    public void test_findOperationName_FailTooManyLettersInOperationName() throws WrongCommandException {
        //given
        String command = "CX 342 fsd";

        //then
        thrown.expect(WrongCommandException.class);
        thrown.expectMessage(MAX_OPERATION_LENGTH + CommandConstants.MAX_OPERATION_NAME_LENGTH);
        findOperation(command);
    }

    @Test
    public void test_findCommandLetter_FailTooNoOperationFoundLetterInside() throws WrongCommandException {
        //given
        String command = "A3S 23 as";

        //then
        thrown.expect(WrongCommandException.class);
        thrown.expectMessage(NO_OPERATION);
        findOperation(command);
    }

    @Test
    public void test_findOperationName_FailTooNoOperationFoundStartsFromLetter() throws WrongCommandException {
        //given
        String command = "1S";

        //then
        thrown.expect(WrongCommandException.class);
        thrown.expectMessage(NO_OPERATION);
        findOperation(command);
    }

    @Test
    public void test_findOperationName_FailTooNoOperationFoundEmptyString() throws WrongCommandException {
        //given
        String command = "";

        //then
        thrown.expect(WrongCommandException.class);
        thrown.expectMessage(NO_OPERATION);
        findOperation(command);
    }

    /** FIND PARAMETERS */

    @Test
    public void test_findParameters_SucessNoParameters() throws WrongCommandException {
        //given
        String command = "Z";

        //when
        List<String> parameters = findParameters(command);

        //then
        assertEquals(new ArrayList<>(), parameters);
    }

    @Test
    public void test_findParameters_SucessOneParameter() throws WrongCommandException {
        //given
        String command = "Z 12";

        //when
        List<String> parameters = findParameters(command);

        //then
        assertEquals(Arrays.asList("12"), parameters);
    }

    @Test
    public void test_findParameters_SucessTwoParameter() throws WrongCommandException {
        //given
        String command = "Z 5 Z3";

        //when
        List<String> parameters = findParameters(command);

        //then
        assertEquals(Arrays.asList("5", "Z3"), parameters);
    }

    @Test
    public void test_findParameters_SucessTwoParametersExtraSpaces() throws WrongCommandException {
        //given
        String command = "Z  1z   Z3";

        //when
        List<String> parameters = findParameters(command);

        //then
        assertEquals(Arrays.asList("1z", "Z3"), parameters);
    }
}

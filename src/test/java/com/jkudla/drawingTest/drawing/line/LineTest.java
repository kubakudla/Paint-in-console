package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.board.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.jkudla.drawingTest.board.Board.EMPTY_SIGN;
import static com.jkudla.drawingTest.drawing.line.Line.DRAW_SIGN;
import static org.junit.Assert.assertEquals;

public class LineTest {

    private Line line;
    private Board board;

    @Before
    public void init() {
        line = new Line();
        board = new Board();
    }

    @Test
    public void test_drawAHorizontalLine() {
        line.draw(board, Arrays.asList("1", "2", "5", "2"));
        char[][] boardArray = board.getBoardArray();
        assertEquals(EMPTY_SIGN, boardArray[2][0]);
        assertEquals(DRAW_SIGN, boardArray[2][1]);
        assertEquals(DRAW_SIGN, boardArray[2][2]);
        assertEquals(DRAW_SIGN, boardArray[2][3]);
        assertEquals(DRAW_SIGN, boardArray[2][4]);
        assertEquals(DRAW_SIGN, boardArray[2][5]);
        assertEquals(DRAW_SIGN, boardArray[2][5]);
        assertEquals(EMPTY_SIGN, boardArray[2][6]);
    }

    @Test
    public void test_drawAVerticalLine() {
        line.draw(board, Arrays.asList("3", "4", "3", "7"));
        char[][] boardArray = board.getBoardArray();
        assertEquals(EMPTY_SIGN, boardArray[3][3]);
        assertEquals(DRAW_SIGN, boardArray[4][3]);
        assertEquals(DRAW_SIGN, boardArray[5][3]);
        assertEquals(DRAW_SIGN, boardArray[6][3]);
        assertEquals(DRAW_SIGN, boardArray[7][3]);
        assertEquals(EMPTY_SIGN, boardArray[2][3]);
    }
}

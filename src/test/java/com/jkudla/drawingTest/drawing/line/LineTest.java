package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.board.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

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
        //given
        int x1 = 1;
        int x2 = 5;
        int y = 2;

        //when
        line.draw(board, Arrays.asList("" + x1, "" + y, "" + x2, "" + y));
        char[][] boardArray = board.getBoardArray();

        //then
        IntStream.range(x1, x2 + 1).forEach(x -> assertEquals(DRAW_SIGN, boardArray[y][x]));
        assertEquals(EMPTY_SIGN, boardArray[y][x1 - 1]);
        assertEquals(EMPTY_SIGN, boardArray[y][x2 + 1]);
    }

    @Test
    public void test_drawAVerticalLine() {
        //given
        int x = 3;
        int y1 = 4;
        int y2 = 7;

        //when
        line.draw(board, Arrays.asList("" + x, "" + y1, "" + x, "" + y2));
        char[][] boardArray = board.getBoardArray();

        //then
        IntStream.range(y1, y2 + 1).forEach(y -> assertEquals(DRAW_SIGN, boardArray[y][x]));
        assertEquals(EMPTY_SIGN, boardArray[y1 - 1][x]);
        assertEquals(EMPTY_SIGN, boardArray[y2 + 1][x]);
    }

    @Test
    public void test_drawAPoint() {
        //given
        int x = 0;
        int y = 1;

        //when
        line.draw(board, Arrays.asList("" + x, "" + y, "" + x, "" + y));
        char[][] boardArray = board.getBoardArray();

        //then
        assertEquals(DRAW_SIGN, boardArray[y][x]);
        assertEquals(EMPTY_SIGN, boardArray[y][x + 1]);
    }
}
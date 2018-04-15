package com.jkudla.drawingTest.drawing.rectangle;

import com.jkudla.drawingTest.board.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static com.jkudla.drawingTest.drawing.rectangle.Rectangle.DRAW_SIGN;
import static org.junit.Assert.assertEquals;

public class RectangleTest {

    private Rectangle rectangle;
    private Board board;

    @Before
    public void init() {
        rectangle = new Rectangle();
        board = new Board();
    }

    @Test
    public void test_drawRectangle() {
        //given
        int x1 = 1;
        int y1 = 2;
        int x2 = 5;
        int y2 = 6;

        //when
        rectangle.draw(board, Arrays.asList("" + x1, "" + y1, "" + x2, "" + y2));
        char[][] boardArray = board.getBoardArray();

        //then
        assertRectangleDrawn(x1, y1, x2, y2, boardArray);
    }

    @Test
    public void test_drawSimplestRectangle() {
        //given
        int x1 = 1;
        int y1 = 1;
        int x2 = 2;
        int y2 = 2;

        //when
        rectangle.draw(board, Arrays.asList("" + x1, "" + y1, "" + x2, "" + y2));
        char[][] boardArray = board.getBoardArray();

        //then
        assertRectangleDrawn(x1, y1, x2, y2, boardArray);
    }

    @Test
    public void test_drawLongestRectangle() {
        //given
        int x1 = 0;
        int y1 = 0;
        int x2 = BOARD_MAX_X;
        int y2 = BOARD_MAX_Y;

        //when
        rectangle.draw(board, Arrays.asList("" + x1, "" + y1, "" + x2, "" + y2));
        char[][] boardArray = board.getBoardArray();

        //then
        assertRectangleDrawn(x1, y1, x2, y2, boardArray);
    }

    private void assertRectangleDrawn(int x1, int y1, int x2, int y2, char[][] boardArray) {
        IntStream.range(x1, x2 + 1).forEach(x -> assertEquals(DRAW_SIGN, boardArray[y1][x]));
        IntStream.range(x1, x2 + 1).forEach(x -> assertEquals(DRAW_SIGN, boardArray[y2][x]));
        IntStream.range(y1, y2 + 1).forEach(y -> assertEquals(DRAW_SIGN, boardArray[y][x1]));
        IntStream.range(y1, y2 + 1).forEach(y -> assertEquals(DRAW_SIGN, boardArray[y][x2]));
    }
}
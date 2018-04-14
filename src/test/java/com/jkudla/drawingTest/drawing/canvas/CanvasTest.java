package com.jkudla.drawingTest.drawing.canvas;

import com.jkudla.drawingTest.board.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.jkudla.drawingTest.drawing.canvas.Canvas.DRAW_SIGN_X;
import static com.jkudla.drawingTest.drawing.canvas.Canvas.DRAW_SIGN_Y;
import static org.junit.Assert.assertEquals;

public class CanvasTest {

    private Canvas canvas;
    private Board board;

    @Before
    public void init() {
        canvas = new Canvas();
        board = new Board();
    }

    @Test
    public void test_drawCanvas() {
        //given
        int w = 4;
        int h = 2;

        //when
        canvas.draw(board, Arrays.asList("" + w, "" + h));
        char[][] boardArray = board.getBoardArray();

        //then
        IntStream.range(0, w + 1).forEach(x -> assertEquals(DRAW_SIGN_X, boardArray[0][x]));
        IntStream.range(0, w + 1).forEach(x -> assertEquals(DRAW_SIGN_X, boardArray[h + 1][x]));

        IntStream.range(1, h + 1).forEach(y -> assertEquals(DRAW_SIGN_Y, boardArray[y][0]));
        IntStream.range(1, h + 1).forEach(y -> assertEquals(DRAW_SIGN_Y, boardArray[y][w]));

    }
}

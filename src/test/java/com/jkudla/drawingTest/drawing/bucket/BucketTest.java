package com.jkudla.drawingTest.drawing.bucket;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.rectangle.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;
import static org.junit.Assert.assertEquals;

public class BucketTest {

    private Bucket bucket;
    private Board board;

    @Before
    public void init() {
        bucket = new Bucket();
        board = new Board();
    }

    @Test
    public void test_drawBucketEmptyBoard() {
        //given
        int x = 0;
        int y = 0;
        char colour = '@';

        //when
        bucket.draw(board, Arrays.asList("" + x, "" + y, "" + colour));
        char[][] boardArray = board.getBoardArray();

        //then
        for (int x1 = 0; x1 <= BOARD_MAX_X; x1++) {
            for (int y1 = 0; y1 <= BOARD_MAX_Y; y1++) {
                assertEquals(colour, boardArray[y1][x1]);
            }
        }
    }

    @Test
    public void test_drawBucketFillRectangle() {
        //given
        int x1 = 1;
        int y1 = 2;
        int x2 = 5;
        int y2 = 6;

        int x = 2;
        int y = 3;
        char colour = '@';
        Rectangle rectangle = new Rectangle();

        //when
        rectangle.draw(board, Arrays.asList("" + x1, "" + y1, "" + x2, "" + y2));
        bucket.draw(board, Arrays.asList("" + x, "" + y, "" + colour));
        char[][] boardArray = board.getBoardArray();

        //then
        IntStream.range(x1 + 1, x2).forEach(xx -> assertEquals(colour, boardArray[y1 + 1][xx]));
        IntStream.range(x1 + 1, x2).forEach(xx -> assertEquals(colour, boardArray[y1 + 2][xx]));
        IntStream.range(x1 + 1, x2).forEach(xx -> assertEquals(colour, boardArray[y1 + 3][xx]));
    }

    @Test
    public void test_drawBucketReplaceRectangleLines() {
        //given
        int x1 = 1;
        int y1 = 2;
        int x2 = 5;
        int y2 = 6;

        char colour = '@';
        Rectangle rectangle = new Rectangle();

        //when
        rectangle.draw(board, Arrays.asList("" + x1, "" + y1, "" + x2, "" + y2));
        bucket.draw(board, Arrays.asList("" + x1, "" + y1, "" + colour));
        char[][] boardArray = board.getBoardArray();

        //then
        IntStream.range(x1 + 1, x2).forEach(xx -> assertEquals(colour, boardArray[y1][xx]));
        IntStream.range(x1 + 1, x2).forEach(xx -> assertEquals(colour, boardArray[y1 + 4][xx]));
        IntStream.range(y1, y2 + 1).forEach(y -> assertEquals(colour, boardArray[y][x1]));
        IntStream.range(y1, y2 + 1).forEach(y -> assertEquals(colour, boardArray[y][x2]));
    }
}
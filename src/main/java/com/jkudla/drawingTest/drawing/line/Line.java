package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.Drawing;

import java.util.List;

public class Line implements Drawing {

    static final char DRAW_SIGN = 'X';

    static final int X1 = 0;
    static final int Y1 = 1;
    static final int X2 = 2;
    static final int Y2 = 3;

    @Override
    public void draw(Board board, List<String> parameters) {
        char[][] boardArray = board.getBoardArray();

        int x1 = Integer.parseInt(parameters.get(X1));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y2 = Integer.parseInt(parameters.get(Y2));

        if (x1 == x2) {
            drawVerticalLine(boardArray, x1, y1, y2);
        } else if (y1 == y2) {
            drawHorizontalLine(boardArray, x1, y1, x2);
        }
        board.setBoardArray(boardArray);
    }

    private void drawVerticalLine(char[][] boardArray, int x1, int y1, int y2) {
        for (int i = y1; i <= y2; i++) {
            boardArray[i][x1] = DRAW_SIGN;
        }
    }

    private void drawHorizontalLine(char[][] boardArray, int x1, int y1, int x2) {
        for (int i = x1; i <= x2; i++) {
            boardArray[y1][i] = DRAW_SIGN;
        }
    }
}

package com.jkudla.drawingTest.drawing.line;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.AbstractDrawing;
import com.jkudla.drawingTest.drawing.Drawing;

import java.util.List;

public class Line extends AbstractDrawing implements Drawing {

    static final char DRAW_SIGN = 'X';

    static final int X1 = 0;
    static final int Y1 = 1;
    static final int X2 = 2;
    static final int Y2 = 3;

    @Override
    public void draw(Board board, List<String> parameters) {
        int x1 = Integer.parseInt(parameters.get(X1));
        int y1 = Integer.parseInt(parameters.get(Y1));
        int x2 = Integer.parseInt(parameters.get(X2));
        int y2 = Integer.parseInt(parameters.get(Y2));

        if (x1 == x2) {
            drawVerticalLine(board, x1, y1, y2, DRAW_SIGN);
        } else if (y1 == y2) {
            drawHorizontalLine(board, x1, x2, y1, DRAW_SIGN);
        }
    }
}

package com.jkudla.drawingTest.drawing.canvas;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.AbstractDrawing;
import com.jkudla.drawingTest.drawing.Drawing;

import java.util.List;

public class Canvas extends AbstractDrawing implements Drawing {

    static final char DRAW_SIGN_X = '-';
    static final char DRAW_SIGN_Y = '|';

    static final int W = 0;
    static final int H = 1;

    @Override
    public void draw(Board board, List<String> parameters) {
        int width = Integer.parseInt(parameters.get(W));
        int height = Integer.parseInt(parameters.get(H));

        drawHorizontalLine(board, 0, width + 1, 0, DRAW_SIGN_X);
        drawHorizontalLine(board, 0, width + 1, height + 1, DRAW_SIGN_X);

        drawVerticalLine(board, 0, 1, height, DRAW_SIGN_Y);
        drawVerticalLine(board, width + 1, 1, height, DRAW_SIGN_Y);

    }
}

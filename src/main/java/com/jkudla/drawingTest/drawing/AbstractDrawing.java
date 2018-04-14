package com.jkudla.drawingTest.drawing;

import com.jkudla.drawingTest.board.Board;

public abstract class AbstractDrawing {

    protected void drawVerticalLine(Board board, int x, int y1, int y2, char sign) {
        char[][] boardArray = board.getBoardArray();
        for (int i = y1; i <= y2; i++) {
            boardArray[i][x] = sign;
        }
        board.setBoardArray(boardArray);
    }

    protected void drawHorizontalLine(Board board, int x1, int x2, int y, char sign) {
        char[][] boardArray = board.getBoardArray();
        for (int i = x1; i <= x2; i++) {
            boardArray[y][i] = sign;
        }
        board.setBoardArray(boardArray);
    }
}

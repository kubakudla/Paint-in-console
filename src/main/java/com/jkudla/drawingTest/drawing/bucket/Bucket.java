package com.jkudla.drawingTest.drawing.bucket;

import com.jkudla.drawingTest.board.Board;
import com.jkudla.drawingTest.drawing.AbstractDrawing;
import com.jkudla.drawingTest.drawing.Drawing;

import java.util.List;

import static com.jkudla.drawingTest.board.Board.BOARD_MAX_X;
import static com.jkudla.drawingTest.board.Board.BOARD_MAX_Y;

public class Bucket extends AbstractDrawing implements Drawing {

    // parameter indexes
    static final int X = 0;
    static final int Y = 1;
    static final int COLOUR = 2;

    @Override
    public void draw(Board board, List<String> parameters) {
        int x = Integer.parseInt(parameters.get(X));
        int y = Integer.parseInt(parameters.get(Y));
        char newColour = parameters.get(COLOUR).charAt(0);

        char[][] boardArray = board.getBoardArray();
        char oldColour = boardArray[y][x];

        paintSelectedCoordinate(boardArray, x, y, newColour);
        fillPaint(boardArray, x, y, newColour, oldColour);
    }

    private void paintSelectedCoordinate(char[][] boardArray, int x, int y, char colour) {
        boardArray[y][x] = colour;
    }

    public void fillPaint(char[][] boardArray, int x, int y, char colour, char oldColour) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                setColor(boardArray, x + i, y + j, colour, oldColour);
            }
        }
    }

    private void setColor(char[][] boardArray, int x, int y, char newColour, char oldColour) {
        if (shouldChangeColour(boardArray, x, y, newColour, oldColour)) {
            boardArray[y][x] = newColour;
            fillPaint(boardArray, x, y, newColour, oldColour);
        }
    }

    private boolean shouldChangeColour(char[][] boardArray, int x, int y, char newColour, char oldColour) {
        return coordinatesAreWithinBoard(x, y) && currentColourDifferentThanNewButSameAsOld(boardArray, x, y, newColour, oldColour);
    }

    private boolean currentColourDifferentThanNewButSameAsOld(char[][] boardArray, int x, int y, char newColour, char oldColour) {
        return boardArray[y][x] != newColour && boardArray[y][x] == oldColour;
    }

    private boolean coordinatesAreWithinBoard(int x, int y) {
        return x >= 0 && y >= 0 && x <= BOARD_MAX_X && y <= BOARD_MAX_Y;
    }
}

package com.jkudla.drawingTest.board;

public class Board {

    public static final int BOARD_MIN_X = 0;
    public static final int BOARD_MAX_X = 20;
    public static final int BOARD_MIN_Y = 0;
    public static final int BOARD_MAX_Y = 10;

    public static final char EMPTY_SIGN = ' ';

    private char boardArray[][] = new char[BOARD_MAX_Y + 1][BOARD_MAX_X + 1];

    public Board() {
        initEmptyBoard();
    }

    private void initEmptyBoard() {
        for (int i = BOARD_MIN_Y; i <= BOARD_MAX_Y; i++) {
            for (int j = BOARD_MIN_X; j <= BOARD_MAX_X; j++) {
                boardArray[i][j] = EMPTY_SIGN;
            }
        }
    }

    public void print() {
        for (int i = BOARD_MIN_Y; i <= BOARD_MAX_Y; i++) {
            for (int j = BOARD_MIN_X; j <= BOARD_MAX_X; j++) {
                System.out.print(boardArray[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(char[][] boardArray) {
        this.boardArray = boardArray;
    }
}

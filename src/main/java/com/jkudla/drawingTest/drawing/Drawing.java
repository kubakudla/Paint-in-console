package com.jkudla.drawingTest.drawing;

import com.jkudla.drawingTest.board.Board;

import java.util.List;

public interface Drawing {

    void draw(Board board, List<String> parameters);
}

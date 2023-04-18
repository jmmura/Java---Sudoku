package be.technifutur.sudoku;

import be.technifutur.sudoku.sudo9x9.SudokuModel9x9;

public interface SudokuControleur {
    void sart() throws SudokuValueException, SudokuPositionException;

    void init(String fileName);
}

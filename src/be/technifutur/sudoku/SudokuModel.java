package be.technifutur.sudoku;

public interface SudokuModel {
    char EMPTY = 0;

    char getValue(int lig, int col)throws SudokuPositionException;

    void setValue(int lig, int col, char value)
            throws SudokuPositionException, SudokuValueException;

    void deleteValue(int lig, int col)throws SudokuPositionException;

    boolean isValueValid(char value);

    boolean isPositionValid(int lig, int col);

    int getNbvalues();

    int getMaxSize();

    void lock();

//    Object getMemento();
//
//    void setMemento();

    void undo() throws SudokuPositionException, SudokuValueException;
}

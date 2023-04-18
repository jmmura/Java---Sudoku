package be.technifutur.sudoku;

public class SudokuPositionException extends SudokuException {
    public SudokuPositionException() {
    }

    public SudokuPositionException(String message) {
        super(message);
    }

    public SudokuPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SudokuPositionException(Throwable cause) {
        super(cause);
    }

    public SudokuPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

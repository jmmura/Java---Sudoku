package be.technifutur.sudoku.sudo9x9;

import be.technifutur.sudoku.AbstractVue;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuPositionException;
import be.technifutur.sudoku.SudokuVue;

public class Vue9x9 extends AbstractVue implements SudokuVue {
    private static String format = """
                +-------+-------+------+
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                +-------+-------+------+
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                +-------+-------+------+
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                | . . . | . . . | . . .|
                +-------+-------+------+
                """.replaceAll("\\.","%s");

    public Vue9x9(SudokuModel9x9 model) {
        super(format,model);
    }
    public void afficherGrilleVide() {
        afficherGrille(new SudokuModel9x9());
    }
}

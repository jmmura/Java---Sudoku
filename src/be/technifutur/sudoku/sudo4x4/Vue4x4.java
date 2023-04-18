package be.technifutur.sudoku.sudo4x4;

import be.technifutur.sudoku.AbstractVue;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuPositionException;
import be.technifutur.sudoku.SudokuVue;
import be.technifutur.sudoku.sudo9x9.SudokuModel9x9;

public class Vue4x4 extends AbstractVue implements SudokuVue {
    private static String format = """
                +-----+-----+
                | . . | . . |
                | . . | . . |
                +-----+-----+
                | . . | . . |
                | . . | . . |
                +-----+-----+
                """.replaceAll("\\.","%s");

    public Vue4x4(SudokuModel4x4 model) {
        super(format,model);
    }

     public void afficherGrilleVide() {
        afficherGrille(new SudokuModel4x4());
    }

    }

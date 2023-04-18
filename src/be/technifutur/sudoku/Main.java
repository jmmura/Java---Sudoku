package be.technifutur.sudoku;

import be.technifutur.sudoku.sudo4x4.SudokuModel4x4;
import be.technifutur.sudoku.sudo4x4.Vue4x4;
import be.technifutur.sudoku.sudo9x9.SudokuModel9x9;
import be.technifutur.sudoku.sudo9x9.Vue9x9;
import be.technifutur.sudoku.sudoSamourail.SudokuModelSamourail;
import be.technifutur.sudoku.sudoSamourail.VueSamourail;

import java.util.*;

public class Main {
    private static ScannerInput input = new ScannerInput();

    public static void main(String[] args) throws SudokuValueException, SudokuPositionException {

        SudokuControleur controleur =
                switch (input.read("1 Sudoku 4 x 4\n2 Sudoku 9 x 9\n3 Sudoku Samourail\n")) {
                    case "1" -> {
                        SudokuControleur ctrl = getCreateSudokuControleur(new SudokuModel4x4());
                        ctrl.init("C:\\Users\\studentjava11\\Dropbox\\Java\\yannick\\sudoku\\sudo4x4.txt");
                        yield ctrl;
                    }
                    case "2" -> {
                        SudokuControleur ctrl = getCreateSudokuControleur(new SudokuModel9x9());
                        ctrl.init("C:\\Users\\studentjava11\\Dropbox\\Java\\yannick\\sudoku\\sudo9x9.txt");
                        yield ctrl;
                    }
                    case "3" -> {
                        SudokuControleur ctrl = getCreateSudokuControleur(new SudokuModelSamourail());
                        ctrl.init("C:\\Users\\studentjava11\\Dropbox\\Java\\yannick\\sudoku\\sudokuSamourai.txt");
                        yield ctrl;
                    }
                    default -> null;
                };
        if (controleur != null) {
             controleur.sart();
        }




    }

    private static SudokuControleur getCreateSudokuControleur(SudokuModel9x9 sudoku) {
        Vue9x9 vue = new Vue9x9(sudoku);
        return new CreateSudokuControleur(sudoku, vue, input);
    }

    private static SudokuControleur getCreateSudokuControleur(SudokuModel4x4 sudoku) {
        Vue4x4 vue = new Vue4x4(sudoku);
        return new CreateSudokuControleur(sudoku, vue, input);
    }

    private static SudokuControleur getCreateSudokuControleur(SudokuModelSamourail sudoku) {
        VueSamourail vue = new VueSamourail(sudoku);
        return new CreateSudokuControleur(sudoku, vue, input);
    }
}

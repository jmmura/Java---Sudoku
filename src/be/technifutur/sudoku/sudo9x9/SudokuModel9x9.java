package be.technifutur.sudoku.sudo9x9;

import be.technifutur.sudoku.*;

import java.util.HashSet;
import java.util.Set;

public class SudokuModel9x9 extends AbstractSudokuModel implements SudokuModel {

    public SudokuModel9x9() {
        super(createGrille());
    }

    private static Cell[][] createGrille() {
        Cell[][] grille = new Cell[9][9];
        Set<Character>[] lignes = new Set[9];
        Set<Character>[] colonnes = new Set[9];
        Set<Character>[] square = new Set[9];
        for(int i=0;i<9;i++){
            lignes[i] = new HashSet<>();
            colonnes[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }
        for (int lig = 0; lig < 9; lig++) {
            for (int col = 0; col < 9; col++) {
                grille[lig][col] = new Cell();
                grille[lig][col].addZone("ligne"+lig,lignes[lig]);
                grille[lig][col].addZone("colonne"+col,colonnes[col]);
                grille[lig][col].addZone("carré"+(lig/3)*3+col/3,square[(lig/3)*3 + col/3]);
            }
        }
        return grille;
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9';
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return lig >= 0 &&
                lig < 9 &&
                col >= 0 &&
                col < 9;
    }

    @Override
    public int getNbvalues() {
        return 9*9;
    }


}

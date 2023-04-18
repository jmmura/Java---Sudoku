package be.technifutur.sudoku.sudo4x4;

import be.technifutur.sudoku.AbstractSudokuModel;
import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.SudokuModel;

import java.util.HashSet;
import java.util.Set;

public class SudokuModel4x4 extends AbstractSudokuModel implements SudokuModel {

    public SudokuModel4x4() {
        super(createGrille());
    }

    private static Cell[][] createGrille() {
        Cell[][] grille = new Cell[4][4];
        Set<Character>[] lignes = new Set[4];
        Set<Character>[] colonnes = new Set[4];
        Set<Character>[] square = new Set[4];
        for(int i=0;i<4;i++){
            lignes[i] = new HashSet<>();
            colonnes[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }
        for (int lig = 0; lig < 4; lig++) {
            for (int col = 0; col < 4; col++) {
                grille[lig][col] = new Cell();
                grille[lig][col].addZone("ligne"+lig,lignes[lig]);
                grille[lig][col].addZone("colonne"+col,colonnes[col]);
                grille[lig][col].addZone("carré"+(lig/2)*2+col/2,square[(lig/2)*2+col/2]);
            }

        }
        return grille;
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '4';
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return lig >= 0 &&
                lig < 4 &&
                col >= 0 &&
                col < 4;
    }

    @Override
    public int getNbvalues() {
        return 4 * 4;
    }
}

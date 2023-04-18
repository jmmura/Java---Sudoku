package be.technifutur.sudoku.sudoSamourail;

import be.technifutur.sudoku.AbstractSudokuModel;
import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.SudokuModel;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class SudokuModelSamourail extends AbstractSudokuModel implements SudokuModel {

    public SudokuModelSamourail() {
        super(createGrille());
    }

    private static Cell[][] createGrille() {
        Cell[][] grille = new Cell[21][21];
        Set<Character>[] lignes = new Set[45];
        Set<Character>[] colonnes = new Set[45];
        Set<Character>[] square = new Set[41];
        for(int i=0;i<45;i++){
            lignes[i] = new HashSet<>();
            colonnes[i] = new HashSet<>();
            if(i<41) {
                square[i] = new HashSet<>();
            }
        }
        int carre=0;
        for (int lig = 0; lig < 21; lig++) {
            for (int col = 0; col < 21; col++) {
                //if (isPositionValidStatic(lig, col)){
                    grille[lig][col] = new Cell();

                    if(col<9 && (lig <9 || lig >11)){
                        grille[lig][col].addZone("ligneGauche"+lig,lignes[lig]);
                    }
                    if(col>11 && (lig<9 || lig >11)){
                        grille[lig][col].addZone("ligneDroite"+lig,lignes[lig+18]);
                    }

                    if(lig<9 && (col <9 || col >11)){
                        grille[lig][col].addZone("colonneHaut"+col,colonnes[col]);
                    }
                    if(lig>11 && (col<9 || col >11)){
                        grille[lig][col].addZone("colonneBas"+col,colonnes[col+18]);
                    }

                    if(lig>5 && lig<15 && col>5 && col<15){
                        grille[lig][col].addZone("ligneMilieu"+lig,lignes[lig+30]);
                        grille[lig][col].addZone("colonneMilieu"+col,colonnes[col+30]);
                    }

                    if(!( ((col>8 && col<12) && (lig<6 || lig>14)) || ((lig>8 && lig<12) && (col<6 || col >14)))){
                        grille[lig][col].addZone("carre"+(lig/3)*7 + (col/3)+1,square[carre]);
                        carre++;
                        if(carre==3){carre=0;}
                    }






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
        return isPositionValidStatic(lig, col);
    }

    public static boolean isPositionValidStatic(int lig, int col) {
        return isPositionInSudoku(lig, col, 0, 0) ||
                isPositionInSudoku(lig, col, 0, 9 + 3) ||
                isPositionInSudoku(lig, col, 6, 6) ||
                isPositionInSudoku(lig, col, 9 + 3, 0) ||
                isPositionInSudoku(lig, col, 9 + 3, 9 + 3);
    }

    @Override
    public int getNbvalues() {
        return 21 * 21 - 4 * 3 * 6;
    }

    private static boolean isPositionInSudoku(int lig, int col, int lig0, int col0) {
        return lig >= lig0 &&
                lig < 9 + lig0 &&
                col >= col0 &&
                col < 9 + col0;
    }
}
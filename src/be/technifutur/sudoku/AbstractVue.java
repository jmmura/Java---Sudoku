package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoSamourail.SudokuModelSamourail;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractVue implements SudokuVue{
    private String format;
    private SudokuModel model;

    public AbstractVue(String format, SudokuModel model) {
        this.format = format;
        this.model = model;
    }

    public void afficherGrille() {
        afficherGrille(model);
        if(message != null){
            System.out.println(message);
            message = null;
        }
    }

    private String message;
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public void afficherGrille(SudokuModel model) {
        int nbValue = model.getNbvalues();
        int size = model.getMaxSize();

        List<Character> vect = new LinkedList<>();
         for (int lig = 0; lig < size; lig++) {
            for (int col = 0; col < size; col++) {
                if (model.isPositionValid(lig, col)) {
                    try {
                        if (model.getValue(lig, col) == SudokuModel.EMPTY) {
                            vect.add( '.');
                        } else {
                            vect.add(model.getValue(lig, col));
                        }
                    } catch (SudokuPositionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        afficherVecteur(vect);
    }
    private void afficherVecteur(List<Character> list) {
        System.out.printf(this.format, list.toArray());
    }

}

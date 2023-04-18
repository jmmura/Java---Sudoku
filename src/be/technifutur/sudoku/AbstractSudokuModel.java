package be.technifutur.sudoku;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class AbstractSudokuModel implements SudokuModel {

    private final Cell[][] grille;
    public static LinkedList<memento> operations = new LinkedList<>();

    //private LinkedList<String> operations = new LinkedList<>();
    public AbstractSudokuModel(Cell[][] grille){
        this.grille = grille;
       /* grille = new Cell[size][size];
        for (int lig = 0; lig < size; lig++) {
            for (int col = 0; col < size; col++) {
                grille[lig][col]= new Cell();
            }
        }*/
    }

//    public Object getMemento(){}
//
//    public void setMemento(){}
    public void undo() throws SudokuPositionException, SudokuValueException {
        if(!operations.isEmpty()){
            memento last = operations.getFirst();
            if(last.valeur==EMPTY){
                deleteValue(last.ligne,last.colonne);
            }else{
                setValue(last.ligne, last.colonne, last.valeur);
                operations.removeFirst();
            }
            operations.removeFirst();
        }

    }

    @Override
    public char getValue(int lig, int col) throws SudokuPositionException {
        testPosition(lig, col);
        return this.grille[lig][col].getValue();
    }

    private void testPosition(int lig, int col) throws SudokuPositionException {
        if (!isPositionValid(lig, col)) {
            throw new SudokuPositionException(String.format("la position %s, %s n'est pas valide", lig, col));
        }
    }

    public abstract boolean isPositionValid(int lig, int col);

    @Override
    public void setValue(int lig, int col, char value) throws SudokuPositionException, SudokuValueException {
        testPosition(lig, col);
        testValue(value);

        operations.addFirst(new memento(lig,col,this.grille[lig][col].getValue()));
        System.out.println();
        boolean x = this.grille[lig][col].setValue(value);
        if(x){

            //operations.addFirst(String.valueOf(lig)+String.valueOf(col)+String.valueOf(c));
//            System.out.println("ajout dans liste ("+operations.getFirst()+": ligne "+String.valueOf(lig)+" colonne "+String.valueOf(col)+"  valeur  "+String.valueOf(c));
        }
    }

    private void testValue(char value) throws SudokuValueException {
        if (!isValueValid(value)) {
            throw new SudokuValueException(String.format("la valeur %s n'est pas valide", value));
        }
    }

    public int getMaxSize() {
        return this.grille.length;
    }
    @Override
    public void deleteValue(int lig, int col) throws SudokuPositionException {
        testPosition(lig, col);
//        operations.addFirst(String.valueOf(lig)+String.valueOf(col)+String.valueOf(grille[lig][col].getValue()));
//        System.out.println(String.valueOf(lig)+String.valueOf(col)+String.valueOf(grille[lig][col].getValue())+" supprimé");
        grille[lig][col].clear();

    }

    @Override
    public abstract boolean isValueValid(char value);

    @Override
    public void lock() {
        for (Cell[] cells : grille) {
            for (Cell cell : cells) {
                cell.lock();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();
        char[][] t = new char[3][3];
        int x=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               t[i][j] = (char)(x++ + '0');
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        l.addFirst(String.valueOf(1)+String.valueOf(2)+String.valueOf(t[1][2]));
        t[1][2] = '9';
        System.out.println("modif: liste = "+l);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("undo");
        if(!l.isEmpty()) {
            int y = Integer.parseInt(l.getFirst());
            t[y / 100][(y % 100) / 10]= l.getFirst().charAt(2);
            l.removeFirst();
        }else{
            System.out.println("Aucune annulation possible");
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }



    }
}

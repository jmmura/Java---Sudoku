package be.technifutur.sudoku;

public class memento {
    public int ligne;
    public int colonne;
    public char valeur;

    public memento(int l,int c, char x){
        ligne=l;
        colonne=c;
        valeur=x;
    }
    public String toString(){
        return ligne+";"+colonne+";"+valeur;
    }
}

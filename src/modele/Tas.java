package modele;

import java.util.InputMismatchException;

public class Tas {
/* ****************
        Variables
**************** */
private int allumettes[];
private static int contrainte;
/* ********************
        Constructeurs
******************** */

    public Tas (int taille) {
        this.allumettes = new int [taille];
        for(int l=0; l<(taille); l++){//ligne
            allumettes[l]=l*2+1;
        }
    }

/* ****************
        Methodes
**************** */

    public int[] getAllumettes() {
        return allumettes;
    }

    /**
     * Retire le nombre d'allumettes stocké dans un coup et vérifie
     * @param ligne
     * @param allumettes
     */
    public void retirer (int ligne, int allumettes) throws Exception {
        if (this.allumettes[ligne]<= 0)
            throw new Exception("La ligne est déjà vide");
        if (allumettes >= 0 && contrainte == 0) {
            this.allumettes[ligne] = this.allumettes[ligne] - allumettes;
            return;
        }
        if (allumettes <= 0 || allumettes > contrainte) {
            throw new InputMismatchException("Nombre négatif ou plus grand que la contrainte");
        } else
            this.allumettes [ligne] = this.allumettes[ligne] - allumettes;
        }

    /**
     * Verifie si le tableau du tas est vide ou non
     *
     * @return <code>true</code> si aucune valeure superieure a zero est presente dans le tableau
     */
    public boolean isEmpty() {
        boolean res = true;
        for (int i=0; i < this.allumettes.length; i++ ) {
            if (this.allumettes[i] > 0 )
                return false;
    }
        return res;
    }

    public static void setContrainte(int max) {
        //condition a mettre en absolue ou lever d'exception
       contrainte = max;
    }

    @Override
    public Object clone () {
        Tas copie= new Tas(this.allumettes.length);
        return copie;
    }
}

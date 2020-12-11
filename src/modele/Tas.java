package modele;

public class Tas {
/* ****************
        Variables
**************** */
int allumettes[];    

/* ********************
        Constructeurs
******************** */

    public Tas (int taille) {
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

    public void retirer (int ligne, int allumettes) {

    }
}

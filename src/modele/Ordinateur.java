package modele;

public class Ordinateur {
/* ****************
        Variables
**************** */

/* ********************
        Constructeurs
******************** */

/* ****************
        Methodes
**************** */

    public Coup sansContrainte (Tas jeu) {
        //codage en binaire de chaque ligne du Tas
        String binaire[]= new String[jeu.getAllumettes().length-1];
        for (int l= 0; l < jeu.getAllumettes().length; l++) {
            binaire[l]=Integer.toBinaryString(jeu.getAllumettes()[l]);
        }
    }

    private int resultatXor (String binaire[]) {
        byte byteBinaire [] = binaire[0].getBytes();
        
    }
}

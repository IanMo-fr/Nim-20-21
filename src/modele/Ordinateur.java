package modele;

import java.util.Random;

public class Ordinateur {
/* ****************
        Variables
**************** */
    Random aleatoire;

/* ********************
        Constructeurs
******************** */

/* ****************
        Methodes
**************** */

    public Coup sansContrainte (Tas jeu) {
        //resultat XoR
        int binaire = 0;
        for (int l= 0; l < jeu.getAllumettes().length-1; l++) {
            binaire= binaire ^ jeu.getAllumettes()[l];
        }
        if (binaire == 0) {
            int ligneAlea =aleatoire.nextInt(jeu.getAllumettes().length-2)+1;
            int allumettesAlea = aleatoire.nextInt(jeu.getAllumettes()[ligneAlea]);
            return new Coup(ligneAlea, allumettesAlea);
        }
        else {
            for (int i = 0; i < jeu.getAllumettes().length-2; i++) {
                int resultatBinaire = jeu.getAllumettes()[i] ^jeu.getAllumettes()[i+1];
                if (resultatBinaire < jeu.getAllumettes()[i]) {
                    return new Coup(i,resultatBinaire-jeu.getAllumettes()[i+1] );
                }
            }
            return new Coup();
        }
    }


}

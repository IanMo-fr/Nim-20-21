package modele;

import java.util.Random;

public class Ordinateur extends Joueur{
/* ****************
        Variables
**************** */
    private Random aleatoire = new Random();

/* ********************
        Constructeurs
******************** */
    public Ordinateur(){
        this.name ="IA";
    }
/* ****************
        Methodes
**************** */

    public Coup sansContrainte (Tas jeu) {

        int binaire = 0;
        for (int l= 0; l < jeu.getAllumettes().length; l++) {
            //resultat XoR
            binaire= binaire ^ jeu.getAllumettes()[l];
        }
        if (binaire == 0) {
            int ligneAlea =aleatoire.nextInt(jeu.getAllumettes().length);
            int allumettesAlea = aleatoire.nextInt(jeu.getAllumettes()[ligneAlea]);
            return new Coup(ligneAlea+1, allumettesAlea+1);
        }
        else {
            for (int i = 0; i < jeu.getAllumettes().length; i++) {
                int resultatBinaire = jeu.getAllumettes()[i] ^binaire;
                if (resultatBinaire < jeu.getAllumettes()[i]) {
                    return new Coup(i+1,jeu.getAllumettes()[i]-resultatBinaire );
                }
            }
            return new Coup();
        }
    }

    public Coup avecContrainte (int contrainte, Tas jeu) {
        int allumettesResultat;
        int ligneAlea;
        for (int i= 0; i < jeu.getAllumettes().length-1; i++) {

            if (jeu.getAllumettes()[i]> jeu.getAllumettes()[i]%contrainte+1) {
                allumettesResultat =jeu.getAllumettes()[i]-jeu.getAllumettes()[i]%contrainte+1;
                return new Coup(i+1, allumettesResultat);
            } else {
                do {
                    ligneAlea = aleatoire.nextInt(jeu.getAllumettes().length - 1) + 1;
                }while(jeu.getAllumettes()[ligneAlea]==0);
                int allumettesAlea = aleatoire.nextInt(jeu.getAllumettes()[ligneAlea]+1);
                return new Coup(ligneAlea+1, allumettesAlea+1);
            }
        }
        return new Coup ();
    }


}

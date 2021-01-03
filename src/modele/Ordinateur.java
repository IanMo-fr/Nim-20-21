package modele;

import java.util.Random;

public class Ordinateur extends Joueur{
/* ****************
        Variables
**************** */
    private Random aleatoire;
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
        for (int l= 0; l < jeu.getAllumettes().length-1; l++) {
            //resultat XoR
            binaire= binaire ^ jeu.getAllumettes()[l];
        }
        if (binaire == 0) {
            int ligneAlea =aleatoire.nextInt(jeu.getAllumettes().length-2)+1;
            int allumettesAlea = aleatoire.nextInt(jeu.getAllumettes()[ligneAlea]);
            return new Coup(ligneAlea, allumettesAlea);
        }
        else {
            for (int i = 0; i < jeu.getAllumettes().length-2; i++) {
                int resultatBinaire = jeu.getAllumettes()[i] ^binaire;
                if (resultatBinaire < jeu.getAllumettes()[i]) {
                    return new Coup(i,jeu.getAllumettes()[i]-resultatBinaire );
                }
            }
            return new Coup();
        }
    }

    public Coup avecContrainte (int contrainte, Tas jeu) {
        int allumettesResultat =0;
        for (int i= 0; i < jeu.getAllumettes().length-1; i++) {
            if (jeu.getAllumettes()[i]> jeu.getAllumettes()[i]%contrainte+1) {
                allumettesResultat =jeu.getAllumettes()[i]-jeu.getAllumettes()[i]%contrainte+1;
                return new Coup(i, allumettesResultat);
            } else {
                int ligneAlea =aleatoire.nextInt(jeu.getAllumettes().length-2)+1;
                int allumettesAlea = aleatoire.nextInt(jeu.getAllumettes()[ligneAlea]);
                return new Coup(ligneAlea, allumettesAlea);
            }
        }
        return new Coup ();
    }


}

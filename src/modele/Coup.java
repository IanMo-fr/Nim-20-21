package modele;
/**
 *
 * @author Admin
 */

import controleur.ConstructeurJeu;

/**
*represente un coup (un numéro se tas et un nombre d’allumettes)
*
*/
public class Coup {

/* ****************
        Variables
**************** */
    int lignes;
    int nbAllumettes;
    private static int contrainte;

    
/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public Coup() {
	this.lignes=0;
	this.nbAllumettes =0;
	this.contrainte=0;
}

//constructeur avec contrainte
public Coup(int contrainte) {
	this.lignes=0;
	this.nbAllumettes=0;
	this.contrainte = contrainte;
}

/* ****************
        Methodes 
**************** */

/**
 * Retire le nombre d'allumettes entrees aux total d'allumettes du jeu
 * 
 * @param controleurJeu	    L'objet system de jeu contenant le nombre d'allumettes totals
 *		    ainsi que le tableau de jeu
 */
public void TakeMatches(ConstructeurJeu controleurJeu){

	//retire les allumettes choisit au total
	controleurJeu.totalOfMatches-=this.nbAllumettes;
	//retire les alluettes a une ligne
	controleurJeu.board[this.lignes-1] = controleurJeu.board[this.lignes-1] - this.nbAllumettes;


}

}




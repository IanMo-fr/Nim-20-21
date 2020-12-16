package modele;
/**
 *
 * @author Admin
 */

import controleur.ConstructeurJeu;

/**
*represente un coup (un numéro de tas et un nombre d’allumettes)
*
*/
public class Coup {


	/* ****************
            Variables
    **************** */
    int lignes;
    int nbAllumettes;

    
/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public Coup() {
	this.lignes=0;
	this.nbAllumettes =0;
}


/* ****************
        Methodes 
**************** */


	/**
	 * Setter de ligne
	 * @param lignes
	 */
	public void setLignes(int lignes) {
		this.lignes = lignes;
	}

	/**
	 * Setter de nbALlumettes
	 * @param nbAllumettes
	 */
	public void setNbAllumettes(int nbAllumettes) {
		this.nbAllumettes = nbAllumettes;
	}


	/**
 * Retire le nombre d'allumettes entrees aux total d'allumettes du jeu
 * 
 * @param tas	    L'objet system de jeu contenant les allumettes
 */
	public void TakeMatches(Tas tas) throws Exception {
	//retire les allumettes a une ligne
	tas.retirer(this.lignes-1, this.nbAllumettes);

}

}




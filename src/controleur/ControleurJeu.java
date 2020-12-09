package controleur; /**
 *
 * @author Admin
 */

import modele.Joueur;
import vue.Ihm;

/**
*cette classe represente le plateau de jeu et reunit les differents elements d’un jeu :
*les joueurs et l’etat courant
*/
public class ControleurJeu {

/* ****************
        Variables
**************** */
public static ConstructeurJeu game = new ConstructeurJeu();
public static Joueur[] joueur = new Joueur[2];


/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public ControleurJeu() {
	ConstructeurJeu game = new ConstructeurJeu();
}

//constructeur avec vue.Ihm
public ControleurJeu(Ihm ihm){
	ConstructeurJeu game = new ConstructeurJeu(ihm.getSize());
	joueur[0]= new Joueur(ihm.assignName(1));
	joueur[1]= new Joueur(ihm.assignName(2));
}

//constructeur avec Tableau de Joueurs et ihm
public ControleurJeu(Joueur[] joueur, Ihm ihm){
	ConstructeurJeu game = new ConstructeurJeu(ihm.getSize());
	this.joueur[0] = joueur[0];
	this.joueur[1] = joueur[1];
}




/* ****************
        Methodes 
**************** */

	/**
	 * Vérifie qu'il reste des allumettes sur le plateau
	 * 
	 * @return   <code>true</code> si il n'y a plus d'allumettes
	 *	<code>false</code> dans le cas contraire
	 */
	public boolean endGame(){
		if(this.game.totalOfMatches==0){
			return true;
		}
		return false;
	}


}


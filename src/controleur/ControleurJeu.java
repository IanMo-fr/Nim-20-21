package controleur; /**
 *
 * @author Admin
 */

import modele.Joueur;
import modele.Tas;
import vue.Ihm;

/**
*cette classe represente le plateau de jeu et reunit les differents elements d’un jeu :
*les joueurs et l’etat courant
*/
public class ControleurJeu {

/* ****************
        Variables
**************** */
private Joueur[] joueur = new Joueur[2];
private Tas lesTas;

/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public ControleurJeu() {
	joueur = null;
	lesTas =null;
}

//constructeur avec vue.Ihm et modele.Tas
public ControleurJeu(Ihm console, Tas lesTas){
	joueur[0]= new Joueur(console.assignName(1));
	joueur[1]= new Joueur(console.assignName(2));
	this.lesTas = lesTas;
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


package controleur; /**
 *
 * @author Admin
 */

import modele.HumanPlayer;
import vue.Ihm;

/**
*cette classe represente le plateau de jeu et reunit les differents elements d’un jeu :
*les joueurs et l’etat courant
*/
public class Board {

/* ****************
        Variables
**************** */
public static GameState game = new GameState();
public static HumanPlayer[] joueur = new HumanPlayer[2];


/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public Board() {
	GameState game = new GameState();
}

//constructeur avec vue.Ihm
public Board(Ihm ihm){
	GameState game = new GameState(ihm.getSize());
	joueur[0]= new HumanPlayer(ihm.assignName(1));
	joueur[1]= new HumanPlayer(ihm.assignName(2));
}

//constructeur avec Tableau de Joueurs et ihm
public Board(HumanPlayer[] joueur, Ihm ihm){
	GameState game = new GameState(ihm.getSize());
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


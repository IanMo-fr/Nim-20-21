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
private Ihm vue;

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
	this.vue = console;
}


/* ****************
        Methodes 
**************** */
public void commencerJeu () {
	vue.startGame();
	boolean jouer=true;

	while (jouer) {
		do {

			for (int tour = 0; tour < joueur.length; tour++) {
				vue.showBoard(lesTas.getAllumettes());
				vue.getMove(joueur[tour].getName()).TakeMatches(this.lesTas);
				if (endGame()) {//si le joueur 1 retire toute les allumettes
					joueur[tour].setScore(joueur[tour].getScore() + 1);
					vue.showWinner(joueur[tour].getName());
					break;
				}
			}
		}while (!endGame());
		jouer=vue.restart();

	}
	//fin de la partie
	vue.winnerVictory(joueur[0].isLeading(joueur[1]));
}


	/**
	 * Vérifie qu'il reste des allumettes sur le plateau
	 * 
	 * @return   <code>true</code> si il n'y a plus d'allumettes
	 *	<code>false</code> dans le cas contraire
	 */
	public boolean endGame(){
		if(this.lesTas.isEmpty()){
			return true;
		}
		return false;
	}


}


package controleur; /**
 *
 * @author Admin
 */

import controleur.GameState;

/**
*represente un coup (une ligne et un nombre d’allumettes)
*
*/
public class Move {

/* ****************
        Variables
**************** */
    int lignes;
    int nbMatches;
    boolean valide;
    
/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public Move() {
	this.lignes=0;
	this.nbMatches=0;
	this.valide=true;
}

/* ****************
        Methodes 
**************** */

/**
 * Test des entrees, renvoie faux :
 *  - si le nombre d'allumettes n'est pas compris entre 1 et 3
 *  - si il n'y a pas suffisament d'allumettes dans la ligne entree
 *  - si la ligne - 1 est supérieur a la taille du tableau de jeu
 * 
 * @param jeu	Le tableau de jeu contenant les lignes a tester
 * @return		<code>false</code> quand les entrées ne correspondes pas
 *		aux attentes
 *		<code>true</code> autrement
 */
public boolean LigneCheck(int [] jeu){	
    assert this.lignes>=0: "Erreur Ligne non valide";		
    assert (this.nbMatches>=1 && this.nbMatches<=3): "Erreur nombre de allumettes non valides";
    
    if( this.lignes > jeu.length)
	return false;
		
    
    if( this.nbMatches > jeu [this.lignes-1] || this.nbMatches > 3 || this.nbMatches < 0)	    
	return false;
    

    return true;

}




/**
 * Retire le nombre d'allumettes entrees aux total d'allumettes du jeu
 * 
 * @param gameState	    L'objet system de jeu contenant le nombre d'allumettes totals
 *		    ainsi que le tableau de jeu
 */
public void TakeMatches(GameState gameState){

	
    if (LigneCheck(gameState.board)) {	
	//retire les allumettes choisit au total
	gameState.totalOfMatches-=this.nbMatches;
	//retire les alluettes a une ligne
	gameState.board[this.lignes-1] = gameState.board[this.lignes-1] - this.nbMatches;
	
    } else
	this.valide = false;

}

}




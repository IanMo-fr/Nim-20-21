package controleur;
/**
 *
 * @author Admin
 */

 /**
 *represente l’etat courant du jeu
 *
 */
 
public class ControleurJeu {

/* ****************
        Variables
**************** */

//nombres total d'allumettes (methode Static pour ne pas avoir de 'paire' d'allumettes)
public static int totalOfMatches; 
//nombre de ligne assigné par le joueur
public int nbreLignes;
//tableau de jeu
public static int [] board;

/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public ControleurJeu() {
    this.nbreLignes = 0;
    this.totalOfMatches = 0;
    this.board = new int [0];
}

//constructeur avec nombres de ligne
public ControleurJeu(int lignesDemande) {
    assert (lignesDemande > 0) : "Erreur : Lignes invalides pour créer le tableau de jeu";
    
    this.nbreLignes = lignesDemande;
    for(int i = this.nbreLignes-1 ; i>=0 ; i--){
    	this.totalOfMatches+=i*2+1;
    }
    this.board = new int [nbreLignes];
    initialisation(this.board);

}

/* ****************
        Methodes 
**************** */

/**
 * génère un tableau initialise, stocke 2n +1 allumettes par n lignes
 * 
 * @param jeu	Le tableau contenant les allumettes
 */
	public void initialisation(int [] jeu){// initialisation du tableau d'allumette

	for(int l=0; l<(nbreLignes); l++){//ligne
	    jeu[l]=l*2+1;
	}
	}

}
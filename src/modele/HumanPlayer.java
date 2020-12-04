package modele;
/**
 *
 * @author Admin
 */
 
/**
*un joueur humain
*variable:name(private) | score
* methode:isLeading | getName | SetName | getScore
*/
import java.util.Scanner;
public class HumanPlayer {
Scanner sc = new Scanner(System.in);


/* ****************
        Variables
**************** */
    public String name;
    int score;
    


/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public HumanPlayer() {
    this.name = null;
    this.score = 0;
}

//constructeur avec nom
public HumanPlayer(String name) {
    this.name = name;
}

/* ****************
        Methodes 
**************** */
/**
 * Test le joueur avec le plus haut score renvoie le pseudo du vainqueur 
 * 
 * @param otherOne	L'objet joueur a comparer avec l'objet appelant
 * @return name	Le pseudo du joueur avec la plus grande valeur score
 */
public String isLeading(HumanPlayer otherOne){
    
    if (this.score > otherOne.score) 
	return this.getName();
    else if (this.score < otherOne.score) 
	return otherOne.getName();
    else	//default
	return"Il y a egalite";
}

/**
 * Accesseur de name
 * 
 * @return this.name	Le nom du joueur
 */
public String getName() {
    return this.name;
}

/**
 * Mutateur de name
 * 
 * @param newName   Le nouveau nom pour le nom du joueur
 */
public void setName(String newName) {
    assert (newName != null) : "Erreur : nouveau nom non définit" ;
    
    this.name = newName;
}

/**
 * Accesseur de score
 * 
 * @return		Le score du joueur
 */
public int getScore() {
    return this.score;
}

}


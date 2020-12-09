package controleur;
/**
 *
 * @author Admin
 */

import modele.Tas;
import vue.Ihm;

/**
 *construit le jeu, fournit l'objet <code>Tas</code> initial.
 *
 */
 
public class ConstructeurJeu {

/* ****************
        Variables
**************** */

private Tas tas;

/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public ConstructeurJeu() {
    this.tas = null;
}

//constructeur par la console
public ConstructeurJeu(Ihm console) {

    this.tas = new Tas(console.getSize());

}

/* ****************
        Methodes 
**************** */


    public Tas getLesTas() {
        if (this.tas!=null)
            return this.tas;
        else
            return null;
    }
}
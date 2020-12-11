package controleur;
/**
 *
 * @author Admin
 */

import modele.Coup;
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
private Ihm console;

/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public ConstructeurJeu() {
    this.tas = null;
}

//constructeur par la console
public ConstructeurJeu(Ihm console) {
    this.console = console;
    this.tas = null;

}

/* ****************
        Methodes 
**************** */

    /**
     * Permets la construction d'un nouveau Tas a partir d'une taille
     * @param taille
     */
    public void initTas(int taille) {
        this.tas = new Tas (taille);
    }


    /**
     * Getteur de <code>Tas</code>
     * @return <code>Tas</code> si initialisé par le constructeur, <code>null</code> autrement
     */
    public Tas getLesTas() {
        if (this.tas!=null)
            return this.tas;
        else
            return null;
    }

    /**
     * Permet le demande de contrainte de <code>Coup</code> et de la taille/nombre de lignes de <code>Tas</code>
     */
    public void construireJeu() {
        initTas(console.getSize());
        Coup.setContrainte(console.getContrainte());

    }
}
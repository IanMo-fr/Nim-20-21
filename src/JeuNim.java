import vue.Ihm;

/**
 *
 * @author Admin
 */
public class JeuNim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		Ihm ihm = new Ihm();
		ConstructeurJeu constructeurJeu = new ConstructeurJeu (ihm);
		constructeurJeu.construireJeu();
		Tas lesTas = constructeurJeu.getLesTas();
		ControleurJeu controleurJeu = new controleurJeu(ihm, lesTas);
		constructeurJeu.commencerJeu();
    }
    
}

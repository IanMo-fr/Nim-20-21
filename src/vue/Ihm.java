package vue; /**
 *
 * @author Admin
 */
 
/**
*une classe dont les methodes permettent d’interagir avec le joueurs
*
*/
import modele.Coup;
import modele.Joueur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ihm {
Scanner sc = new Scanner(System.in);



/* ****************
        Variables
**************** */



/* ********************
        Constructeurs
******************** */

//constructeur par défaut
public Ihm() {
/* a laisser vide a moins de remplir le champs de variables */	
}

/* ****************
        Methodes 
**************** */

	/**
	*  demande au joueur de saisir le nombre de lignes pour le plateau de jeu 
	* et retourne cet entier
	* 
	* @return ligne	Le nombre de lignes utilisé pour instancier le tableau de jeu
	*/
	public int getSize() {
		int ligne = 0;
		boolean exception = false;
		
		do {
		System.out.println("\nDonnez le nombre de lignes souhaité pour votre partie");
		
		try {
		    ligne=sc.nextInt();
		    
		    //gestion exception des nombres négatifs
		    if (! (ligne  > 0) ) {
			System.out.println ("Erreur nombre de lignes invalides");
			exception = true;
		    }
		    
		//si tout vas bien
		  else		    
			exception = false;
		    
		//gestion exception si entrée autre que Entier
		} catch (java.util.InputMismatchException e) {
		    exception = true;
		    System.out.println("Erreur : Ceci n'est pas un nombre");
		    sc.next();
		}  

		}while(exception);
		return ligne;
	}

	/**
	 * Saisi de la ligne et le nombre d'alumettes voulu pour un coup
	 * 
	 * @param name	Le nom du joueur courant
	 * @return saisi	Objet de class modele.Coup, contient le choix du joueur soit
	 *		la ligne choisit et le nombre d'allumettes a retirer.
	 */
	public Coup getMove(String name){
		Coup saisi = new Coup();
		boolean exception=false;
		do{ System.out.print("\n"+name+" Saisissez votre ligne et le nombre d'allumettes a retirer, sous la forme 'm n' " +
				"où m est le tas choisi et n le nombre d'allumettes  : ");
			
		try {
			// /!\ remplacer les variables par les méthodes d'accès
			saisi.setLignes(sc.nextInt());

			int nbAll = sc.nextInt();

			saisi.setNbAllumettes(nbAll);

			
			//gestion exception si entrée autre que Entier
			} catch (InputMismatchException e) {
		    	exception = true;
		    	System.out.println("Erreur : Ceci n'est pas un nombre");
		    	sc.next();
			return getMove(name);
			}  	
			
		

		}while(exception);
		return saisi;
	}

	/**
	 * affiche le plateau represente par le tableau d’entiers board
	 *ou board[i] est le nombre d’allumettes restantes de la ligne i.
	 * 
	 * @param board	le tableau contenant le nombre d'allumettes par lignes
	 */
	public void showBoard(int [] board){
		int ligneStart=((board.length*2+1)/2);//la moitié
		int middle= ((board.length*2+1)/2);
		int alLigne ;
		int max= board.length*2+1;

		for(int l=0; l<board.length;l++){//ligne
			if(l>=9){
				System.out.print((l+1)+" : ");
			}
			else{
				System.out.print((l+1)+"  : ");
			}
			
			alLigne = board[l];
			while(alLigne>0){
				for(int a=0;a<max;a++){//allumette
					if((a-(middle))>0){//quand on affiche la partie droite

						if(ligneStart<Math.abs(a-max)){
							System.out.print("I ");
							alLigne--;
							if(alLigne==0){
								break;
							}
						}
						else{
							System.out.print("  ");
						}
					}
					else{//si on est dans la partie gauche et centrale
						if(ligneStart<=a){
							System.out.print("I ");
							alLigne--;
							if(alLigne==0){
								break;
							}
						}
						else{
							System.out.print("  ");
						}
					}
					
				}
			}
			System.out.println();
			ligneStart--;
		}
	}


	/** 
	 *  affiche un message annoncant la victoire du joueur
	 * 
	 * @param name	le pseudo du joueur a afficher dans le message
	 */
	 public void showWinner(String name){//   Nom du vainqueur
		System.out.println("Bravo "+name+" vous avez gagne");
		System.out.println(name+" a gagne un point");
	
	}
	
	/**
	 * Demande le pseudo du joueur
	 * 
	 *@return nom 
	 * @param numjoueur le pseudo du joueur a afficher dans le message
	 */
	public String assignName(int numjoueur) {
		String nom;
		System.out.println("\nQuel est le pseudo du  joueur "+numjoueur+" ?");
		nom = sc.nextLine();
		while(nom.length()<1){// ne touche pas cela résoud un probleme
			nom=sc.nextLine();
		}
		return nom;
	}

	/**
	 * Affichage utilisé au lancement du jeu
	 */
	public void startGame () {
	    System.out.println("\t*********************************");
	    System.out.println("\t*\t\t\t    \t*");
	    System.out.println("\t*\t\t\t    \t*");
	    System.out.println("\t*\t\tNim\t\t*");
	    System.out.println("\t*\t\t\t    \t*");
	    System.out.println("\t*\t\t\t    \t*");
	    System.out.println("\t********************************* ");
	    System.out.println("Bonjour cher joueur, pour jouer a ce jeu vous aurez besoin de 2 joueurs");
	    System.out.println("                                                                        ");
	    System.out.println("Avant de commencer voici quelques regles:\n ");
	    System.out.println(" \t1 - Chaque joueur joue 1 tour");
	    System.out.println(" \t2 - Chaque tour un joueur va choisir une ligne dans laquelle il va retirer au moins une allumettes");
	    System.out.println(" \t3 - Le jeu se finit quand il n'y aura plus d'allumettes a enlever");
	    System.out.println(" \t4 - Le joueur gagnant est celui qui enleve la derniere allumette");



	}
	
	/**
	 * Affichage utilisé pour une demande de relance du jeu
	 * renvoie true si l'entrée est oui, false autrement
	 * 
	 * @return  <code>true</code>	quand l'utilisateur entre "oui" 
	 *	<code>false</code>	dans tout les autres cas
	 */
	public boolean restart() {
	    String choix;
	    
	    System.out.println("\nVoulez vous rejouer?");
	    System.out.println("oui/non");
	    choix=sc.nextLine();
	    while(choix.length()<1){// reutilisation de la soluce de assignName
			choix=sc.nextLine();
		}
	    if(choix.equals("oui")){
		return true;
	    }
		
	    return false;
	}
	
	/**
	 * Affichage utilisé a la fin du jeu
	 * 
	 * @param name	le pseudo du joueur a afficher dans le message
	 */
	public void winnerVictory(String name){

	    System.out.println("\t*********************************");
	    System.out.println("\t*\tFelicitations\t\t*");
	    System.out.println("\t*\t\t\t\t*");
	    System.out.println("\t*\t\t"+name+"\t\t*");
	    System.out.println("\t*\t\t\t\t*");
	    System.out.println("\t*\tVous avez gagne\t\t*");
	    System.out.println("\t*********************************");

	}


	/**
	 * Affiche le score d'un joueur
	 * 
	 * @param joueur	le pseudo du joueur a afficher dans le message
	 */
	public void score (Joueur joueur){
	    System.out.print( joueur.getName()+" : " +joueur.getScore() + "\t");
	}


	/**
	 * Demande le nombre max d'allumettes à retirer par coup autorisé pour la partie, si 0 pas de limite
	 * @return
	 */
	public int getContrainte() {
		System.out.println("\nDonnez le nombre maximum d'allumettes pouvant etre retire en un tour pour votre partie");

		return sc.nextInt();
	}

}



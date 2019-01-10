package Modele;

/**
 * Classe contenant le main
 * 
 *
 */
public class Main {
/**
 * Methode main qui lance le jeu
 * 
 */
	public static void main(String[] args) {
		Ordinateur ordinateur;		
		ordinateur = Ordinateur.getInstance();
		ordinateur.lancerPartie();

	}

}

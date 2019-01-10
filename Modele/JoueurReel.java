package Modele;

import java.util.*;
/**
 * Represente un Joueur Réel héritant de la classe Joueur
 * 
 *
 */
public class JoueurReel extends Joueur {

	ArrayList<Prop> props = new ArrayList<Prop>();
	/**
	 * Constructeur par défaut de la classe qui demande de saisir le nom et l'age du joueur
	 * L'age est entre 8 et 100 ans
	 */
    public JoueurReel(){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("nom : ");
    	this.nom=sc.nextLine();
    	this.doubletProp = props;
    	System.out.println("age : ");
    	while (true) {
    		try {
    			this.age = Integer.parseInt(sc.next());
    			while (this.age<8 || this.age>100) {
    				System.out.println("Mauvaise saisie, vous devez avoir plus de 8 ans");
    				this.age = Integer.parseInt(sc.next());
    			}
    			break;
    		} catch (NumberFormatException ignore) {
    			System.out.println("Mauvaise saisie");
    		}
    	}
    	
    }



}

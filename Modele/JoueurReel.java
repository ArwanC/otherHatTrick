package Modele;

import java.util.*;

public class JoueurReel extends Joueur {
	
	ArrayList<Prop> props = new ArrayList<Prop>();
	
    public JoueurReel(){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("nom : ");
    	this.nom=sc.nextLine();
    	this.doubletProp = props;
    	System.out.println("age : ");
    	while (true) { // checks si input est un int and (< 0) and (> 3).
    		try {
    			this.age = Integer.parseInt(sc.next());
    			while (this.age<8 || this.age>100) {
    				System.out.println("Mauvaise saisie, vous devez avoir plus de 8 ans");
    				this.age = Integer.parseInt(sc.next());
    			}
    			break; // arrete la boucle si input est correct.
    		} catch (NumberFormatException ignore) {
    			System.out.println("Mauvaise saisie");
    		}
    	}
    	
    }

    public void ligneDeCommande() {
    }

    public void interfaceGraphique() {
    }


}

import java.util.*;

public class JoueurReel extends Joueur {
	
	ArrayList<Prop> props = new ArrayList<Prop>();
	private String newLine = System.getProperty("line.separator");
	
    public JoueurReel(){
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("nom : ");
    	this.nom=sc.nextLine();
    	this.doubletProp = props;
    	System.out.println("age : ");
    	while (true) { // check si input est un int and (< 0) and (> 3).
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
    
    public void echangerProp(int numAdv, int joueurActuel, int propAdv, int monProp, LinkedList<Joueur> listJoueur) {
		Prop intermediaire = listJoueur.get(numAdv).doubletProp.get(propAdv);
		listJoueur.get(numAdv).doubletProp.remove(propAdv);
		listJoueur.get(numAdv).doubletProp.add(propAdv, listJoueur.get(joueurActuel).doubletProp.get(monProp));
		listJoueur.get(joueurActuel).doubletProp.remove(monProp);
		listJoueur.get(joueurActuel).doubletProp.add(monProp, intermediaire);
		System.out.println(newLine+"Vous avez recupere : " + intermediaire.getNom());
	}

}

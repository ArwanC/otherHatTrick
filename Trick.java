import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Trick extends Carte{
	
	String newLine = System.getProperty("line.separator"); // Sous Windows et MacOS le retour � la ligne n'est pas le m�me.
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		builder.append(newLine +"                           ");
		builder.append(propG);
		builder.append("     ");
		builder.append(propD);
		return builder.toString();
	}

	private ArrayList<Prop> propG;
	private ArrayList<Prop> propD;
	
	//private String nom;
	private int point;
    private int pointDePenalite;
	
	public Trick(ArrayList<Prop> propG, ArrayList<Prop> propD, String nom, int point, int pointDePenalite) {
		super(nom);
		this.propG = propG;
		this.propD = propD;
		this.nom = nom;
		this.point = point;
		this.pointDePenalite = pointDePenalite;
		
	} 
	
	public String getNom() {
        return this.nom;
    }
	public ArrayList<Prop> getPropG() {
		return propG;
	}
	public ArrayList<Prop> getPropD() {
		return propD;
	}
    
	public int getPoint() {
		return point;
	}
	
	private LinkedList<Trick> listTrick = new LinkedList<Trick>();
	
	private Trick trickEnCours;
	
	public LinkedList<Trick> creerTricksPrincipaux(LinkedList<Trick> t, ArrayList<Prop> p) {
		t.add(new Trick(ajouterProps("The Rabbit", "The Other Rabbit"), ajouterProps("The Lettuce", "Carrots"),
				"The Hungry Rabbit", 1, 0));
		t.add(new Trick(ajouterProps("Carrots"), ajouterProps("Carrots"), "The Bunch of Carrots", 2, 0));
		t.add(new Trick(ajouterProps("The Rabbit", "The Other Rabbit"), ajouterProps("The Lettuce"),
				"The Rabbit That Didn't Like Carrots", 4, 0));
		t.add(new Trick(ajouterProps("The Rabbit"), ajouterProps("The Other Rabbit"), "The Pair of Rabbits", 5, 0));
		t.add(new Trick(ajouterProps("The Hat"), ajouterProps("Carrots"), "The Carrot Hat Trick", 3, 0));
		t.add(new Trick(ajouterProps("The Hat"), ajouterProps("The Rabbit", "The Other Rabbit"),
				"The Slightly Easier Hat Trick", 4, 0));
		t.add(new Trick(ajouterProps("The Hat"), ajouterProps("The Other Rabbit"), "The Other Hat Trick", 6, -3));
		return t;
	}
	
	public LinkedList<Trick> melangerTricks() {
		Trick theOtherHatTrick = listTrick.getLast();
		listTrick.remove(listTrick.getLast());
		Collections.shuffle(listTrick);
		listTrick.addLast(theOtherHatTrick);
		return listTrick;
	}
	
	
}

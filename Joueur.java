import java.util.*;

import org.apache.commons.lang3.reflect.TypeUtilsTest.This;

import java.text.*;

public class Joueur {
	private String newLine = System.getProperty("line.separator");
    protected String nom;
    protected int age;
    protected int position;
    protected int score;
    protected ArrayList<Prop> doubletProp;
    
    public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Joueur [nom=");
		builder.append(nom);
		builder.append(", age=");
		builder.append(age);
		builder.append(", position=");
		builder.append(position);
		builder.append(", score=");
		builder.append(score);
		builder.append(", doubletProp=");
		builder.append(doubletProp);
		builder.append("]");
		return builder.toString();
	}

    
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Joueur(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	public Joueur() {}

	public ArrayList<Prop> getDoubletProp() {
		return doubletProp;
	}

	public void setDoubletProp(ArrayList<Prop> doubletProp) {
		this.doubletProp = doubletProp;
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

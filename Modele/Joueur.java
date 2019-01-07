import java.util.*;

import org.apache.commons.lang3.reflect.TypeUtilsTest.This;

import java.text.*;

public class Joueur {
	
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
    

}

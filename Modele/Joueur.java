package Modele;

import java.util.*;

import org.apache.commons.lang3.reflect.TypeUtilsTest.This;

import java.text.*;
/**
 * Classe Joueur représentant un des joueurs de la partie
 * 
 *
 */
public class Joueur {
	/**
	 * Nom du joueur
	 */
    protected String nom;
    /**
     * Age du joueur pour définir l'ordre de jeu
     */
    protected int age;
    /**
     * Position du joueur dans le tour
     */
    protected int position;
    /**
     * Nombre de points du joueur
     */
    protected int score;
    /**
     * Liste de deux Props, c'est la main du joueur
     */
    protected ArrayList<Prop> doubletProp;
    
    /**
     * Getter sur le nom du joueur
     * @return le nom du joueur
     */
    public String getNom() {
		return nom;
	}
    /**
     * Setter sur le nom du joueur
     * @param nom Nouveau nom du joueur
     */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter sur l'age du joueur
	 * @return L'age du joueur
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Setter sur l'age du joueur
	 * @param Nouvel age du joueur
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	/**
	 * Méthode toString du joueur afin d'afficher ses informations
	 */
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

    /**
     * Getter sur le score
     * @return Le score du joueur
     */
    public int getScore() {
		return score;
	}
/**
 * Setter sur le score
 * @param score Nouveau score du joueur à définir
 */
	public void setScore(int score) {
		this.score = score;
	}

/** 
 * Constructeur par paramètre de la classe
 * @param nom Nom du joueur
 * @param age Age du joueur
 */
	public Joueur(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	/**
	 * Constructeur par defaut de la classe
	 */
	public Joueur() {}
/**
 *Getter sur la liste de prop du joueur
 * @return La liste de props du joueur
 */
	public ArrayList<Prop> getDoubletProp() {
		return doubletProp;
	}
/**
 * setter sur les props du joueurs
 * @param doubletProp Liste de props du joueurs
 */
	public void setDoubletProp(ArrayList<Prop> doubletProp) {
		this.doubletProp = doubletProp;
	}
    

}

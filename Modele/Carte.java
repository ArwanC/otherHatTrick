package Modele;
/**
 * Classe représentant une carte de jeu
 * 
 *
 */
public class Carte {
/**
 * Nom de la carte
 */
	protected String nom;
/**
 * Getter sur le nom
 * @return Retourne le nom
 */
	public String getNom() {
		return nom;
	}
/**
 * Setter sur le nom
 * @param Permet de définir le nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
/**
 * Constructeur de la classe Carte
 * @param nom  Nom à fournir pour la création de la classe
 */
	public Carte(String nom) {
		this.nom = nom;
	}
	
/**
 * Constructeur par défaut
 */
	public Carte() {}

}

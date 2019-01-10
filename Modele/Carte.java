package Modele;
/**
 * Classe repr�sentant une carte de jeu
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
 * @param Permet de d�finir le nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
/**
 * Constructeur de la classe Carte
 * @param nom  Nom � fournir pour la cr�ation de la classe
 */
	public Carte(String nom) {
		this.nom = nom;
	}
	
/**
 * Constructeur par d�faut
 */
	public Carte() {}

}

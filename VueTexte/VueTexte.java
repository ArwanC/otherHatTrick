package VueTexte;

import java.util.Observable;
import java.util.Observer;

import Modele.Ordinateur;
/**
 * Interface concurente en ligne de commande
 * 
 *
 */
public class VueTexte implements Observer, Runnable {
	
	public VueTexte(Ordinateur ordi){
		Thread t = new Thread(this);
		t.start();
	}
	
    public void run() {}
    private String lireChaine() {}

    public void update(Observable arg0, Object arg1) {}
}

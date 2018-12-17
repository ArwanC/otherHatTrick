import java.util.ArrayList;

public class Carte {
	
    protected String nom;
    
    public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Carte(String nom) {
		this.nom = nom;
	}
	
	public Carte() {}
	
	public ArrayList<Prop> ajouterProps(String s) { //add 1 prop
		ArrayList<Prop> al = new ArrayList<Prop>();
		al.add(new Prop(s));
		return al;
	}
	
	public ArrayList<Prop> ajouterProps(String s, String s2) { // add 2 props aux principaux
		ArrayList<Prop> al = new ArrayList<Prop>();
		al.add(new Prop(s));
		al.add(new Prop(s2));
		return al;
	}
	
}

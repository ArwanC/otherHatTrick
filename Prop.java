import java.util.ArrayList;
import java.util.Collections;

public class Prop extends Carte{
	
    // private String nom;   
    private boolean devoiler;
    
    public Prop() {
    	super();
    }
  
    public Prop(String nom) {
    	super(nom);
		this.nom = nom;
		this.devoiler = false;
	}

	public String getNom() {
        return this.nom;
    }

    public void setNom(final String value) {
        this.nom = value;
    }
    
    public Boolean isDevoiler() {
    	return this.devoiler;
    }
    public void setDevoiler(boolean estDevoile) {
    	this.devoiler = estDevoile;
    }

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		return builder.toString();
	}
    
	private ArrayList<Prop> listProp = new ArrayList<Prop>();
	
	private Prop propCentral = new Prop();
	
	public ArrayList<Prop> creerPropsPrincipaux(ArrayList<Prop> p) {
		p.add(new Prop("The Lettuce"));
		p.add(new Prop("Carrots"));
		p.add(new Prop("Carrots"));
		p.add(new Prop("Carrots"));
		p.add(new Prop("The Rabbit"));
		p.add(new Prop("The Other Rabbit"));
		p.add(new Prop("The Hat"));
		return p;
	}
	
	public ArrayList<Prop> melangerProps(ArrayList<Prop> al) {
		Collections.shuffle(al);
		return al;
	}

	
}

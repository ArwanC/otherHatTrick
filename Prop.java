
public class Prop extends Carte{
	
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
    	
	
}

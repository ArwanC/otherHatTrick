package Modele;


public class Prop {
	
    private String nom;   
    private boolean devoiler;
    
    public Prop() {}
    
    public Prop(String nom) {
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

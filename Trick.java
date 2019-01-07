import java.util.ArrayList;

public class Trick {
	
	String newLine = System.getProperty("line.separator"); // Sous Windows et MacOS le retour � la ligne n'est pas le m�me.
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		builder.append(newLine +"                           ");
		builder.append(propG);
		builder.append("     ");
		builder.append(propD);
		return builder.toString();
	}

	private ArrayList<Prop> propG;
	private ArrayList<Prop> propD;
	
	private String nom;
	private int point;
    private int pointDePenalite;
	
	public Trick(ArrayList<Prop> propG, ArrayList<Prop> propD, String nom, int point, int pointDePenalite) {
		this.propG = propG;
		this.propD = propD;
		this.nom = nom;
		this.point = point;
		this.pointDePenalite = pointDePenalite;
		
	} 
	
	public String getNom() {
        return this.nom;
    }
	public ArrayList<Prop> getPropG() {
		return propG;
	}
	public ArrayList<Prop> getPropD() {
		return propD;
	}
    
	public int getPoint() {
		return point;
	}
}

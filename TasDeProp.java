import java.util.ArrayList;
import java.util.Collections;

public class TasDeProp {
	
	private ArrayList<Prop> listProp = new ArrayList<Prop>();
	
	public TasDeProp() {
			listProp.add(new Prop("The Lettuce"));
			listProp.add(new Prop("Carrots"));
			listProp.add(new Prop("Carrots"));
			listProp.add(new Prop("Carrots"));
			listProp.add(new Prop("The Rabbit"));
			listProp.add(new Prop("The Other Rabbit"));
			listProp.add(new Prop("The Hat"));
	}
	
	private Prop propCentral = new Prop();
	
	public ArrayList<Prop> melangerProps(ArrayList<Prop> al) {
		Collections.shuffle(al);
		return al;
	}
	

}

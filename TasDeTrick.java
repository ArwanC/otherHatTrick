import java.util.Collections;
import java.util.LinkedList;

public class TasDeTrick extends Carte {
	
	private LinkedList<Trick> listTrick;
	
	private Trick trickEnCours;

	
	public TasDeTrick() {
			listTrick = new LinkedList<Trick>();
			listTrick.add(new Trick(ajouterProps("The Rabbit", "The Other Rabbit"), ajouterProps("The Lettuce", "Carrots"),
					"The Hungry Rabbit", 1, 0));
			listTrick.add(new Trick(ajouterProps("Carrots"), ajouterProps("Carrots"), "The Bunch of Carrots", 2, 0));
			listTrick.add(new Trick(ajouterProps("The Rabbit", "The Other Rabbit"), ajouterProps("The Lettuce"),
					"The Rabbit That Didn't Like Carrots", 4, 0));
			listTrick.add(new Trick(ajouterProps("The Rabbit"), ajouterProps("The Other Rabbit"), "The Pair of Rabbits", 5, 0));
			listTrick.add(new Trick(ajouterProps("The Hat"), ajouterProps("Carrots"), "The Carrot Hat Trick", 3, 0));
			listTrick.add(new Trick(ajouterProps("The Hat"), ajouterProps("The Rabbit", "The Other Rabbit"),
					"The Slightly Easier Hat Trick", 4, 0));
			listTrick.add(new Trick(ajouterProps("The Hat"), ajouterProps("The Other Rabbit"), "The Other Hat Trick", 6, -3));
		
	}
	
	public LinkedList<Trick> melangerTricks() {
		Trick theOtherHatTrick = listTrick.getLast();
		listTrick.remove(listTrick.getLast());
		Collections.shuffle(listTrick);
		listTrick.addLast(theOtherHatTrick);
		return listTrick;
	}
	


}

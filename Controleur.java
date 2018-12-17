import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


//int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 100);
// Ci dessus prend un int random entre 0 (inclus) et 100(exclus)

public class Controleur {


	Controleur() {} // PROBLEME SINGLETON A RESOUDRE

	private static Controleur INSTANCE = null;

	public static Controleur getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Controleur();
		}
		return INSTANCE;
	}
	
	private String newLine = System.getProperty("line.separator"); // Sous Windows et MacOS le retour a la ligne n'est pas le meme, use ca, exemple dans les fonctions du bas

	private LinkedList<Joueur> listJoueur = new LinkedList<Joueur>();
		
	private TasDeTrick listTrick = new TasDeTrick();
	
	private TasDeProp listProp = new TasDeProp();
	
	private Strategy difficulte;
	
	
	public void distribuerProps() { // A FAIRE AVEC ITERATOR
		int i, j, k = 0;
		for (i = 0; i < listJoueur.size(); i++) {
			for (j = 0; j < 2; j++) {
				listJoueur.get(i).doubletProp.add(listProp.get(k));
				k++;
			}
		}
		propCentral = listProp.get(k);
	}


	public LinkedList<Joueur> creerJoueurReel(LinkedList<Joueur> lsJoueur) {
		JoueurReel joueur = new JoueurReel();
		lsJoueur.add(joueur);
		return lsJoueur;
	}


	public LinkedList<Joueur> creerJoueurVirtuel(LinkedList<Joueur> lsJoueur, Strategy difficulte) {
		Random r = new Random();
		JoueurVirtuel joueur = new JoueurVirtuel();
		joueur.nom = RandomStringUtils.random(4,"abcdefghijklmnopqrstuvwxyz");
		joueur.age = r.nextInt(100 - 8 + 1) + 8;
		ArrayList<Prop> props = new ArrayList<Prop>();
		joueur.doubletProp = props;
		lsJoueur.add(joueur);
		return lsJoueur;
	}


	public Extension ajouterExtension(ArrayList<Prop> al) {
		Extension extension = new Extension();
		extension.listeProp = creerPropsPrincipaux(al);
		return extension;
	}

	/*
	 * public Strategy choixDifficulte() { //saisir difficulte de jeu
	 * 
	 * }
	 */

	public Variante creerVariante() {
		Variante variante = new Variante();
		return variante;
	}

	
	public int verifierNumJ(int jEnCours) { // Le joueur en cours saisie le num d'un autre joueur, mais interdit de saisir le sien
		int numJ;
		Scanner sc = new Scanner(System.in);
		numJ = sc.nextInt();
		while(numJ==jEnCours | numJ>listJoueur.size() | numJ<0) {
			System.out.println("Mauvaise saisie");
			numJ = sc.nextInt();
		}
		return numJ;
	}

	
	public int verifyInt(int borne1, int borne2) { //verif l'entier entre les deux bornes
		int answer;
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				answer = Integer.parseInt(sc.next());
				sc.nextLine();
				while (answer < borne1 || answer > borne2) {
					System.out.println("Mauvaise saisie");
					answer = Integer.parseInt(sc.next());
					sc.nextLine();
				}
				break;
			} catch (NumberFormatException ignore) {
				System.out.println("Mauvaise saisie");
			}
		}
		return answer;
	}		

	public void determinerOrdreJoueur() { // determine ordre joueur par age et affecte l'ordre de tour
		class PersonComparator implements Comparator<Joueur> {
			public int compare(Joueur a, Joueur b) {
				return a.getAge() - b.getAge();
			}
		}
		Collections.sort(listJoueur, new PersonComparator());
		int i=0;
		for (Iterator<Joueur> itJoueur = listJoueur.iterator(); itJoueur.hasNext();) {
			Joueur j = (Joueur) itJoueur.next();
			j.position=i;
			i++;
		}		
	}


	public void afficherNoms() { // modulaire
		int i;
		System.out.println(newLine+"Les joueurs sont : ");
		for (i = 0; i < listJoueur.size() - 1 ; i++) {
			System.out.print(listJoueur.get(i).nom);
			System.out.print(" - ");
		}
		System.out.print(listJoueur.get(i).nom);
	}
	
	public void afficherNoms(int numJoueur) { // le joueur numJoueur ne sera pas affiche
		int i;
		System.out.println(newLine+"Les joueurs sont : ");
		for (i = 0; i < listJoueur.size() - 1; i++) {
			if(i!=numJoueur) {
				System.out.print(listJoueur.get(i).position+" : ");
				System.out.print(listJoueur.get(i).nom);
				System.out.print(" | ");
			}
		}
		if(i!=numJoueur) {
			System.out.print(listJoueur.get(i).position+" : ");
			System.out.print(listJoueur.get(i).nom);
		}
	}

	public int choisirAction() {
		int reponse;
		Scanner sc = new Scanner(System.in);
		System.out.println(newLine+ newLine+"Que voulez-vous faire :");
		System.out.println("1-Regarder ses Props");
		System.out.println("2-Regarder les Props de tous les joueurs");
		System.out.println("3-Regarder le Trick actuel");
		System.out.println("4-Tenter le Trick");
		System.out.println("5-Passer le Trick");
		System.out.println("6-Quitter la partie");
		reponse = verifyInt(1, 6);
		return reponse;
	}

	
	public void ajoutPts(int joueurEnCours) {
		listJoueur.get(joueurEnCours).setScore(trickEnCours.getPoint() + listJoueur.get(joueurEnCours).score);
	}
	
	public void sleightOfHand(int joueurEnCours) { // A TESTER
		System.out.println(newLine+"0 : "
				+ listJoueur.get(joueurEnCours).doubletProp.get(0).getNom() + " 1 : "
				+ listJoueur.get(joueurEnCours).doubletProp.get(1).getNom()+ " Prop Central : "
				+ propCentral.getNom());
		System.out.println("Voulez �changer un de vos props avec le Prop Central ? 1 : oui   2 : non");
		int i = verifyInt(1,2);
		if(i==1) {
			System.out.println("Lequel ?");
			int e = verifyInt(0,1);
			Prop intermediaire = listJoueur.get(joueurEnCours).doubletProp.get(e);
			listJoueur.get(joueurEnCours).doubletProp.remove(e);
			listJoueur.get(joueurEnCours).doubletProp.add(e, propCentral);
			propCentral=intermediaire;
			for (Iterator<Prop> it = listJoueur.get(joueurEnCours).doubletProp.iterator(); it.hasNext();) {
				//Rend invisible chaque prop
				Prop p =it.next();
				p.setDevoiler(false);
			}
		}
	}
	
	public void sleightOfHandVirtuel(int joueurEnCours) { // A TESTER
		// echange (ou non) un des deux props random avec le propCentral
		System.out.println(newLine+"Le joueur en cours � r�ussi le trick !");
		listJoueur.get(joueurEnCours).setScore(trickEnCours.getPoint() + listJoueur.get(joueurEnCours).score);
		int change =ThreadLocalRandom.current().nextInt(0,2);
		if(change==1) {
			int nbProp = listJoueur.get(joueurEnCours).doubletProp.size();
			int monProp=ThreadLocalRandom.current().nextInt(0, nbProp);
			Prop intermediaire = listJoueur.get(joueurEnCours).doubletProp.get(monProp);
			listJoueur.get(joueurEnCours).doubletProp.remove(monProp);
			listJoueur.get(joueurEnCours).doubletProp.add(monProp, propCentral);
			propCentral=intermediaire;
			for (Iterator<Prop> it = listJoueur.get(joueurEnCours).doubletProp.iterator(); it.hasNext();) {
				//Rend invisible chaque prop
				Prop p =it.next();
				p.setDevoiler(false);
			}
		}
	}
	
	public void echangerPropVirtuel(int joueurActuel) { // echanger prop random pour un jVirtuel
		
		int nbProp = listJoueur.get(joueurActuel).doubletProp.size();
		int nbAdv = listJoueur.size();
		int propAdv=ThreadLocalRandom.current().nextInt(0, nbProp);
		int monProp=ThreadLocalRandom.current().nextInt(0, nbProp);
		int adv = ThreadLocalRandom.current().nextInt(0, nbAdv);
		while(adv==joueurActuel) {
			adv = ThreadLocalRandom.current().nextInt(0, nbAdv);
		}
		Prop intermediaire = listJoueur.get(adv).doubletProp.get(propAdv);
		listJoueur.get(adv).doubletProp.remove(propAdv);
		listJoueur.get(adv).doubletProp.add(propAdv, listJoueur.get(joueurActuel).doubletProp.get(monProp));
		listJoueur.get(joueurActuel).doubletProp.remove(monProp);
		listJoueur.get(joueurActuel).doubletProp.add(monProp, intermediaire);
	}

	public void afficherPropsJoueurs() { // Idem, modulaire a donf !
		
		System.out.println(newLine+newLine+"Les props des joueurs sont : ");
		for (int i = 0; i < listJoueur.size(); i++) {
			System.out.print(listJoueur.get(i).nom);
			System.out.print(" : ");
			for (int j = 0; j < listJoueur.get(i).getDoubletProp().size(); j++) {
				if (listJoueur.get(i).getDoubletProp().get(j).isDevoiler() == true) {
					System.out.print(listJoueur.get(i).getDoubletProp().get(j).getNom()+"   ");
				} else {
					System.out.print("Prop cachee   ");
				}
			}
			System.out.println("");
		}
	}
	
	public void afficherPropsAdv(int numAdv) {
		for (int j = 0; j < listJoueur.get(numAdv).getDoubletProp().size(); j++) {
			if (listJoueur.get(numAdv).getDoubletProp().get(j).isDevoiler() == true) {
				System.out.print(newLine+j+" : "+listJoueur.get(numAdv).getDoubletProp().get(j).getNom());
			} else {
				System.out.print(newLine+j+" : Prop cachee");
			}
		}
	}

	public void afficherSesProps(int leTourDeQui) {
		System.out.print(newLine+"Vos Props sont : ");
		for (int i = 0; i < listJoueur.get(leTourDeQui).doubletProp.size(); i++) {
			System.out.print(listJoueur.get(leTourDeQui).doubletProp.get(i).getNom());
			System.out.print("      ");
		}
	}

	public boolean validiteTrick(int jEnCours, Trick trickEnCours) {
		boolean trickGValide = false;
		boolean trickDValide = false;
		boolean trickTotalValide = false;
		int i, j = 0;
		while (trickTotalValide == false && j < 2) {
			if (j == 0) {
				for (i = 0; i < trickEnCours.getPropG().size(); i++) {
					if (listJoueur.get(jEnCours).doubletProp.get(0).getNom() == (trickEnCours.getPropG().get(i).getNom())) {
						trickGValide = true;
					}
				}
				for (i = 0; i < trickEnCours.getPropD().size(); i++) {
					if (listJoueur.get(jEnCours).doubletProp.get(1).getNom() == (trickEnCours.getPropD().get(i).getNom())) {
						trickDValide = true;
					}
				}
				if (trickDValide == true && trickGValide == true) {
					trickTotalValide = true;
				}
			} else {
				trickGValide = false;
				trickDValide = false;

				for (i = 0; i < trickEnCours.getPropD().size(); i++) {
					if (listJoueur.get(jEnCours).doubletProp.get(0).getNom() == (trickEnCours.getPropD().get(i).getNom())) {
						trickDValide = true;
					}
				}
				for (i = 0; i < trickEnCours.getPropG().size(); i++) {
					if (listJoueur.get(jEnCours).doubletProp.get(1).getNom() == (trickEnCours.getPropG().get(i).getNom())) {
						trickGValide = true;
					}
				}
				if (trickDValide == true && trickGValide == true) {
					trickTotalValide = true;
				}
			}
			j++;
			trickGValide = false;
			trickDValide = false;
		}
		return trickTotalValide;
	}
	
	public void extension1() {
		listProp.add(new Prop("The Meat"));
		listTrick.addFirst(new Trick(ajouterProps("The Meat"), ajouterProps("The Rabbit", "The Other Rabbit"),"The Cannibal Rabbit", 3, 0));
		listTrick.addFirst(new Trick(ajouterProps("The Meat"), ajouterProps("Carrots", "The Lettuce"),"The Good Dish", 3, 0));
	}
	
	public boolean recherche(int[] T,int valeurATrouver) // renvoi true se la valeur est dans le tab
	{
	    for(int i=0;i<T.length;i++){
	    	if(T[i]==valeurATrouver){
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public void revelerProp(int jEnCours){ //Releve un prop 
		int cont=0;
		int[] tab= new int[listJoueur.get(jEnCours).doubletProp.size()+1];
		
		System.out.println(newLine +"Trick failed"+newLine+"Choisissez un Prop � r�v�ler : ");
		for (Iterator<Prop> it = listJoueur.get(jEnCours).doubletProp.iterator(); it.hasNext();) {
			Prop p = it.next();
			if(p.isDevoiler()==false){
				cont++;
				tab[cont]=listJoueur.get(jEnCours).doubletProp.indexOf(p);
				System.out.println(listJoueur.get(jEnCours).doubletProp.indexOf(p)+" : "+p.getNom());
			}
		}
		if(cont==0) {
			System.out.println("Aucun Prop � r�v�ler");
		}else{
			Scanner sc = new Scanner(System.in);
			int i= sc.nextInt();
			while(recherche(tab,i)!=true) {
				System.out.println("Mauvaise Saisie");
				i= sc.nextInt();
				}
			listJoueur.get(jEnCours).doubletProp.get(i).setDevoiler(true);
			}
		}
	
	public void revelerPropVirtuel(int joueurEnCours) {
		int cont=0;
		int[] tab= new int[listJoueur.get(joueurEnCours).doubletProp.size()+1];
		System.out.println(newLine+"Trick failed");
		for (Iterator<Prop> it = listJoueur.get(joueurEnCours).doubletProp.iterator(); it.hasNext();) {
			Prop p = it.next();
			if(p.isDevoiler()==false){
				cont++;
				tab[cont]=listJoueur.get(joueurEnCours).doubletProp.indexOf(p);
				//System.out.println(listJoueur.get(joueurEnCours).doubletProp.indexOf(p)+" : "+p.getNom());
			}
		}
		if(cont==0) {
			System.out.println("Aucun Prop � r�v�ler");
		}else{

			int randomProp = ThreadLocalRandom.current().nextInt(0, listJoueur.get(joueurEnCours).doubletProp.size());
			while(recherche(tab,randomProp)!=true) {
				randomProp = ThreadLocalRandom.current().nextInt(0, listJoueur.get(joueurEnCours).doubletProp.size());	
				}
			listJoueur.get(joueurEnCours).doubletProp.get(randomProp).setDevoiler(true);
			System.out.println(newLine+"Le joueur en cours devoile le prop suivant : "
					+listJoueur.get(joueurEnCours).doubletProp.get(randomProp).getNom());
			}
	}


	public Trick devoilerTrick() { //Pop un trick de la liste et l'affecte a TrickEnCours
		trickEnCours=listTrick.pop();
		return trickEnCours;
	}

	
	public String determinerGagnant(LinkedList<Joueur> ls, int var) {
		for (Iterator<Joueur> itJoueur = ls.iterator(); itJoueur.hasNext();) {
			Joueur j = (Joueur) itJoueur.next();
			System.out.println(newLine+j.getNom()+" a "+j.getScore()+" points");
		}
		if (var == 3) {
			int min = ls.get(ThreadLocalRandom.current().nextInt(0,3)).getScore();
			Joueur gagnant = new Joueur();
			for (Iterator<Joueur> itJoueur = ls.iterator(); itJoueur.hasNext();) {
				Joueur j = (Joueur) itJoueur.next();
				if (min > j.getScore()) {
					gagnant = j;
					min = j.getScore();
				}
				else if(min==j.getScore()) {
					return "Aucun ganant";
				}
			}
			return newLine+"Le gagant est "+gagnant.getNom()+" avec : "+min+" points !";
		}
		else {
		int max = 0;
		Joueur gagnant = new Joueur();
		for (Iterator<Joueur> itJoueur = ls.iterator(); itJoueur.hasNext();) {
			Joueur j = (Joueur) itJoueur.next();
			if (max < j.getScore()) {
				gagnant = j;
				max = j.getScore();
			}
			else if(max==j.getScore()) {
				return "Aucun ganant";
			}
		}
		return "Le gagant est : "+gagnant.getNom()+"avec : "+max+" points !";
		}
	}
	
	
	public void gestionTrickFinal(LinkedList<Joueur> ls, boolean trickFinalReussi) {
		
		if (trickFinalReussi == false) {
			for (Iterator<Joueur> itJoueur = ls.iterator(); itJoueur.hasNext();) {
				Joueur j = (Joueur) itJoueur.next();
				for (Iterator<Prop> itProp = j.doubletProp.iterator(); itProp.hasNext();) {
					Prop p = (Prop) itProp.next();
					if (p.getNom() == "The Other Rabbit" || p.getNom() == "The Hat") {
						j.setScore(j.getScore()-3);
					}
				}
			}
		}
		
	}
	
	public void lancerPartie() {

		// INITIALISATION PARAMETRE DE JEU
		int extension = 0;
		int variante = 0;
		Scanner sc = new Scanner(System.in);
		//System.out.println("Difficulte ? 1 Normal 2 Difficile  : ");
		//System.out.println("Variante   ? 1 Variante(1) 2 Variante(2)   : ");
		System.out.println(newLine+"Int�grer les cartes d'extension ?  1- Oui   2- Non : ");
		extension = verifyInt(1, 2);
		System.out.println(newLine+"Jouer avec une variante ? 1- Oui   2- Non : ");
		variante = verifyInt(1, 2);
		if (variante == 1) {
			System.out.println(newLine+"Choisir une variante : 1- Echange non-obligatoire   2- Joueur ayant le moinms de pts gagne : ");
			variante += verifyInt(1, 2);
		}
		boolean partieFinie = false;
		boolean theOtherHatTrickReussi = false;
		boolean tourFini = false;
		boolean aDejaPasser = false;
		int i, propAdv, monProp,numAdv,fin=-1;

		// INITIALISATION PROPS
		creerPropsPrincipaux(listProp);
		
		// INITIALISATION TRICKS
		creerTricksPrincipaux(listTrick, listProp);
		
		// GESTION EXTENSION ET MELANGE
		if(extension==1) {
			extension1();
		}
		melangerTricks();
		melangerProps(listProp);
		
		// INITIALISATION JOUEURS
		System.out.println(newLine+"Nombre de joueurs reels (Max 3) : ");
		int nbJoueurs = verifyInt(0, 3);
		for (i = 0; i < nbJoueurs; i++) {
			creerJoueurReel(listJoueur);
		}
		for (i = 3 - nbJoueurs; i > 0; i--) {
			creerJoueurVirtuel(listJoueur, difficulte);
		}
		determinerOrdreJoueur();

		// DEBUT JEU
		afficherNoms();
		distribuerProps();
		devoilerTrick();


		while (partieFinie == false) {

			for (Iterator<Joueur> itJoueur = listJoueur.iterator(); itJoueur.hasNext();) {
				
				Joueur joueurEnCours = (Joueur) itJoueur.next();
				tourFini = false;
				aDejaPasser = false;
				System.out.print(newLine+"-----------------------------------------------------------");
				if(fin==joueurEnCours) {
					partieFinie=true;
				}
				/*if(listTrick.isEmpty()==false) {
					devoilerTrick();
				}*/
				if(listTrick.isEmpty()==true && fin==-1) {
					fin=joueurEnCours;
				}

				if (joueurEnCours instanceof JoueurReel && partieFinie==false) {
					
					System.out.print(newLine+"Le Trick en court est :          "+TrickEnCours);
					System.out.print(newLine+"C'est le tour de :  ");
					System.out.print(joueurEnCours.nom);

					while (tourFini == false) {
						switch (choisirAction()){
					
						case 1:
							// Regarder ses props
							afficherSesProps(joueurEnCours);
							break;
						case 2:
							// Regarder les props de tous les joueurs
							afficherPropsJoueurs();
							break;
						case 3:
							// Regarder le trick en cours
							System.out.println(trickEnCours);
							break;
						case 4:
							// Faire un echange puis tenter le trick
							afficherNoms(joueurEnCours);
							if (variante == 2) {
								System.out.println(newLine + newLine+"Voulez-vous faire un enchange ? : 1- Oui   2- Non");
								if (verifyInt(1, 2) == 2) {
									if (validiteTrick(joueurEnCours, trickEnCours)) {
										System.out.println(newLine + newLine + "Bravo ! Trick reussi"+trickEnCours.getPoint()+" points");
										sleightOfHand(joueurEnCours);
										devoilerTrick();
									} else {
										revelerProp(joueurEnCours);
									}
									//enleverTrickDeLaPile();
									tourFini = true;
									break;
								}
							}
							System.out.println(newLine + newLine+"Entrez le numero d'un adversaire :  ");
							numAdv = verifierNumJ(joueurEnCours);
							System.out.println(newLine+"Choisissez quelle Prop vous voulez donner : 0-"
									+ listJoueur.get(joueurEnCours).doubletProp.get(0).getNom() + "  1-"
									+ listJoueur.get(joueurEnCours).doubletProp.get(1).getNom());
							monProp = verifyInt(0, 1);
							System.out.println(newLine+"Choisissez quelle Prop vous voulez prendre :");
							afficherPropsAdv(numAdv);
							propAdv = verifyInt(0, 1);
							listJoueur.get(joueurEnCours).echangerProp(numAdv, joueurEnCours, propAdv, monProp, listJoueur);
							afficherSesProps(joueurEnCours);
							if (validiteTrick(joueurEnCours, trickEnCours) && trickEnCours.getNom()!="The Other Hat Trick") {
								System.out.println(newLine + newLine + "Bravo ! Trick reussi. Vous avez recupere "+trickEnCours.getPoint()+" points");
								sleightOfHand(joueurEnCours);
								devoilerTrick();
							} else if (validiteTrick(joueurEnCours, trickEnCours) == false ){
								revelerProp(joueurEnCours);
							}
							else if(validiteTrick(joueurEnCours, trickEnCours) == true && trickEnCours.getNom()=="The Other Hat Trick"){
								theOtherHatTrickReussi = true;
							}
							tourFini = true;
							//enleverTrickDeLaPile();
							tourFini = true;
							break;
						case 5:
							// Passer le trick
							if (aDejaPasser == true) {
								System.out.print(newLine+newLine+"Vous avez deja passe un trick");
							}else if(listTrick.isEmpty()==true){
								System.out.print(newLine+newLine+"Dernier Trick, impossible de passer");	
							}else {
								devoilerTrick();
								System.out.print(newLine+"Le Trick en court est :          "+trickEnCours);
								aDejaPasser = true;
							}
							break;
						case 6:
							// Quitter la partie
							tourFini = true;
							partieFinie = true;
							joueurEnCours = listJoueur.size();
							break;
						}
					}
				} else if(listJoueur.get(joueurEnCours) instanceof JoueurVirtuel && partieFinie==false) {
					
					System.out.print( newLine+"C'est le tour de : ");
					System.out.print(listJoueur.get(joueurEnCours).nom);
					System.out.print(newLine+"Le Trick en court est :          "+trickEnCours);
					echangerPropVirtuel(joueurEnCours);
					
					if (validiteTrick(joueurEnCours, trickEnCours) == true && trickEnCours.getNom()!="The Other Hat Trick") {
						sleightOfHandVirtuel(joueurEnCours);
						devoilerTrick();
					} else if (validiteTrick(joueurEnCours, trickEnCours) == false ){
						revelerPropVirtuel(joueurEnCours);
					}
					else if(validiteTrick(joueurEnCours, trickEnCours) == true && trickEnCours.getNom()=="The Other Hat Trick"){
						theOtherHatTrickReussi = true;
					}
					tourFini = true;
				}
			}
		}
		gestionTrickFinal(listJoueur, theOtherHatTrickReussi);
		System.out.println(determinerGagnant(listJoueur, variante));
	}	
}

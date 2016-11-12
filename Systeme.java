package Main;


public class Systeme 
{
	private Case[][] grille;
	private Personnage[] collection_personnage;
	private int nb_moussaillon = 3;
	private int nb_perso = nb_moussaillon + 2;
	

	public Systeme()
	{
		grille = new Case[12][12];
		collection_personnage = new Personnage[nb_perso];
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public Case[][] getGrille() {
		return grille;
	}
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	public Personnage[] getCollection_personnage() {
		return collection_personnage;
	}
	public void setCollection_personnage(Personnage[] collection_personnage) {
		this.collection_personnage = collection_personnage;
	}
	
	public int getNb_moussaillon() {
		return nb_moussaillon;
	}
	public void setNb_moussaillon(int nb_moussaillon) {
		this.nb_moussaillon = nb_moussaillon;
	}
	
	public int getNb_perso() {
		return nb_perso;
	}
	public void setNb_perso(int nb_perso) {
		this.nb_perso = nb_perso;
	}

	//----------------------------------------------------------------------------------------------------------------------------------------
	
	//TODO
	//suivant:
	//Rappel: Chacun des moussaillon joue son tour, puis le pirate, puis le fantôme.
	//Le Personnage passé en paramètre (perso) est le personnage qui vient de réaliser son tour de jeu
	//public Personnage suivant()
		
	public void aGagne(Personnage perso)
	{
		System.out.println(perso + "a gagne");
	}
	
	public void finDeTour(Personnage perso)
	{
		suivant(perso).aToiDeJouer();
	}
	
	//TODO
	//public Moussaillon moussaillonPresent(int score){}
	
	//TODO
	//public boolean caseValide(Case case){}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//Main (TEST)
	//----------------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		Systeme systeme = new Systeme();
		
		
	}





	
}

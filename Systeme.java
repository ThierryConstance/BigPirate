
public class Systeme 
{
	private Case[][] grille;
	private Personnage[] collection_personnage;
	private int nb_moussaillon = 3;
	private int nb_perso = nb_moussaillon + 2;
	

//coordoner de la map en bas a gauche case 0,0	
	
	public Systeme()
	{
		grille = new Case[12][12];
		
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				grille[i][j]=new Chemin(i,j);
			}
		}
		

		grille[4][8]=new Grotte(4,8);
		
		grille[1][4]= new CocotierExt(1,4);
		grille[2][4]= new CocotierInter(2,4);
		
		grille[1][9]= new CocotierExt(1,9);
		grille[2][9]= new CocotierInter(2,9);
		
		grille[3][3]= new CocotierExt(3,3);
		grille[4][3]= new CocotierInter(4,3);
		
		grille[5][10]= new CocotierExt(5,10);
		grille[5][9]= new CocotierInter(5,9);
		
		grille[6][5]= new CocotierExt(6, 5);
		grille[6][6]= new CocotierInter(6,6);
		
		grille[8][7]= new CocotierExt(8, 7);
		grille[8][8]= new CocotierInter(8,8);
		
		grille[9][10]= new CocotierExt(9,10);
		grille[9][9]= new CocotierInter(9,9);
		
		for(int i=0;i<12;i++){
			grille[0][i]=new Mer(0,i);
			grille[11][i]=new Mer(11,i);
			grille[i][0]=new Mer(i,0);
			grille[i][11]=new Mer(i,11);
		}
		
		grille[11][0]= new Barque(11,0);
		grille[10][0]= new Barque(10,0);
		grille[11][1]= new Barque(11,1);
		
		
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
		//suivant(perso).aToiDeJouer();
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

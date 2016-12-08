
public class Systeme 
{
	private static Case[][] grille;
	private Personnage[] collection_personnage;
	private int nb_moussaillon = 3;
	private int nb_perso = nb_moussaillon + 2;
	private int suivant = 2; //indique à qui est le tour de jeu
	private IHM ihm;
	

//coordoner de la map en bas a gauche case 0,0	
	
	public Systeme()
	{
		
		this.initGrille();
		
		collection_personnage = new Personnage[nb_perso];
		collection_personnage[0]=new Pirate();
		collection_personnage[1]=new Fantome();
		
		for(int i = 0; i < nb_moussaillon; i++)
		{
			collection_personnage[2+i] = new Moussaillon(nb_moussaillon);
		}
		
		this.miseEnPlace(this.grille);
		
		//Annonce que c'est au tour du premier moussaillon de jouer
		collection_personnage[this.suivant].aToiDeJouer();
		
		ihm=new IHM(this);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public static Case[][] getGrille() {
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

	
	// Initialisation de la grille
	public void initGrille()
	{
		grille = new Case[12][12];
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				grille[i][j]=new Chemin(i,j);
			}
		}
		for(int i=2;i<6;i++){
			grille[2][i]= new Jungle(2,i);
			grille[4][i]= new Jungle(4,i);
			grille[5][i]= new Jungle(5,i);
			grille[9][i]= new Jungle(9,i);
		}
		for(int i=0;i<3;i++){
			grille[2][i+7]= new Jungle(2,i+7);
			grille[7][i+2]= new Jungle(7,i+2);
			grille[i+7][8]= new Jungle(i+7,8);
			grille[i+7][9]= new Jungle(i+7,9);
		}
		grille[3][9]= new Jungle(3,9);
		grille[4][7]= new Jungle(4,7);
		grille[5][8]= new Jungle(5,8);
		grille[7][6]= new Jungle(7,6);
		grille[9][7]= new Jungle(9,7);

		grille[4][8]=new Grotte(4,8);
		
		grille[2][4]= new CocotierInter(2,4);
		grille[1][4]= new CocotierExt(1,4,grille[2][4]);
		
		grille[2][9]= new CocotierInter(2,9);
		grille[1][9]= new CocotierExt(1,9,grille[2][9]);
		
		grille[4][3]= new CocotierInter(4,3);
		grille[3][3]= new CocotierExt(3,3,grille[4][3]);

		grille[5][9]= new CocotierInter(5,9);
		grille[5][10]= new CocotierExt(5,10,grille[5][9]);
		
		grille[6][6]= new CocotierInter(6,6);
		grille[6][5]= new CocotierExt(6, 5,grille[6][6]);
		
		grille[8][8]= new CocotierInter(8,8);
		grille[8][7]= new CocotierExt(8, 7,grille[8][8]);
		
		grille[9][9]= new CocotierInter(9,9);
		grille[9][10]= new CocotierExt(9,10,grille[9][9]);

		
		for(int i=0;i<12;i++){
			grille[0][i]=new Mer(0,i);
			grille[11][i]=new Mer(11,i);
			grille[i][0]=new Mer(i,0);
			grille[i][11]=new Mer(i,11);
		}
		
		grille[11][0]= new Barque(11,0);
		grille[10][0]= new Barque(10,0);
		grille[11][1]= new Barque(11,1);
	}
	
	
	//Mise en place des personnages
	public void miseEnPlace(Case[][] g)
	{
		//Mise en place du pirate  
		g[4][8].addPersonnage(collection_personnage[0]);
		//Mise en place du fantôme
		g[10][10].addPersonnage(collection_personnage[1]);
		for (int i = 0; i< this.nb_moussaillon; i++)
		{
			//Ajout des trésorts dans la grotte 
			grille[4][8].addTresor(new Tresor());
			//Ajout des moussaillon dans la barque
			if(i == 0)
			{
				grille[10][0].addPersonnage(collection_personnage[2]);
			}
			if(i == 1)
			{
				grille[11][1].addPersonnage(collection_personnage[3]);
			}
			if(i == 2)
			{
				grille[11][0].addPersonnage(collection_personnage[4]);
			}
		}
	}
	
		
	public void aGagne(Personnage perso)
	{
		System.out.println(perso + "a gagne");
	}
	
	
	//Rappel: Chacun des moussaillon joue son tour, puis le pirate, puis le fantôme.
	//Le Personnage passé en paramètre (perso) est le personnage qui vient de réaliser son tour de jeu
	//public Personnage suivant()
	public void finDeTour()
	{
		this.suivant ++;
		if(this.suivant == this.nb_perso)	this.suivant = 0;	
		collection_personnage[this.suivant].aToiDeJouer();
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

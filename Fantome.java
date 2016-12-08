

public class Fantome extends Personnage {
	private Case[][] zone_de_deplacement;
	private int nb_deplacement_fantome;
	
	public Fantome()
	{
		de = new Des3();
		path ="src/fantome.png";
		zone_de_deplacement = new Case[7][7];
	}

	//------------------------------------------------------------------------------------------------------------------
	//GET and SET 
	//------------------------------------------------------------------------------------------------------------------
	public Case[][] getZone_de_deplacement() {
		return zone_de_deplacement;
	}

	public void setZone_de_deplacement(Case[][] zone_de_deplacement) {
		this.zone_de_deplacement = zone_de_deplacement;
	}
	
	public int getNb_deplacement_fantome() {
		return nb_deplacement_fantome;
	}

	public void setNb_deplacement_fantome(int nb_deplacement_fantome) {
		this.nb_deplacement_fantome = nb_deplacement_fantome;
	}
	
	//Mise à jour du nombre de déplacement du fantôme
	public void majNbDeplacement(Case futur_case)
	{
		int pos_x = this.getPosition().getX();
		int pos_y = this.getPosition().getY();
		int futur_pos_x = futur_case.getX();
		int futur_pos_y = futur_case.getY();
		int new_deplacement = this.getNb_deplacement_fantome() - ( Math.abs(futur_pos_x - pos_x) + Math.abs(futur_pos_y - pos_y) );
		this.setNb_deplacement_fantome(new_deplacement);
	}
	
	//------------------------------------------------------------------------------------------------------------------
	//Zone de déplacement du fantôme
	//------------------------------------------------------------------------------------------------------------------
	//TODO: zoneDeplacement
	public  void zoneDeplacement()
	{
		this.setNb_deplacement_fantome( de.lancerDe() );
		this.initZoneDeplacement();
		
		//Coordonées du centre de la zone de déplacement du fantôme
		int x_centre = 3;
		int y_centre = 3;
		
		//Coordonnée du fantôme sur la carte 
		int pos_x_fantome = this.getPosition().getX();
		int pos_y_fantome = this.getPosition().getY();
		
		this.deplacementScore1(x_centre, y_centre, pos_x_fantome, pos_y_fantome);
		
		if (getNb_deplacement_fantome() >= 2 )
		{
			this.deplacementScore2(x_centre, y_centre, pos_x_fantome, pos_y_fantome);
		}
		
		if (getNb_deplacement_fantome() == 3)
		{
			this.deplacementScore3(x_centre, y_centre, pos_x_fantome, pos_y_fantome);
		}	
	}
	
	//------------------------------------------------------------------------------------------------------------------
	//Initialisation de la zone de déplacement du fantôme
	//------------------------------------------------------------------------------------------------------------------
	public void initZoneDeplacement()
	{
		//intialisation du tableau à null dans chaque case
		for (int i = 0;i < 7; i++)
		{
			for (int j = 0; i < 4; i++)
			{
				zone_de_deplacement[i][j] = null;
			}
		}	
		// On place le fantôme au centre du tableau
		this.zone_de_deplacement[3][3] = this.getPosition();
	}
	
	//------------------------------------------------------------------------------------------------------------------
	//Déplacements possible du fantôme en fonction du score du dé
	//------------------------------------------------------------------------------------------------------------------
	//Déplacement pour un score de dé de 1
	public void deplacementScore1(int x, int y, int pos_x, int pos_y)
	{
		if (pos_x - 1 >= 0) this.zone_de_deplacement[x - 1][y] = Systeme.getGrille()[pos_x - 1][pos_y];
		if (pos_x + 1 <= 11) this.zone_de_deplacement[x + 1][y] = Systeme.getGrille()[pos_x + 1][pos_y];
		if (pos_y + 1 <= 11) this.zone_de_deplacement[x][y + 1] = Systeme.getGrille()[pos_x][pos_y + 1];
		if (pos_y - 1 >= 0) this.zone_de_deplacement[x][y - 1] = Systeme.getGrille()[pos_x][pos_y - 1];	
	}
	
	
	//Déplacement pour un score de dé de 2 (doit être ajouté au déplacement pour un score de dé de 1)
	public void deplacementScore2(int x, int y, int pos_x, int pos_y)
	{
		if (pos_x - 2 >= 0) this.zone_de_deplacement[x - 2][y] = Systeme.getGrille()[pos_x - 2][pos_y];
		if (pos_x + 2 <= 11) this.zone_de_deplacement[x + 2][y] = Systeme.getGrille()[pos_x + 2][pos_y];
		
		if (pos_x - 1 >= 0)
		{
			if (pos_y + 1 <= 11) this.zone_de_deplacement[x - 1][y + 1] = Systeme.getGrille()[pos_x - 1][pos_y + 1];
			if (pos_y - 1 >= 0) this.zone_de_deplacement[x - 1][y - 1] = Systeme.getGrille()[pos_x - 1][pos_y - 1];
		}
		
		if (pos_x + 1 <= 11)
		{
			if (pos_y + 1 <= 11) this.zone_de_deplacement[x + 1][y + 1] = Systeme.getGrille()[pos_x + 1][pos_y + 1];
			if (pos_y - 1 >= 0) this.zone_de_deplacement[x + 1][y - 1] = Systeme.getGrille()[pos_x + 1][pos_y - 1];
		}
		
		if (pos_y - 2 >= 0) this.zone_de_deplacement[x][y + 2] = Systeme.getGrille()[pos_x][pos_y + 2];
		if (pos_y + 2 <= 11)this.zone_de_deplacement[x][y - 2] = Systeme.getGrille()[pos_x][pos_y - 2];
	}
	
	
	//Déplacement pour un score de dé de 3 (doit être ajouté au déplacement pour un score de dé de 1 et de 2)
	public void deplacementScore3(int x, int y, int pos_x, int pos_y)
	{
		if (pos_x - 3 >= 0) this.zone_de_deplacement[x - 3][y] = Systeme.getGrille()[pos_x - 3][pos_y];
		if (pos_x + 3 <= 11) this.zone_de_deplacement[x + 3][y] = Systeme.getGrille()[pos_x + 3][pos_y];
		
		if (pos_x - 2 >= 0)
		{
			if (pos_y + 1 <= 11) this.zone_de_deplacement[x - 2][y + 1] = Systeme.getGrille()[pos_x - 2][pos_y + 1];
			if (pos_y - 1 >= 0) this.zone_de_deplacement[x - 2][y - 1] = Systeme.getGrille()[pos_x - 2][pos_y - 1];
		}
		
		if (pos_x + 2 <= 11)
		{
			if (pos_y + 1 <= 11) this.zone_de_deplacement[x + 2][y + 1] = Systeme.getGrille()[pos_x + 2][pos_y + 1];
			if (pos_y - 1 >= 0) this.zone_de_deplacement[x + 2][y - 1] = Systeme.getGrille()[pos_x + 2][pos_y - 1];
		}
		
		if (pos_x - 1 >= 0)
		{
			if (pos_y + 2 <= 11) this.zone_de_deplacement[x - 1][y + 2] = Systeme.getGrille()[pos_x - 1][pos_y + 2];
			if (pos_y - 2 >= 0) this.zone_de_deplacement[x - 1][y - 2] = Systeme.getGrille()[pos_x - 1][pos_y - 2];
		}
		
		if (pos_x + 1 <= 11)
		{
			if (pos_y + 2 <= 11) this.zone_de_deplacement[x + 1][y + 2] = Systeme.getGrille()[pos_x + 1][pos_y + 2];
			if (pos_y - 2 >= 0) this.zone_de_deplacement[x + 1][y - 2] = Systeme.getGrille()[pos_x + 1][pos_y - 2];
		}

		if (pos_y + 3 <= 11)this.zone_de_deplacement[x][y + 3] = Systeme.getGrille()[pos_x][pos_y + 3];
		if (pos_y - 3 >= 0) this.zone_de_deplacement[x][y - 3] = Systeme.getGrille()[pos_x][pos_y - 3];
	}

	//------------------------------------------------------------------------------------------------------------------
	//Recherche d'un moussaillon dans la zone de déplacement
	//------------------------------------------------------------------------------------------------------------------
	public void rechercheMoussaillon()
	{
		//Parcourt de la zone de déplacement du fantôme
		int i = 0;
		int j = 0;
		Moussaillon moussaillon_victime = null;
		//Tant que l'on n'a pas trouvé de moussaillon on parcourt la zone de déplacement
		while((i < 7) && (moussaillon_victime == null))
		{
			while((j < 7) && (moussaillon_victime == null))
			{
				//On ne s'interresse que au cases "pleines" du tableau et celles ou n'est pas le fantôme
				if ((this.zone_de_deplacement[i][j] != null) && (this.zone_de_deplacement[i][j] != this.getPosition()) )
				{
					moussaillon_victime = this.zone_de_deplacement[i][j].moussaillonPresent();
					//Si un moussaillon est présent sur la case
					if (moussaillon_victime != null)
					{
						this.majNbDeplacement(moussaillon_victime.getPosition());
						moussaillon_victime.poursuit();
					}
				}
				j++;
			}
			i++;
		}
		//TODO: si  il lui reste un deplacement possible il l'effectue
		if(this.getNb_deplacement_fantome() > 0) this.seDeplaceAleatoirement();
		}

	private void seDeplaceAleatoirement() {
		// TODO Auto-generated method stub
		
	}


	
}

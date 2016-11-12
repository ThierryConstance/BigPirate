package Main;


import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class IHM extends JFrame{
	static int n=12;
	private JLabel grille[][];
	
	public IHM(Systeme syst){
		super("BigPirate");
		this.setSize(500,500);
		this.setLayout(new GridLayout(n,n));

		this.grille=new JLabel[n][n];
		for(int i=0;i<n;i++){
			grille[i]=new JLabel[n];
			for(int j=0;j<n;j++){
				grille[i][j]=new JLabel(syst.getGrille[i][j].toString());
				this.getContentPane().add(grille[i][j]);
			}
		}
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Systeme syst=new Systeme();
		JFrame fenetre = new IHM(syst);
	}
	
}

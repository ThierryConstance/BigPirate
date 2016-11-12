
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IHM extends JFrame{
	static int n=12;
	private JLabel grille[][];
	
	public IHM(Systeme syst){
		super("BigPirate");
		this.setSize(n*45,n*45);
		this.setLayout(new GridLayout(n,n));
		
		this.grille=new JLabel[n][n];
		for(int i=n-1;i>-1;i--){
			grille[i]=new JLabel[n];
			for(int j=0;j<n;j++){				
				grille[j][i]=new JLabel(new ImageIcon(syst.getGrille()[j][i].getPath()));
				this.getContentPane().add(grille[j][i]);
				
			}
		}
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Systeme syst=new Systeme();
		JFrame fenetre = new IHM(syst);
	}
	
}

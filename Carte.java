import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Carte extends JPanel {
	
	private int n=12;
	
	
	public Carte(Systeme syst){
		this.setLayout(new GridLayout(n,n));
		
		JLabel tmp;
		
		for(int i=n-1;i>-1;i--){
			for(int j=0;j<n;j++){
				if(syst.getGrille()[j][i].getEquipage().isEmpty() && syst.getGrille()[j][i].getEquipage().isEmpty()){
					tmp=new JLabel(new ImageIcon(syst.getGrille()[j][i].getPath()));
				}
				else{
					if(syst.getGrille()[j][i].getEquipage().isEmpty()){
						tmp=new JLabel(new ImageIcon(fusion(syst.getGrille()[j][i].getPath(),syst.getGrille()[j][i].tresorPresent().getPath())));
					}
					else{
						tmp=new JLabel(new ImageIcon(fusion(syst.getGrille()[j][i].getPath(),syst.getGrille()[j][i].personnagePresent().getPath())));
					}
				}
				this.add(tmp);
				}
			}
		//this.setSize(new Dimension(n*40,n*40));
	}
	
	public Image fusion(String path1, String path2){
		BufferedImage image1 = null,image2 = null;
		try {
			image1 = ImageIO.read(new File(path1));
			image2 = ImageIO.read(new File(path2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2d = image1.createGraphics(); 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		                RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
		                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); 
	  
		g2d.drawImage(image2, 0, 0, null); 
	  
		g2d.dispose(); 
		
		return image1 ; 
	}
}

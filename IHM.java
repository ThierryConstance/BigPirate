
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IHM extends JFrame{
	static int n=12;
	
	public IHM(Systeme syst){
		super("BigPirate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600,600));
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(new Carte(syst),BorderLayout.CENTER);
				
		
		JPanel bottom=new JPanel(new BorderLayout());
		JPanel direction =new JPanel(new BorderLayout());
		JPanel menu=new JPanel(new BorderLayout());
		
		JLabel text =new JLabel("Menu info & kotopo kotopo");
		
		menu.add(text, BorderLayout.CENTER);
		
		JButton haut=new JButton("Haut"),bas=new JButton("Bas"),droite=new JButton("Droite"),gauche=new JButton("Gauche");
		
		direction.add(droite, BorderLayout.EAST);
		direction.add(gauche, BorderLayout.WEST);
		direction.add(bas, BorderLayout.SOUTH);
		direction.add(haut, BorderLayout.NORTH);
		
		bottom.add(direction, BorderLayout.WEST);
		bottom.add(menu, BorderLayout.EAST);
		
		gauche.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    			}
	    		}		
	    	);
		droite.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    			}
	    		}		
	    	);
		bas.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    			}
	    		}		
	    	);
		haut.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    			}
	    		}		
	    	);
		
		
		
		this.getContentPane().add(bottom,BorderLayout.SOUTH);		
		this.setVisible(true);
	}
	
	

	
}

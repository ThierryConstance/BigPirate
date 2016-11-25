
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
		final JPanel menu=new JPanel(new CardLayout());
		JPanel de=new JPanel(new BorderLayout());
		JButton finDuTour=new JButton("Fin du tour");
		
		JPanel menuMoussaillon=new JPanel(new GridLayout(1,2));
		JPanel menuPirate=new JPanel();
		
		
		JLabel text =new JLabel("Menu info & kotopo kotopo");

		JPanel carteCocotier= new JPanel(new BorderLayout());
		carteCocotier.add(new JButton("Cocotier"),BorderLayout.NORTH);
		carteCocotier.add(new JLabel("3"),BorderLayout.CENTER);
		menuMoussaillon.add(carteCocotier);

		JPanel cartePerroquet= new JPanel(new BorderLayout());
		cartePerroquet.add(new JButton("Perroquet"),BorderLayout.NORTH);
		cartePerroquet.add(new JLabel("4"),BorderLayout.CENTER);
		menuMoussaillon.add(cartePerroquet);
		
		JButton lancerDe=new JButton("Lance le dé!");
		de.add(lancerDe,BorderLayout.NORTH);
		final JLabel resultDe=new JLabel("En attente du résultat");
		de.add(resultDe,BorderLayout.CENTER);
		
		menuPirate.add(new JLabel("Menu Pirate"));
		
		menu.add(menuMoussaillon, "Menu Moussaillon");
		menu.add(menuPirate, "Menu Pirate");
		
		JButton haut=new JButton("Haut"),bas=new JButton("Bas"),droite=new JButton("Droite"),gauche=new JButton("Gauche");
		
		direction.add(droite, BorderLayout.EAST);
		direction.add(gauche, BorderLayout.WEST);
		direction.add(bas, BorderLayout.SOUTH);
		direction.add(haut, BorderLayout.NORTH);
		
		bottom.add(direction, BorderLayout.WEST);
		bottom.add(menu, BorderLayout.EAST);
		bottom.add(de,BorderLayout.CENTER);
		bottom.add(finDuTour,BorderLayout.SOUTH);
		
		gauche.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				CardLayout cl = (CardLayout)(menu.getLayout());
	    				cl.next(menu);
	    			}
	    		}		
	    	);
		droite.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				CardLayout cl = (CardLayout)(menu.getLayout());
	    				cl.first(menu);
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

		lancerDe.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				Integer res=new Des6().lancerDe();
	    				resultDe.setText(res.toString());
	    			}
	    		}		
	    	);
		
		
		
		
		this.getContentPane().add(bottom,BorderLayout.SOUTH);		
		this.setVisible(true);
	}
	
	

	
}

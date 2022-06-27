import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {
		
		JPanel 			panneauSud;
		JPanel panneauBouton;
		PanneauImages 	pims;
		VueNBCoups 			nbCoups;
		VueNBPaires		 	nbPaires;
		Border 			compound;
		JButton boutonRejouer;
		JButton boutonSortir;
		



		/**********************************
		* Cr�ation des bords des composants
		***********************************/
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			
		
		Model model = new Model();
		Controler controler = new Controler(model);


		/********************************************************************
		* Le JPanel panneauSud du Sud qui s'ouvre � l'ouverture du jeu
		********************************************************************/
		panneauSud= new JPanel(new GridLayout(3,1));
		
		nbCoups=new VueNBCoups("Nombre de coups joués : 0 ",JLabel.CENTER);
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauSud.add(nbCoups);
	
		nbPaires=new VueNBPaires("Nombre de paires découvertes :  0 ",JLabel.CENTER);
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauSud.add(nbPaires);
		
		
		pims= new PanneauImages(model);
	
		pims.setPreferredSize(new Dimension(605,485));
		pims.setBorder(compound);
		pims.addMouseListener(controler);

		model.addObserver(pims);
		model.addObserver(nbCoups);
		model.addObserver(nbPaires);

		panneauBouton= new JPanel();
		boutonRejouer = new JButton("Rejouer");
		boutonSortir = new JButton("Sortir");
		ControlerBouton boutonControle = new ControlerBouton(model, boutonRejouer, boutonSortir);
		boutonRejouer.addActionListener(boutonControle);
		boutonSortir.addActionListener(boutonControle);
		panneauBouton.add(boutonRejouer);
		panneauBouton.add(boutonSortir);

		panneauSud.add(panneauBouton);
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.getContentPane().add(pims,BorderLayout.CENTER);
		frame.getContentPane().add(panneauSud,BorderLayout.SOUTH);
		  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}


import java.awt.*;      
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.Observable;
import java.util.Observer;


public class PanneauImages extends JPanel implements Observer {  
	private Image fond, im[];	// contient les objets Images correspondants aux fichiers des images
	private Model model;

	public PanneauImages(Model model){
		super();
		this.model = model;
		this.im= new Image[10];
		try{
			fond=ImageIO.read(new File("images/fond.png"));
			for(int i=0;i<10;i++){
				im[i]=ImageIO.read(new File("images/im"+i+".png"));
			}
		}catch(IOException e){System.out.println("PB chargement fichiers images "+e);};
	}
	
	
	/*
	 * Methode appelee automatiquement a la construction du JPanel
	 * pour l'appeler dans une autre methode, utiliser la methode repaint() 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);			
		setBackground(Color.white);
		int x=5,y=5; //coordonnees des positions ou les images doivent etre dessinees
		int[] ordre = model.getOrdre();
		boolean[] visible = model.getVisible();
		// Affiche l'image fond dans chaque zone
		// --> a faire evoluer ensuite pour faire apparaitre les images de im dans les bonnes zones
		for(int i=0;i<20;i++){
			if(visible[i])
			{
				g.drawImage(im[ordre[i]-1],x,y,this);
			}
			else{
				g.drawImage(fond,x,y,this); //Dessine l'image fond a la position (x,y)
			}
			x+=120;
			if(x==605){
				x=5;y+=120;
			}
		}	
  	}


	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		if(this.model.equals(model))
		{
			repaint();
		}
	}

}
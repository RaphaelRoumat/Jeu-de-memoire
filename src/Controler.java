import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controler implements MouseListener{

    private Model model;

    public Controler(Model model)
    {
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) { 

    }

    @Override
    public void mousePressed(MouseEvent e) {      
        int x = e.getX();
        int y = e.getY();

        x = (x - 5) / 120;
		y = (y - 5) / 120;

        int num_image = x + y * 5;

        model.modifier(num_image);

    }

    @Override
    public void mouseReleased(MouseEvent e) {        
    }

    @Override
    public void mouseEntered(MouseEvent e) {        
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }
    
}

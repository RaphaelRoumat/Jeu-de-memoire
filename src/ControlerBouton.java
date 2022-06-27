import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;


public class ControlerBouton implements ActionListener{
    private Model model;
    private JButton rejouer, sortir;

    public ControlerBouton(Model model, JButton rejouer, JButton sortir)
    {
        this.model = model;
        this.rejouer = rejouer;
        this.sortir = sortir;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if( button.equals(rejouer))
        {
            model.init();
        }
        else if(button.equals(sortir))
        {
            System.exit(0);
        }
    }
    
}

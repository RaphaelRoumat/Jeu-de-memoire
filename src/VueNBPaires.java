
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class VueNBPaires extends JLabel implements Observer
{
    VueNBPaires(String text, int arg)
    {
        super(text, arg);
    }

    public void update(Observable o, Object arg) {
        Model model = (Model) o;
        setText("Nombre de paires découvertes : " + model.getNbPaires());
    }
}

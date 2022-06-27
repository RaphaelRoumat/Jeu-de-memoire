
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class VueNBCoups extends JLabel implements Observer
{
    VueNBCoups(String text, int arg)
    {
        super(text, arg);
    }

    public void update(Observable o, Object arg) {
        Model model = (Model) o;
        setText("Nombre de coups joués : " + model.getNbCoups());
    }
}

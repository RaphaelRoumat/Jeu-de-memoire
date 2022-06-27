import java.util.Observable;
import java.util.Observer;

public class Model  extends Observable{
    private int[] ordre;
    private boolean[] visible;
    private int nbPaires;
    private int nbCoups;
    private int numZoneIm1;
    private int numZoneIm2;
    private int numclic;

    public Model()
    {
        init();
    }

    public void init()
    {
        ordre = new int[20];
        visible = new boolean[20];
        nbPaires = 0;
        nbCoups = 0;
        numZoneIm1 = 0;
        numZoneIm2 = 0;
        numclic = 1;

        int[] possibles = {1, 1 , 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        int max_tab = possibles.length - 1;

        for(int i = 0; i < 20; i++)
        {
            int random = (int)(Math.random() * (max_tab + 1));
            ordre[i] = possibles[random];

            possibles[random] = possibles[max_tab];
            max_tab --;

        }

        for (int i = 0; i < visible.length; i++) {
            visible[i] = false;
        }

        setChanged();
        notifyObservers();
    }

    public void modifier(int image_num)
    {
        if(visible[image_num] == false)
        {
            nbCoups ++;
            if(numclic == 1)
            {
                if(ordre[numZoneIm1] != ordre[numZoneIm2])
                {
                    visible[numZoneIm1] = false;
                    visible[numZoneIm2] = false;
                }

                numZoneIm1 = image_num;

                visible[numZoneIm1] = true;

                numclic = 2;
            }
            else
            {
                numZoneIm2 = image_num;
                visible[numZoneIm2] = true;

                if(ordre[numZoneIm1] == ordre[numZoneIm2])
                {
                    nbPaires ++;
                }
                numclic = 1;
            }

            setChanged();
            notifyObservers();
        }
    }


    public int[] getOrdre() {
        return this.ordre;
    }

    public boolean[] getVisible() {
        return this.visible;
    }

    public int getNbPaires() {
        return this.nbPaires;
    }

    public int getNbCoups() {
        return this.nbCoups;
    }
    


}

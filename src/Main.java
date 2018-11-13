import Model.*;
import Controller.*;
import View.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<AbstractController> controllers = new ArrayList<>();

        AbstractModel pendu = new Pendu();
        AbstractController penduController = new PenduController(pendu);
        controllers.add(penduController);

        //On lance l'Acceuil
        Accueil menu = new Accueil(controllers);
    }
}

import Model.*;
import Controller.*;
import View.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Pendu pendu = new Pendu();
        PenduController penduController = new PenduController(pendu);

        //On lance l'Acceuil
        Accueil menu = new Accueil(penduController);
    }
}

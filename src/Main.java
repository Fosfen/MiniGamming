import Model.Mots;
import Model.Pendu;
import View.MenuFrame;

public class Main
{
    public static void main(String[] args)
    {
        //MenuFrame menu = new MenuFrame();
        Pendu pendu = new Pendu();
        System.out.println(pendu.getReponse());
    }
}

package View.JeuView;

import Controller.AbstractController;
import Controller.PenduController;
import Model.Pendu;
import View.JStatic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Duthoit Raphael, Delhalle Sebastien
 * Classe permettant de générer un pendu jouable.
 */
public class JPendu extends JeuView
{
    private Pendu pendu;
    private AbstractController penduController = new PenduController(pendu);
    private JMot lemotatrouver;

    /**
     * Constructeur JPendu
     */
    public JPendu()
    {
        // TODO Seb : Retirer la version test et la remplacer par la version finale du MVC
        pendu = new Pendu();
        lemotatrouver = new JMot(pendu.getReponse().length);                          //On génère le mot à trouver
        setLayout(new BorderLayout());                                                //Layout du pendu
        setBackground(JStatic.BackgroundColor);                                       //On ajoute la couleur statique de fond
        add(lemotatrouver, BorderLayout.NORTH);                                       //On ajoute le mot au nord du pendu

        // TODO Seb : retirer en mode graphique
        JButton jouer = new JButton("JOUER A LA VERSION CONSOLE");               //On donne une possibilité de jeu console en bas dans un bouton
        jouer.addActionListener(arg0 -> lancerPartie());                              //Listener du bouton version console
        add(jouer,BorderLayout.SOUTH);                                                //On ajoute le bouton au sud du pendu
    }

    /**
     * Méthode pour lancer la version console
     */
    public void lancerPartie()
    {
        this.pendu.lancerPartie();
    }

    @Override
    public void update()
    {
        // TODO update la vue en fonction du modèle
    }
}


   /**
    * Classe JMot permettant la gestion du mot du pendu
    */
class JMot extends JPanel {

    ArrayList<JLabel> leslettres;                                          //Liste qui va contenir les lettres du mot

    public JMot(int longeur){
            leslettres=new ArrayList<>();
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(JStatic.CouleurMotATrouver);
        for(int i=1 ; i<=longeur ; i++) {                                                       //boucle qui va remplir la liste de _ pour chaque lettre du mot
            JLabel unknown = new JLabel("_"); //lettre non trouvée
            this.leslettres.add(unknown);
            unknown.setFont(new Font("Andika Basic", Font.BOLD, 70));
        }
        this.afficher(this.leslettres);                                                        //Appel à la méthode d'affichage
        addLettre('C',new int[]{0,2,4});                                                //Test d'ajout de 3 lettres
    }

    /**
     * Méthode permettant d'afficher le contenu de la liste à l'écran
     */
    public void afficher(ArrayList<JLabel> liste){
        for(int i=0 ; i<liste.size() ; i++){
            add(liste.get(i));
        }
    }

    /**
     * Méthode permettant d'ajouter un charactère à toutes les positions définies dans un tableau d'entier
     */
    public void addLettre(char lettre, int[] positions){
        for(int i=0 ; i<positions.length ; i++) {
            JLabel label = new JLabel(String.valueOf(lettre));
            label.setFont(new Font("Andika Basic", Font.BOLD,70));
            this.leslettres.get(positions[i]).setText(label.getText());                          //on modifie le texte a la position du tableau passé en paramètres
            this.afficher(leslettres);                                                           //on réaffiche
        }
    }
}

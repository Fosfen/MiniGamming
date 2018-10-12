package View;

import Observer.Observable;

import javax.swing.*;

public abstract class LayoutMenu extends JFrame implements Observable
{
    JPanel actual; //JPanel correspondant à la fenêtre chargée actuelle sur le layout
    JPanel old;    //JPanel correspondant à la fenêtre chargée avant la fenêtre actuelle


}

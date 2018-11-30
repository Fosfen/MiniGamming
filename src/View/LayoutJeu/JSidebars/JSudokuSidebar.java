package View.LayoutJeu.JSidebars;

import Controller.SudokuController;
import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JSudokuSidebar extends JSidebarJeu
{
    JTextField x;
    JTextField y;
    JTextField val;
    JButton validate;

    public JSudokuSidebar(LayoutJeu layout)
    {
        super(layout);
        Font f = new Font("Andika basic", Font.BOLD, 36);

        JLabel xlabel = new JLabel("X");
        x = new JTextField();
        x.setToolTipText("X");
        x.setPreferredSize(new Dimension(50,50));
        xlabel.setFont(f);

        JLabel ylabel = new JLabel("Y");
        y = new JTextField();
        y.setToolTipText("Y");
        y.setPreferredSize(new Dimension(50,50));
        ylabel.setFont(f);

        JLabel vlabel = new JLabel("VALEUR");
        val = new JTextField();
        val.setToolTipText("val");
        val.setPreferredSize(new Dimension(50,50));
        vlabel.setFont(f);

        setLayout(new GridLayout(0,1));
        setBackground(JStatic.HelpFrameBackgroundColor);

        add(xlabel);
        add(x);
        add(ylabel);
        add(y);
        add(vlabel);
        add(val);

        validate = new JButton("Inserer valeur");
        validate.addActionListener(arg0 -> {
            try {
                ((SudokuController) this.layout.getController()).getModel().jouerTour(x.getText(),y.getText(),val.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        add(validate);

    }


}

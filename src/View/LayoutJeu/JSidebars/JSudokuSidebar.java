package View.LayoutJeu.JSidebars;

import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;

public class JSudokuSidebar extends JPanel
{
    LayoutJeu layout;

    public JSudokuSidebar()
    {
        this.layout = layout;

        setLayout(new GridLayout(13,2));
        setBackground(JStatic.HelpFrameBackgroundColor);

        JButton one = new JButton("1");
        one.addActionListener(arg0 -> Action());
        JButton two = new JButton("2");
        two.addActionListener(arg0 -> Action());
        JButton three = new JButton("3");
        three.addActionListener(arg0 -> Action());
        JButton four = new JButton("4");
        four.addActionListener(arg0 -> Action());
        JButton five = new JButton("5");
        five.addActionListener(arg0 -> Action());
        JButton six = new JButton("6");
        six.addActionListener(arg0 -> Action());
        JButton seven = new JButton("7");
        seven.addActionListener(arg0 -> Action());
        JButton eight = new JButton("8");
        eight.addActionListener(arg0 -> Action());
        JButton nine = new JButton("9");
        nine.addActionListener(arg0 -> Action());


        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);

    }

    public void Action()
    {
    }
}

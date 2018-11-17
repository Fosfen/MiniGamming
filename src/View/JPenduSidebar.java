package View;

import Controller.PenduController;
import Model.Pendu;
import View.JeuView.JPendu;
import View.JeuView.JeuView;

import javax.swing.*;
import java.awt.*;

public class JPenduSidebar extends JPanel
{
    LayoutJeu layout;

    public JPenduSidebar (LayoutJeu layout)
    {
        this.layout = layout;

        setLayout(new GridLayout(13,2));
        setBackground(JStatic.HelpFrameBackgroundColor);

        JButton A = new JButton("A");
        A.addActionListener(arg0 -> ActionLettre(A.getText().charAt(0)));
        JButton B = new JButton("B");
        B.addActionListener(arg0 -> ActionLettre(B.getText().charAt(0)));
        JButton C = new JButton("C");
        C.addActionListener(arg0 -> ActionLettre(C.getText().charAt(0)));
        JButton D = new JButton("D");
        D.addActionListener(arg0 -> ActionLettre(D.getText().charAt(0)));
        JButton E = new JButton("E");
        E.addActionListener(arg0 -> ActionLettre(E.getText().charAt(0)));
        JButton F = new JButton("F");
        F.addActionListener(arg0 -> ActionLettre(F.getText().charAt(0)));
        JButton G = new JButton("G");
        G.addActionListener(arg0 -> ActionLettre(G.getText().charAt(0)));
        JButton H = new JButton("H");
        H.addActionListener(arg0 -> ActionLettre(H.getText().charAt(0)));
        JButton I = new JButton("I");
        I.addActionListener(arg0 -> ActionLettre(I.getText().charAt(0)));
        JButton J = new JButton("J");
        J.addActionListener(arg0 -> ActionLettre(J.getText().charAt(0)));
        JButton K = new JButton("K");
        K.addActionListener(arg0 -> ActionLettre(K.getText().charAt(0)));
        JButton L = new JButton("L");
        L.addActionListener(arg0 -> ActionLettre(L.getText().charAt(0)));
        JButton M = new JButton("M");
        M.addActionListener(arg0 -> ActionLettre(M.getText().charAt(0)));
        JButton N = new JButton("N");
        N.addActionListener(arg0 -> ActionLettre(N.getText().charAt(0)));
        JButton O = new JButton("O");
        O.addActionListener(arg0 -> ActionLettre(O.getText().charAt(0)));
        JButton P = new JButton("P");
        P.addActionListener(arg0 -> ActionLettre(P.getText().charAt(0)));
        JButton Q = new JButton("Q");
        Q.addActionListener(arg0 -> ActionLettre(Q.getText().charAt(0)));
        JButton R = new JButton("R");
        R.addActionListener(arg0 -> ActionLettre(R.getText().charAt(0)));
        JButton S = new JButton("S");
        S.addActionListener(arg0 -> ActionLettre(S.getText().charAt(0)));
        JButton T = new JButton("T");
        T.addActionListener(arg0 -> ActionLettre(T.getText().charAt(0)));
        JButton U = new JButton("U");
        U.addActionListener(arg0 -> ActionLettre(U.getText().charAt(0)));
        JButton V = new JButton("V");
        V.addActionListener(arg0 -> ActionLettre(V.getText().charAt(0)));
        JButton W = new JButton("W");
        W.addActionListener(arg0 -> ActionLettre(W.getText().charAt(0)));
        JButton X = new JButton("X");
        X.addActionListener(arg0 -> ActionLettre(X.getText().charAt(0)));
        JButton Y = new JButton("Y");
        Y.addActionListener(arg0 -> ActionLettre(Y.getText().charAt(0)));
        JButton Z = new JButton("Z");
        Z.addActionListener(arg0 -> ActionLettre(Z.getText().charAt(0)));

        add(A);
        add(B);
        add(C);
        add(D);
        add(E);
        add(F);
        add(G);
        add(H);
        add(I);
        add(J);
        add(K);
        add(L);
        add(M);
        add(N);
        add(O);
        add(P);
        add(Q);
        add(R);
        add(S);
        add(T);
        add(U);
        add(V);
        add(W);
        add(X);
        add(Y);
        add(Z);
    }

    public void ActionLettre(char lettre)
    {
        JPendu penduView = (JPendu) layout.getPanelJeu();
        PenduController controller = (PenduController) penduView.getController();
        controller.lettreChoisie(lettre);
    }
}

package View.LayoutJeu.JSidebars;

import Controller.PenduController;
import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;

public class JPenduSidebar extends JSidebarJeu
{
    public JPenduSidebar (LayoutJeu layout)
    {
        super(layout);

        setLayout(new GridLayout(13,2));
        setBackground(JStatic.HelpFrameBackgroundColor);

        JButton A = new JButton("A");
        A.addActionListener(arg0 -> ActionLettre(A.getText().charAt(0),A));
        JButton B = new JButton("B");
        B.addActionListener(arg0 -> ActionLettre(B.getText().charAt(0),B));
        JButton C = new JButton("C");
        C.addActionListener(arg0 -> ActionLettre(C.getText().charAt(0),C));
        JButton D = new JButton("D");
        D.addActionListener(arg0 -> ActionLettre(D.getText().charAt(0),D));
        JButton E = new JButton("E");
        E.addActionListener(arg0 -> ActionLettre(E.getText().charAt(0),E));
        JButton F = new JButton("F");
        F.addActionListener(arg0 -> ActionLettre(F.getText().charAt(0),F));
        JButton G = new JButton("G");
        G.addActionListener(arg0 -> ActionLettre(G.getText().charAt(0),G));
        JButton H = new JButton("H");
        H.addActionListener(arg0 -> ActionLettre(H.getText().charAt(0),H));
        JButton I = new JButton("I");
        I.addActionListener(arg0 -> ActionLettre(I.getText().charAt(0),I));
        JButton J = new JButton("J");
        J.addActionListener(arg0 -> ActionLettre(J.getText().charAt(0),J));
        JButton K = new JButton("K");
        K.addActionListener(arg0 -> ActionLettre(K.getText().charAt(0),K));
        JButton L = new JButton("L");
        L.addActionListener(arg0 -> ActionLettre(L.getText().charAt(0),L));
        JButton M = new JButton("M");
        M.addActionListener(arg0 -> ActionLettre(M.getText().charAt(0),M));
        JButton N = new JButton("N");
        N.addActionListener(arg0 -> ActionLettre(N.getText().charAt(0),N));
        JButton O = new JButton("O");
        O.addActionListener(arg0 -> ActionLettre(O.getText().charAt(0),O));
        JButton P = new JButton("P");
        P.addActionListener(arg0 -> ActionLettre(P.getText().charAt(0),P));
        JButton Q = new JButton("Q");
        Q.addActionListener(arg0 -> ActionLettre(Q.getText().charAt(0),Q));
        JButton R = new JButton("R");
        R.addActionListener(arg0 -> ActionLettre(R.getText().charAt(0),R));
        JButton S = new JButton("S");
        S.addActionListener(arg0 -> ActionLettre(S.getText().charAt(0),S));
        JButton T = new JButton("T");
        T.addActionListener(arg0 -> ActionLettre(T.getText().charAt(0),T));
        JButton U = new JButton("U");
        U.addActionListener(arg0 -> ActionLettre(U.getText().charAt(0),U));
        JButton V = new JButton("V");
        V.addActionListener(arg0 -> ActionLettre(V.getText().charAt(0),V));
        JButton W = new JButton("W");
        W.addActionListener(arg0 -> ActionLettre(W.getText().charAt(0),W));
        JButton X = new JButton("X");
        X.addActionListener(arg0 -> ActionLettre(X.getText().charAt(0),X));
        JButton Y = new JButton("Y");
        Y.addActionListener(arg0 -> ActionLettre(Y.getText().charAt(0),Y));
        JButton Z = new JButton("Z");
        Z.addActionListener(arg0 -> ActionLettre(Z.getText().charAt(0),Z));

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

    public void ActionLettre(char lettre, JButton buttonSource)
    {
        ((PenduController) this.layout.getController()).lettreChoisie(lettre);
        buttonSource.setEnabled(false);
    }

}

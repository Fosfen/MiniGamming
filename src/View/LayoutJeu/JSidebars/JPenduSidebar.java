package View.LayoutJeu.JSidebars;

import Controller.PenduController;
import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JPenduSidebar extends JSidebarJeu
{
    public JPenduSidebar (LayoutJeu layout)
    {
        super(layout);
        setLayout(new GridLayout(13,2));
        setBackground(JStatic.HelpFrameBackgroundColor);

            JButton A = new JButton("A");
            A.addActionListener(arg0 -> {
                try {
                    ActionLettre(A.getText().charAt(0),A);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton B = new JButton("B");
            B.addActionListener(arg0 -> {
                try {
                    ActionLettre(B.getText().charAt(0),B);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton C = new JButton("C");
            C.addActionListener(arg0 -> {
                try {
                    ActionLettre(C.getText().charAt(0),C);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton D = new JButton("D");
            D.addActionListener(arg0 -> {
                try {
                    ActionLettre(D.getText().charAt(0),D);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton E = new JButton("E");
            E.addActionListener(arg0 -> {
                try {
                    ActionLettre(E.getText().charAt(0),E);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton F = new JButton("F");
            F.addActionListener(arg0 -> {
                try {
                    ActionLettre(F.getText().charAt(0),F);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton G = new JButton("G");
            G.addActionListener(arg0 -> {
                try {
                    ActionLettre(G.getText().charAt(0),G);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton H = new JButton("H");
            H.addActionListener(arg0 -> {
                try {
                    ActionLettre(H.getText().charAt(0),H);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton I = new JButton("I");
            I.addActionListener(arg0 -> {
                try {
                    ActionLettre(I.getText().charAt(0),I);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton J = new JButton("J");
            J.addActionListener(arg0 -> {
                try {
                    ActionLettre(J.getText().charAt(0),J);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton K = new JButton("K");
            K.addActionListener(arg0 -> {
                try {
                    ActionLettre(K.getText().charAt(0),K);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton L = new JButton("L");
            L.addActionListener(arg0 -> {
                try {
                    ActionLettre(L.getText().charAt(0),L);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton M = new JButton("M");
            M.addActionListener(arg0 -> {
                try {
                    ActionLettre(M.getText().charAt(0),M);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton N = new JButton("N");
            N.addActionListener(arg0 -> {
                try {
                    ActionLettre(N.getText().charAt(0),N);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton O = new JButton("O");
            O.addActionListener(arg0 -> {
                try {
                    ActionLettre(O.getText().charAt(0),O);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton P = new JButton("P");
            P.addActionListener(arg0 -> {
                try {
                    ActionLettre(P.getText().charAt(0),P);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton Q = new JButton("Q");
            Q.addActionListener(arg0 -> {
                try {
                    ActionLettre(Q.getText().charAt(0),Q);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton R = new JButton("R");
            R.addActionListener(arg0 -> {
                try {
                    ActionLettre(R.getText().charAt(0),R);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton S = new JButton("S");
            S.addActionListener(arg0 -> {
                try {
                    ActionLettre(S.getText().charAt(0),S);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton T = new JButton("T");
            T.addActionListener(arg0 -> {
                try {
                    ActionLettre(T.getText().charAt(0),T);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton U = new JButton("U");
            U.addActionListener(arg0 -> {
                try {
                    ActionLettre(U.getText().charAt(0),U);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton V = new JButton("V");
            V.addActionListener(arg0 -> {
                try {
                    ActionLettre(V.getText().charAt(0),V);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton W = new JButton("W");
            W.addActionListener(arg0 -> {
                try {
                    ActionLettre(W.getText().charAt(0),W);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton X = new JButton("X");
            X.addActionListener(arg0 -> {
                try {
                    ActionLettre(X.getText().charAt(0),X);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton Y = new JButton("Y");
            Y.addActionListener(arg0 -> {
                try {
                    ActionLettre(Y.getText().charAt(0),Y);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            JButton Z = new JButton("Z");
            Z.addActionListener(arg0 -> {
                try {
                    ActionLettre(Z.getText().charAt(0),Z);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


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

    public void ActionLettre(char lettre, JButton buttonSource) throws IOException {
        ((PenduController) this.layout.getController()).lettreChoisie(lettre);
        buttonSource.setEnabled(false);
    }

}

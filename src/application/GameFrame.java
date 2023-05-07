package application;

import domain.Node;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Jogo Gourmet");

        Node root = new Node("Massa");
        Node lasanhaNode = new Node("Lasanha");
        Node boloDeChocolateNode = new Node("Bolo de Chocolate");
        root.setLeft(lasanhaNode);
        root.setRight(boloDeChocolateNode);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel label = new JLabel("Pense em um prato que voce gosta");
        JButton button = new JButton("OK");
        button.addActionListener((ActionEvent e) -> startGame(root));

        panel.add(label);
        panel.add(button);

        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        marginPanel.add(panel, BorderLayout.CENTER);

        setContentPane(marginPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startGame(Node temp) {
        while (temp != null) {
            int result = JOptionPane.showConfirmDialog(this, temp.getQuestion(), "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (temp.getLeft() == null) {
                    JOptionPane.showMessageDialog(this, "Acertei de novo!");
                    break;
                }
                temp = temp.getLeft();
            }
            else {
                if (temp.getRight() == null) {
                    String plate = JOptionPane.showInputDialog(this, "Qual prato que você pensou?");
                    String plateIs = JOptionPane.showInputDialog(this, plate + " é ________ mas "  + temp.getValue() + " não é");
                    temp.setRight(new Node(temp.getValue()));
                    temp.setValue(plateIs);
                    temp.setLeft(new Node(plate));
                    break;
                }
                temp = temp.getRight();
            }
        }
    }

}

package br.com.fabiano.application;

import br.com.fabiano.domain.Node;
import br.com.fabiano.domain.logic.Game;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Jogo Gourmet");

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel label = new JLabel("Pense em um prato que voce gosta");
        JButton button = new JButton("OK");
        Node initialNode = Game.getInitialNode();
        button.addActionListener((ActionEvent e) -> Game.startGame(this, initialNode));

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

}

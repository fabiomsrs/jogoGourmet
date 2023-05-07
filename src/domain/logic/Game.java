package domain.logic;

import application.GameFrame;
import domain.Node;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Game {
    public static Node getInitialNode() {
        Node initialNode = new Node("Massa");
        Node lasanhaNode = new Node("Lasanha");
        Node boloDeChocolateNode = new Node("Bolo de Chocolate");

        initialNode.setLeft(lasanhaNode);
        initialNode.setRight(boloDeChocolateNode);
        return initialNode;
    }

    public static void startGame(GameFrame gameFrame, Node node) {
        while (node != null) {
            int result = JOptionPane.showConfirmDialog(gameFrame, node.getQuestion(), "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (Objects.isNull(node.getLeft())) {
                    JOptionPane.showMessageDialog(gameFrame, "Acertei de novo!");
                    break;
                }
                node = node.getLeft();
            }
            else {
                if (Objects.isNull(node.getRight())) {
                    String plate = JOptionPane.showInputDialog(gameFrame, "Qual prato que você pensou?");
                    String plateIs = JOptionPane.showInputDialog(gameFrame, plate + " é ________ mas "  + node.getValue() + " não é");
                    node.wrongAnswerAddNewNode(plate, plateIs);
                    break;
                }
                node = node.getRight();
            }
        }
    }


}

import domain.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node("Massa");
        Node lasanhaNode = new Node("Lasanha");
        Node boloDeChocolateNode = new Node("Bolo de Chocolate");

        root.setLeft(lasanhaNode);
        root.setRight(boloDeChocolateNode);

        System.out.println("Pense em um prato que voce gosta");
        var temp = root;

        while (true) {
            temp.askQuestion();
            Boolean bool = Boolean.parseBoolean(reader.readLine());

            if (bool) {
                if(!temp.isRoot()) {
                    if(!Objects.isNull(temp.getLeft())){
                        temp = temp.getLeft();
                        continue;
                    }
                    System.out.println("Acertei de novo!");
                    temp = root;
                    continue;
                }
                temp = temp.getLeft();
            }
            else {
                if (Objects.isNull(temp.getRight())) {
                    System.out.println("Qual prato que você pensou?");
                    String plate = reader.readLine();
                    System.out.println("bolo de sal é ________ mas "  + temp.getValue() + " não é");
                    String plateIs = reader.readLine();
                    Node newRightNode = new Node(temp.getValue());
                    temp.setValue(plateIs); //substituindo o valour atual do node
                    temp.setRight(newRightNode); // atribuindo um novo node de resposta errada
                    temp.setLeft( new Node(plate)); // atribuindo um novo node de resposta certa
                    temp = root;
                    continue;
                }
                temp = temp.getRight();
            }
        }


    }
}

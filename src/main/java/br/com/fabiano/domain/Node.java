package br.com.fabiano.domain;

public class Node {
    private String value;
    private Node left;
    private Node right;

    public Node(String value) {
        this.value = value;
    }

    public Node(Node node) {
        this.value = node.value;
        this.left = node.left;
        this.right = node.right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuestion() {
        return "O prato que você pensou é "+ value +"?";
    }

    public void wrongAnswerAddNewNode(String plate, String plateIs) {
        this.setRight(new Node(this.getValue()));
        this.setValue(plateIs);
        this.setLeft(new Node(plate));
    }
}
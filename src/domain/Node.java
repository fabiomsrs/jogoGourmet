package domain;

import java.util.Objects;

public class Node {
    private String value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        this.left.setParent(this);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        this.right.setParent(this);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean isRoot() {
        return Objects.isNull(parent);
    }

    public String getQuestion() {
        return "O prato que você pensou é "+ value +"?";
    }
}
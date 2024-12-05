package ru.otus.java.basic.homeworks.hw19;

class Node {
    private final int value;
    private Node leftChild;
    private Node rightChild;

    Node (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild( Node rightChild) {
        this.rightChild = rightChild;
    }

}



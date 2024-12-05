package ru.otus.java.basic.homeworks.hw19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSearchTree implements SearchTree {
    private ArrayList<Integer> arrayList;
    private Node rootNode;

    IntegerSearchTree(ArrayList<Integer>arrayList) {
        this.arrayList = new ArrayList<>(arrayList);
        Collections.sort(this.arrayList);
        rootNode = sortedArrayToTree(this.arrayList, 0, this.arrayList.size()-1);
    }

    public List<Integer> getSortedList() {
        return arrayList;
    }

    private Node sortedArrayToTree(ArrayList<Integer> arrayList, int first, int last) {
        if (first > last) return null;
        int middle = first + (last - first) / 2;
        Node node = new Node(arrayList.get(middle));
        node.setLeftChild(sortedArrayToTree(arrayList, first, middle-1));
        node.setRightChild(sortedArrayToTree(arrayList, middle+1, last));
        return node;
    }

    public Integer find(Integer element) {
        return findNode(rootNode, element) != null ? findNode(rootNode, element).getValue() : null;
    }

    private Node findNode(Node node, Integer element) {
        if (node == null || node.getValue() == element) {
            return node;
        } else if (element < node.getValue()) {
            return findNode(node.getLeftChild(), element);
        }
        return findNode(node.getRightChild(), element);
    }

    public void printIntegerSearchTree() {
        printNode(rootNode, 0, 0);
    }

    private void printNode(Node node, int shift, int level) {
        if (node == null) return;
        shift += 5;
        level += 1;
        printNode(node.getRightChild(), shift, level);
        System.out.print("\n");
        for (int i = 5; i < shift; i++) System.out.print(" ");
        System.out.print(level + ":" + node.getValue() + "\n");
        printNode(node.getLeftChild(), shift, level);
    }
}

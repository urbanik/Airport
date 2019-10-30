package com.urbanik.structures;

public class Node<D extends Comparable<D>> {

    private D data;
    private Node leftSon;
    private Node rightSon;
    private Node parent;

    public Node(D data) {

        this.data = data;
        leftSon = null;
        rightSon = null;
        parent = null;

    }

    public D getData() {
        return data;
    }

    public Node getLeftSon() {
        return leftSon;
    }

    public Node getRightSon() {
        return rightSon;
    }

    public Node getParent() {
        return parent;
    }

    public void setData(D data) {
        this.data = data;
    }

    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    public void setRightSon(Node rightSon) {
        this.rightSon = rightSon;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}

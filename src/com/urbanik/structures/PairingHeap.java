package com.urbanik.structures;

import java.util.Stack;

public class PairingHeap<D extends Comparable<D>> {

    private Node root;
    private int size;

    public PairingHeap() {
        this.root = null;
        size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int size() {
        return size;
    }

    public Node pair(Node node1, Node node2){

        if (node1 == null) return node2;
        if (node2 == null) return node1;

        int cmp = node1.getData().compareTo(node2.getData());
        if(cmp >= 0){ // AK JE VACSIA HODNOTA, TEDA NIZSIA PRIORITA

            if (node2.getLeftSon() != null) {
                node1.setRightSon(node2.getLeftSon());
            }

            node2.setLeftSon(node1);
            return node2;

        }else{ // AK JE MENSIA HODNOTA, TEDA VYSSIA PRIORITA

            if (node1.getLeftSon() != null) {
                node2.setRightSon(node1.getLeftSon());
            }
            node1.setLeftSon(node2);
            return node1;

        }
    }

    public void insert(D data){

        Node<D> node = new Node<D>(data);
        if(this.root == null){
            this.root = node;
            size++;
            return;
        }else{
            this.root = pair(node, root);
            size++;
        }
    }

    public void removeMinimum(){

        Stack<Node> stack = new Stack();

        if (this.root == null) return;

        if (this.root.getLeftSon() == null && this.root.getRightSon() == null) {
            this.root = null;
            return;
        }

        Node current = this.root;
        Node rightSon = this.root.getRightSon();
        if (rightSon != null) {
            stack.push(rightSon);
        }
        if(current.getLeftSon() != null)
            current = current.getLeftSon();

        while (current.getRightSon() != null) {
            rightSon = current.getRightSon();
            current.setRightSon(null);
            stack.push(current);
            current = rightSon;
        }

        stack.push(current); // posledny surodenec

        while (stack.size() > 1) { // parujem az by ostal jeden konecny strom
            stack.push(this.pair(stack.get(0), stack.get(1)));
            stack.remove(0);
            stack.remove(0);
        }
        this.root = stack.get(0);
        size--;
    }

    public boolean changePriority(){
        return true;
    }

    public void inOrderPrint(){
        Stack<Node> nodes = new Stack<>();

        Node current = root;
        while (!nodes.isEmpty() || current != null) {

            if (current != null) {
                nodes.push(current);
                current = current.getLeftSon();
            } else {
                Node node = nodes.pop();
                System.out.print(node.getData().toString());
                System.out.print(" \n");
                current = node.getRightSon();
            }
        }
        System.out.println();
    }

    public void inOrderReversePrint(){
        Stack<Node> nodes = new Stack<>();

        Node current = root;
        while (!nodes.isEmpty() || current != null) {

            if (current != null) {
                nodes.push(current);
                current = current.getRightSon();
            } else {
                Node node = nodes.pop();
                System.out.print(node.getData().toString());
                System.out.print(" \n");
                current = node.getLeftSon();
            }
        }
        System.out.println();
    }
}

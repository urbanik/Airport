package com.urbanik.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SplayTree2<D extends Comparable<D>> {

    private Node root;
    private int size;

    public SplayTree2() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size;
    }

    public Node<D> find(D data){

        Node<D> current = this.root;
        Node<D> parent = null;

        while (data.compareTo(current.getData()) != 0) {
            parent = current;
            if (data.compareTo(current.getData()) > 0) {
                current = current.getRightSon();
            } else {
                current = current.getLeftSon();
            }
        }

        splay(current);
        return current;

    }

    public void insert(D data){

        Node insert = new Node(data);
        if(root == null){

            root = insert;
            size++;
            return;
        } else {

            Node current = root;
            Node parent = null;

            while(current != null) {

                parent = current;
                int cmp = data.compareTo((D) current.getData());

                if (cmp > 0) {

                    current = current.getRightSon();

                    if (current == null) {

                        parent.setRightSon(insert);
                        insert.setParent(parent);
                        size++;
                        splay(insert);
                        return;
                    }
                } else {

                    current = current.getLeftSon();

                    if (current == null) {

                        parent.setLeftSon(insert);
                        insert.setParent(parent);
                        size++;
                        splay(insert);
                        return;
                    }
                }
            }
        }
    }

    public void remove(D data){

        Node<D> current = root;
        Node<D> parent = null;
        boolean isLeftSon = true;

        while (data.compareTo(current.getData()) != 0) {
            parent = current;
            if (data.compareTo(current.getData()) > 0) {
                isLeftSon = false;
                current = current.getRightSon();
            } else {
                isLeftSon = true;
                current = current.getLeftSon();
            }
            if (current == null)
                return;
        }
        size--;
        this.delete(current, isLeftSon);
    }

    private void delete (Node<D> node, boolean isLeftSon) {

        Node<D> current = node;
        Node<D> parent = node.getParent();

        if (current.getLeftSon() == null && current.getRightSon() == null) { // bezdetny
            current = null;

            if (isLeftSon) {

                parent.setLeftSon(null);
            } else {

                parent.setRightSon(null);
            }

            this.splay(parent);
            return;
        }


        if (current.getLeftSon() == null) { // nema laveho syna

            if (current == this.root) {

                this.root = current.getRightSon();
                this.root.setParent(null);
            }
            else if (isLeftSon) {

                parent.setLeftSon(current.getRightSon());
                current.getRightSon().setParent(parent);
            }

            else {

                parent.setRightSon(current.getRightSon());
                current.getRightSon().setParent(parent);
            }
            current = null;
            if (parent != null) {

                this.splay(parent);
            }
            return;
        }

        if (current.getRightSon()== null) {// nema praveho syna

            if (current == this.root) {

                this.root = current.getLeftSon();
                this.root.setParent(null);

            }

            else if (isLeftSon) { // je lavy syn

                parent.setLeftSon(current.getLeftSon());
                current.getLeftSon().setParent(parent);
            }

            else { // je pravy syn

                parent.setRightSon(current.getLeftSon());
                current.getLeftSon().setParent(parent);

            }
            current = null;
            if (parent != null) {

                this.splay(parent);
            }
            return;
        }

        //Ak má dvoch synov


        Node<D> successor = this.getSuccessor(current.getRightSon()); // min z pravej strany

        Node<D> tmp = new Node<D>(current.getData());

        D dataTmp = current.getData();

        current.setData(successor.getData());
        successor.setData(dataTmp);

        if (successor == successor.getParent().getLeftSon()) {

            isLeftSon = true;
        } else{

            isLeftSon = false;
        }

        this.delete(successor, isLeftSon);
    }

    private void splay(Node node) {

        if(node.getParent() == null && node.getLeftSon() == null && node.getRightSon() == null){

            return;
        }
        while (node.getParent() != null) {

            if (node.getParent().getParent() == null) { // praotec je koren stromu

                if (node == node.getParent().getLeftSon()) { // vstupny vrchol je lavy syn korena

                    rotateRight(node.getParent());

                } else { // vstupny vrchol je pravy syn korena

                    rotateLeft(node.getParent());

                }

            } else if (node == node.getParent().getLeftSon() && node.getParent() == node.getParent().getParent().getLeftSon()) { // vstupny vrchol a jeho otec su lavymi synmi

                rotateRight(node.getParent().getParent());
                rotateRight(node.getParent());

            } else if (node == node.getParent().getRightSon() && node.getParent() == node.getParent().getParent().getRightSon()) { // vstupny vrchol a jeho otec su pravymi synmi

                rotateLeft(node.getParent().getParent());
                rotateLeft(node.getParent());

            } else if (node == node.getParent().getRightSon() && node.getParent() == node.getParent().getParent().getLeftSon()) { // vstupny vrchol je pravy syn a otec je lavy syn

                rotateLeft(node.getParent());
                rotateRight(node.getParent());

            } else {                                                                                // vstupny vrchol je lavy syn a otec je pravy syn

                rotateRight(node.getParent());
                rotateLeft(node.getParent());

            }
        }

    }

    private void rotateRight(Node node) {

        Node nodeLeftSon = node.getLeftSon();
        node.setLeftSon(nodeLeftSon.getRightSon());

        if (nodeLeftSon.getRightSon() != null) {

            nodeLeftSon.getRightSon().setParent(node);

        }

        nodeLeftSon.setParent(node.getParent());

        if (node.getParent() == null) {

            this.root = nodeLeftSon;

        } else if (node == node.getParent().getRightSon()) {

            node.getParent().setRightSon(nodeLeftSon);

        } else {

            node.getParent().setLeftSon(nodeLeftSon);

        }

        nodeLeftSon.setRightSon(node);
        node.setParent(nodeLeftSon);

    }

    private void rotateLeft(Node node) {

        Node nodeRightSon = node.getRightSon();
        node.setRightSon(nodeRightSon.getLeftSon());

        if (nodeRightSon.getLeftSon() != null) {

            nodeRightSon.getLeftSon().setParent(node);

        }

        nodeRightSon.setParent(node.getParent());

        if (node.getParent() == null) {

            this.root = nodeRightSon;

        } else if (node == node.getParent().getLeftSon()) {

            node.getParent().setLeftSon(nodeRightSon);

        } else {

            node.getParent().setRightSon(nodeRightSon);

        }

        nodeRightSon.setLeftSon(node);
        node.setParent(nodeRightSon);

    }

    public Node getSuccessor(Node node){ // minimum praveho podstromu

        Node local = node;

        while(local.getLeftSon() != null){

            local = local.getLeftSon();
        }
        return local;
    }

    public boolean inOrderTest(){ // kazdy dalsi je vacsi kluc
        Stack<Node> nodes = new Stack<>();
        boolean result = true;
        Node current = root;
        List<Integer> list = new ArrayList<>();

        while (!nodes.isEmpty() || current != null) {

            if (current != null) {
                nodes.push(current);
                current = current.getLeftSon();
            } else {
                Node node = nodes.pop();
                list.add((Integer) node.getData());
                current = node.getRightSon();
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(i + 1 < list.size()) {
                if (list.get(i) > list.get(i + 1)) {
                    result = false;
                }
            }
        }

        return result;
    }

    public void inOrderPrint(){
        Stack<Node> nodes = new Stack<>();

        Node current = root;
        //System.out.print(current.getData() + " is root. ");
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
        System.out.print("end of inOrder traversal");
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

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

    public Node<D> pair(Node<D>  node1, Node<D>  node2){

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

    public Node<D> insert(D data){

        Node<D> node = new Node<D>(data);
        if(this.root == null){
            this.root = node;
            size++;
        }else{
            this.root = pair(node, root);
            size++;
        }
        return node;
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

    public void priorityUp(Node<D> node, D withNewPriority){

        if(node == root){

            return;

        }else{ // (node.getParent() != null)
            // porovname s novou prioritou
            int cmp = withNewPriority.compareTo((D) node.getParent().getData());

            node.setData(withNewPriority); // prehodime data

            if(cmp >= 0){ // vacsia hodnota syna, nizsia priorita syna

                return;

            }else{

                if(node.getParent().getLeftSon() == node){ // prvok je lavy syn
                    node.getParent().setLeftSon(null); //odpojime, zmazeme referenciu na otca

                }else{

                    //ak ma prvok pravho syna tak ho prirad otcovi
                    if (node.getRightSon() != null) {
                        node.getParent().setRightSon(node.getRightSon());
                    } else {
                        node.getParent().setRightSon(null);
                    }
                }
                node.setParent(null);
                node.setData(withNewPriority); // prehodime data
                this.root = pair(root, node);
            }
        }
    }

    public void priorityDown(Node<D> node, D withNewPriority){
        Stack<Node> stack = new Stack();
        int cmp = withNewPriority.compareTo((D) node.getParent().getData());
        if((node != null && cmp < 1) || node.getLeftSon() == null){ // ak nie je node null a zarovne synova priorita je stale mensia alebo nema laveho syna nerobim nic

            return;

        } else {

            // prehodim data
            node.setData(withNewPriority);
            //poznacim referencie
            Node<D> saveParent = node.getParent();
            Node<D> saveRightSon = null;

            if (node.getRightSon() != null) {
                saveRightSon = node.getRightSon();
            }
            boolean hasLeftSon = false;
            if (saveParent != null) {
                if (saveParent.getLeftSon() == node) {
                    hasLeftSon = true;
                } else {
                    hasLeftSon = false;
                }
            }

            Node<D> current = node.getLeftSon();

            // zmazem referencie
            node.setLeftSon(null);
            node.setRightSon(null);
            node.setParent(null);
            stack.push(node);

            // pozbierame pravych synov
            Node<D> rightJunior;
            while (current.getRightSon() != null) {
                rightJunior = current.getRightSon();
                current.setRightSon(null);
                //pridavok
                current.setParent(null);

                stack.push(current);
                current = rightJunior;
            }

            //pridavok
            current.setParent(null);

            //pridanie do stacku posledneho surodenca;
            stack.push(current);


            while (stack.size() > 1) {
                stack.push(this.pair(stack.get(0), stack.get(1)));
                //zmazanie poslednych prvkov
                stack.remove(0);
                stack.remove(0);
            }
            // nastavenie vyslednemu rootu otca a next sibling
            if (saveParent == null) {
                this.root = stack.get(0);
            } else {
                stack.get(0).setParent(saveParent);
                stack.get(0).setRightSon(saveRightSon);
                if (hasLeftSon) {
                    saveParent.setLeftSon(stack.get(0));
                } else {
                    saveParent.setRightSon(stack.get(0));
                }
            }
        }
    }

    public void remove(Node<D> node, D mostPrior){

        priorityUp(node, mostPrior);
        removeMinimum();

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

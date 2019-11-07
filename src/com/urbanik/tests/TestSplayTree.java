package com.urbanik.tests;

import com.urbanik.structures.Node;
import com.urbanik.structures.SplayTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSplayTree {

    int numberOfitemsAtStart;
    int numberOfOperations;
    SplayTree<Integer> tree;
    List<Integer> list;
    Random random;
    ArrayList<Integer> numbers;

    public TestSplayTree(int numberOfitemsAtStart, int numberOfOperations) {

        this.numberOfitemsAtStart = numberOfitemsAtStart;
        this.numberOfOperations = numberOfOperations;

        tree = new SplayTree();
        list = new ArrayList<>();

        random = new Random();
        numbers = new ArrayList<Integer>();

        while (numbers.size() < (numberOfitemsAtStart + numberOfOperations) * 2) {
            int data = getRandomInt(1, (numberOfitemsAtStart + numberOfOperations) * 2);

            if (!numbers.contains(data)) {
                numbers.add(data);
            }
        }
        while (list.size() != numberOfitemsAtStart) {
            int data = numbers.get(numbers.size() - 1);
            list.add(data);
            tree.insert(data);
            numbers.remove(numbers.size() - 1);
        }
    }

    public int getRandomInt(int min, int max) {

        return random.nextInt((max - min) + 1) + min;
    }

    // in order predchodca je mensi, zanim vacsi
    // hladany vrchol, parent je koren
    // strom ma atribut na pocitanie a to musi sediet
    // odstran duplicity!!!

    public void test() {

        System.out.println("Number of items in array list: " + list.size());
        System.out.println("Number of items in splay tree: " + tree.size());
        //tree.inOrderPrint();

        for(int i = 0; i < numberOfOperations; i++) {
            int operation = random.nextInt(3);

            switch (operation) {
                case 0: {
                    int data = numbers.get(numbers.size() - 1);
                    list.add(data);
                    tree.insert(data);
                    if (data != (Integer) tree.getRoot().getData()) {
                        System.out.println("NAH, inserted node is not in root!");
                    }
                    numbers.remove(numbers.size() - 1);
                    break;
                }
                case 1: {
                    int index = random.nextInt(list.size() - 1);
                    int data = list.get(index);
                    list.remove(index);
                    tree.remove(data);
                    break;
                }
                case 2: {
                    int toFound = list.get(list.size() - 1); // TEST ZE AK SA NAJDE TAK HO POROVNA S VRCHOLOM MUSI SEDIET
                    Node n = tree.find(toFound);
                    if (n != tree.getRoot()) {
                        System.out.println("NAH, found node is not in root!");
                    }
                    break;
                }
            }
        }
        System.out.println("Number of items in array list: " + list.size());
        System.out.println("Number of items in splay tree: " + tree.size());
        //tree.inOrderPrint();
        if (tree.inOrderTest()) {
            System.out.println("InOrder test positive.");
        } else {
            System.out.println("InOrder test negative.");
        }
    }
}


package com.urbanik.tests;

import com.urbanik.structures.Node;
import com.urbanik.structures.PairingHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class TestPairingHeap {

    private PriorityQueue<Integer> priorityQueue;
    private PairingHeap pairingHeap;
    private Random random;
    private int numberOfitemsAtStart;
    private int numberOfOperations;
    private List<Integer> deletedFromPQ;
    private List<Integer> deletedFromPH;

    public TestPairingHeap(int numberOfitemsAtStart, int numberOfOperations) {

        priorityQueue = new PriorityQueue<>();
        pairingHeap = new PairingHeap();
        this.numberOfitemsAtStart = numberOfitemsAtStart;
        this.numberOfOperations = numberOfOperations;
        deletedFromPQ = new ArrayList<>();
        deletedFromPH = new ArrayList<>();

        random = new Random();
        ArrayList<Integer> numbersStart = new ArrayList<Integer>();

        while (pairingHeap.size() < numberOfitemsAtStart) { // numbersStart.size()
            int data = getRandomInt(1, numberOfitemsAtStart); // *2

            //if (!numbersStart.contains(data)) {
                //numbersStart.add(data);
                //System.out.println("Adding priority: " + data);
                pairingHeap.insert(data);
                priorityQueue.add(data);
           // }
        }
    }

    public int getRandomInt(int min, int max) {

        return random.nextInt((max - min) + 1) + min;
    }

    public void test() {
        System.out.println("After " + numberOfitemsAtStart + " insertions: ");
        System.out.println("Peek in priority queue: " + priorityQueue.peek());
        System.out.println("Number of items in priority queue: " + priorityQueue.size());
        System.out.println("Peek in pairing heap: " + pairingHeap.getRoot().getData());
        System.out.println("Number of items in pairing heap: " + pairingHeap.size());
        //pairingHeap.inOrderPrint();

        ArrayList<Integer> numbersOperations = new ArrayList<Integer>();

        for (int i = 0; i < numberOfOperations; i++) {

            int operation = random.nextInt(3);

            switch (operation) {
                case 0: {
                    //int data = numbersOperations.get(numbersOperations.size() - 1);
                    int data = getRandomInt(1, numberOfOperations);
                    priorityQueue.add(data);
                    pairingHeap.insert(data);

                    //numbersOperations.remove(numbersOperations.size() - 1);
                }
                case 1: {
                    deletedFromPQ.add(priorityQueue.peek());
                    deletedFromPH.add((Integer) pairingHeap.getRoot().getData());
                    priorityQueue.poll();
                    pairingHeap.removeMinimum();
                }
            }
        }
        System.out.println("After " + numberOfOperations + " operations: ");
        System.out.println("Peek in priority queue: " + priorityQueue.peek());
        System.out.println("Number of items in priority queue: " + priorityQueue.size());
        System.out.println("Peek in pairing heap: " + pairingHeap.getRoot().getData());
        System.out.println("Number of items in pairing heap: " + pairingHeap.size());

        System.out.println("Deleted items from priority queue: ");
        for (Integer i : deletedFromPQ) {
            System.out.print(i + " ");
        }
        System.out.println("\nDeleted items from pairing heap: ");
        for (Integer i : deletedFromPH) {
            System.out.print(i + " ");
        }
        //pairingHeap.inOrderPrint();
    }
}

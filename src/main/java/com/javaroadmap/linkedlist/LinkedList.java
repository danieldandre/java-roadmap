package com.javaroadmap.linkedlist;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class LinkedList {
    private Node firstNode;
    private Node lastNode;

    // Constructor methods
    //TODO: Validate non-empty constructor methods

    public LinkedList() {
        //Empty constructor
    }

    public LinkedList(Node firstNode) {
        this.firstNode = firstNode;
    }

    public LinkedList(Node firstNode, Node lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }

    // Insert methods
    public void insertFirst(Node node) {
        Node tempNode = firstNode;

        if (firstNode != null) {
            firstNode = node;
            firstNode.setNext(tempNode);
        } else {
            firstNode = node;
        }
    }

    public void insertLast(Node node) throws NullPointerException {
        checkEmptyLinkedList();

        Node current = firstNode;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        lastNode = node;
    }

    public void insertAfter(Node target, Node insert) throws NullPointerException, NoSuchElementException {
        checkEmptyLinkedList();

        Node current = firstNode;
        while (!target.getData().equals(current.getData())) {
            if (current.getNext() == null) {
                throw new NoSuchElementException("Target node not found");
            }
            current = current.getNext();

        }
        //Insert logic
        insert.setNext(current.getNext());
        current.setNext(insert);
    }

    // Delete methods
    public void deleteFirst() throws NullPointerException {
        checkEmptyLinkedList();

        if (firstNode.getNext() != null) {
            firstNode = firstNode.getNext();
        } else {
            throw new NullPointerException("Node unavailable after first");
        }
    }

    public void deleteLast() {
        checkEmptyLinkedList();

        Node current = firstNode;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        lastNode = current;
        lastNode.setNext(null);
    }


    public void deleteNode(String stringNode) {
        /**
         * Deletes node with corresponding data input String value
         *
         * @param String A string value corresponding to a node's data
         */
        checkEmptyLinkedList();

        //TODO -> Implement this

    }

    // Traversal methods
    public void display() {
        StringBuilder sb = new StringBuilder();
        Node current = firstNode;

        while (current.getNext() != null) {
            sb.append(current.getData() + "-> ");
            current = current.getNext();

        }
        sb.append(current.getData() + "-> End");
        System.out.println(sb);
    }

    public Node searchNode(String stringNode) throws NullPointerException, IllegalArgumentException {
        /**
         * Retrieves the node with the corresponding input data String value
         *
         * @param String A string value corresponding to a node's data
         * @return The Node with the corresponding String data
         */
        checkEmptyLinkedList();
        Node current = firstNode;

        while (current.getNext() != null) {
            if (current.getData() == stringNode) {
                return current;
            }
            current = current.getNext();
        }
        if (current.getData() == stringNode) {
            return current;
        } else {
            throw new IllegalArgumentException("Node not found!");
        }
    }

    public Node index(Integer element) {
        /**
         * Retrieves the node at the provided index
         *
         * @param Integer A 0 indexed number to retrieve a Node from
         * @return The Node at the provided index(element)
         */
        checkEmptyLinkedList();
        if (element > getSize() - 1) {
            throw new IndexOutOfBoundsException("Element bigger than Linked List!");
        }
        int counter = 0;
        Node current = firstNode;

        while (counter < element) {
            current = current.getNext();
            counter++;
        }
        return current;
    }

    // Utils
    public Integer getSize() throws NullPointerException {
        checkEmptyLinkedList();
        int counter = 1;
        Node tempNode = firstNode;

        if (firstNode.getData() != null && firstNode.getNext() == null) {
            return 1;
        } else {
            while (tempNode.getNext() != null) {
                counter++;
                tempNode = tempNode.getNext();
            }
        }
        return counter;
    }

    private void checkEmptyLinkedList() throws NullPointerException {
        if (firstNode == null) {
            throw new NullPointerException("Empty LinkedList");
        }
    }

    public boolean isEmpty() {
        boolean var;
        var = firstNode == null;
        return var;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public static void main(String[] args) {
        Node nodeOne = new Node("A");
        Node nodeTwo = new Node("B");
        Node nodeThree = new Node("C");
        Node nodeFour = new Node("D");
        Node target = new Node("B");
        Node insert = new Node("E");

        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(nodeOne);
        linkedList.insertLast(nodeTwo);
        linkedList.insertLast(nodeThree);
        linkedList.insertLast(nodeFour);

        linkedList.display();
        linkedList.deleteLast();
        linkedList.display();

    }
}

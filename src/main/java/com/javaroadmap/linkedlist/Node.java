package com.javaroadmap.linkedlist;

public class Node {

    private String data;
    private Node next;

    public Node() {
        //Initialise empty node
    }

    public Node(String data) {
        this.data = data;
    }

    public Node(String currentNode, Node next) {
        this.data = currentNode;
        this.next = next;
    }

    // Setter methods
    public void setData (String currentNode) {
        this.data = currentNode;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    // Getter methods
    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public String toString() throws NullPointerException {
        StringBuilder sb = new StringBuilder();
        try {
            if (data != null) {
                sb.append("Node{data=").append(data).append(", next=");
                if (next != null) {
                    sb.append(next);
                } else {
                    sb.append("null");
                }
                sb.append("}");
            } else {
                throw new NullPointerException("currentNode is null");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error: currentNode is null.");
            npe.printStackTrace();
        }
        return sb.toString();
    }

}
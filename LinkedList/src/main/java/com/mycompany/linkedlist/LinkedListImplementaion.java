/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.linkedlist;

import java.util.*;

/**
 *
 * @author Kiki Ashun
 */
public class LinkedListImplementaion {

    Node head; // head of list

    // Linked list Node
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Inserts a new Node at front of the list. 
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Prints contents of linked list starting
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    // Insert given node after a particular node
    public void insertAt(Node prevnode, int data) {

        if (prevnode == null) {
            System.out.println("The given node cannot be null");
            return;
        }
        Node newnode = new Node(data);
        newnode.next = prevnode.next;
        prevnode.next = newnode;

    }

    // Insert given node at the end of the linked list
    public void insertEnd(int data) {

        Node new_node = new Node(data);

        if (head == null) {
            head = new Node(data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    // Delete note iterative method
    public void deleteNodeIt(int key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            return;
        }

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Delete note recursive method
    public static Node deleteNodeRec(Node start, int k) {
        // If invalid k ie. position of node to delete 
        if (k < 1) {
            return start;
        }

        // If linked list is empty  
        if (start == null) {
            return null;
        }

        // Base case (start needs to be deleted)  
        if (k == 1) {
            Node res = start.next;
            return res;
        }

        start.next = deleteNodeRec(start.next, k - 1);
        return start;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListImplementaion List = new LinkedListImplementaion();

        // Add nodes to the list
        List.push(8);
        List.push(10);
        List.push(12);
        List.push(16);
        List.push(9);
        List.push(14);

        // Displays the nodes present in the list
        System.out.println("\nInitial linked list:");
        List.printList();

        System.out.println("\nLinked list after inserting 15 in front");
        List.push(15);
        List.printList();

        System.out.println("\nLinked list after inserting 25 after node 16");
        List.insertAt(List.head.next.next.next, 25);
        List.printList();

        System.out.println("\nLinked list after deleting node 9");
        LinkedListImplementaion.deleteNodeRec(List.head, 3);
        List.printList();

        System.out.println("\nLinked list after adding 30 after node 10");
        List.insertAt(List.head.next.next.next.next.next, 30);
        List.printList();

        System.out.println("\nLinked list after inserting 45 at the end");
        List.insertEnd(45);
        List.printList();

        System.out.println("\nLinked list after deleting node 8");
        List.deleteNodeIt(8);
        List.printList();
    }

}

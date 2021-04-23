/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueadt;

/**
 *
 * @author Kiki Ashun
 * @param <E>
 */
public class QueueADT<E> {

    private Node<E> front, rear; //begin and end nodes
    private int size; // number of items

    //nested class to define node
    private class Node<E> {
        E data;
        Node<E> next;
    }

    //Zero argument constructor
    public QueueADT() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //Remove data from the beginning of the list.
    public E dequeue() {
        E item = front.data;
        front = front.next;

        if (isEmpty()) {
            rear = null;
        }

        size--;

        return item;
    }

    //Add data to the end of the list.
    public void enqueue(E item) {
        Node oldLast = rear;

        rear = new Node();
        rear.data = item;
        rear.next = null;

        if (isEmpty()) {
            front = rear;
        } else {
            oldLast.next = rear;
        }

        size++;
    }

    public int size() {
        return size;
    }

}

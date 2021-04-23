/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackadt;

/**
 *
 * @author Kiki Ashun
 * @param <E>
 */
public class StackADT<E> {
    
    private Node<E> top = null;
    int size = 0; //initializing number of elements in stack
    
    /**
     * Return true if the stack is empty, false otherwise.
     * @return 
     */
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * Node class
     * @param <E> 
     */
    public class Node<E>{
        private E data;
        private Node<E> next = null;
        
        public Node(E data){
            this.data = data;
        }
    }
    
    /**
     * Returns the element at the top of the stack
     * @return 
     */
    public E peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        else{           
            return top.data;
        }
    }
    
     /**
     * Insert an element at the top of the stack.
     * @param data
     */
    public void push(E data){
        Node<E> newNode = new Node<>(data);
        
        if(top == null){
            top = newNode;
            size++;
        }
        else{
            newNode.data = data;
            newNode.next = top;
            top = newNode;
            size++;
        }
    }
    
    /**
     * Remove the top element from the stack.
     * @return
     */
    public E pop(){
        if(top == null){
            System.out.println("The stack is empty");
           return null;
        }
        E popItem = top.data;
        top = top.next;
        size--;
        return popItem;
    }
    
    /**
     * Prints the elements in the stack
     */
    public void display(){
        if(top == null){
            System.out.println("The stack is empty");
        }
        else{
            Node<E> item = top;
            while (item != null) {       
                System.out.println(item.data.toString());
                item = item.next;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instance of the stack class
        StackADT<String> adt = new StackADT<>();
        
        //adding elements to the stack
        adt.push("Google");
        adt.push("Facebook");
        adt.push("Twitter");
        adt.push("Reddit");
        adt.push("Instagram");
        adt.push("Youtube");
        adt.push("Ghanaweb");
        adt.push("Betway");
        
        //displaying the elements in the stack
        adt.display();
        System.out.println("Top element is: " + adt.peek());
        
        //removing elements from the stack
        adt.pop();
        adt.pop();
        adt.pop();
        
        //displaying the new elements in the stack
        System.out.println("\n");
        adt.display();       
        System.out.println("Top element is: " + adt.peek());
    }
    
}

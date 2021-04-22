/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeadt;

/**
 *
 * @author Kiki
 */
public class TreeADT {

    /**
     * @param args the command line arguments
     */
    private TreeNode head;
	
	private class TreeNode {
		private final int data; // Generic type
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void insert(int value) {
		head = insert(head, value);
	}
	
	public TreeNode insert(TreeNode head, int value) {
		if(head == null) {
			head = new TreeNode(value);
			return head;
		}
		
		if(value < head.data) {
			head.left = insert(head.left, value);
		} else {
			head.right = insert(head.right, value);
		}
		return head;
	}
	
	public void inOrder() {
		inOrder(head);
	}
	
	public void inOrder(TreeNode head) {
		if(head == null) {
			return;
		}
		inOrder(head.left);
		System.out.print(head.data + " ");
		inOrder(head.right);
	}
	
	public TreeNode search(int key) {
		return search(head, key);
	}
	
	public TreeNode search(TreeNode head, int key) {
		if(head == null || head.data == key) { // base case 
			return head;
		}
		
		if(key < head.data) {
			return search(head.left, key);
		} else {
			return search(head.right, key);
		}
		
	}

	public static void main(String[] args) {
            // TODO code application logic here
            
		TreeADT adt = new TreeADT();
		adt.insert(5);
		adt.insert(3);
		adt.insert(7);
		adt.insert(1);
		
		adt.inOrder();
		
		System.out.println();
		
		if(null != adt.search(5)) {
			System.out.println("Key has been found");
		} else {
			System.out.println("Key was not found !!!");
		}
	}
    
}

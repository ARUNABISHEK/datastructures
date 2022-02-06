package com.lineardatastructure;

public class BinarySearchTree {
	
	class Node {
		int key;
		Node left,right;
		Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	BinarySearchTree(int val) {
		root = new Node(val);
	}
	
	//insertion
	public void insert(int key) { root = insert(root, key); }
	
	public Node insert(Node node, int val) {
		if(node==null)
			return new Node(val);
		if(val < node.key)
			node.left = insert(node.left, val);
		else if(val > node.key)
			node.right = insert(node.right, val);
		return node;
	}
	
	//display
	public void inOrder() { inOrder(root); }
	
	public void inOrder(Node node) {
		if(node!=null) {
			System.out.print(node.key + " --> ");
			inOrder(node.left);
			inOrder(node.right);
		}
	}
	
	//DeleteNode
	public void delete(int value) {
		delete(root,value);
	}

	public Node delete(Node node, int val) {
		if(node == null)
			return node;
		if(val < node.key)
			node.left = delete(node.left, val);
		else if(val > node.key)
			node.right = delete(node.right, val);
		else {
			//only one child
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			//two child
			//right node min value inter change
			node.key = min(node.right);
			//delete minVal on right node
			node.right = delete(node.right,node.key);
		}
		return node;
	}
	
	public int min(Node node) {
		int minVal = node.key;
		if(node.left != null) {
			minVal = node.left.key;
			node = node.left;
		}
		return minVal;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(40);
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(50);
		bst.insert(60);
		bst.inOrder();
		System.out.println();
		bst.delete(40);
		bst.inOrder();
	}
}

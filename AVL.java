package com.lineardatastructure;

public class AVL {
	Node root;
	class Node {
		int key,height;
		Node left,right;
		Node(int val) {
			key = val;
			left = right = null;
			height = 0;
		}
	}
	
	AVL() {
		root = null;
	}
	AVL(int val){
		root = new Node(val);
	}
	
	public int getHeight(Node node) {
		if(node==null)
			return -1;
		return node.height;
	}
	private int max(int x,int y) {
		return x > y ? x : y;
	}
	private int getBalance(Node node){
		if(node==null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}
	
	private Node leftRotate(Node z) {
		
		Node y = z.right;
		Node t3 = y.left;
		
		y.left = z;
		z.right = t3;
		
		z.height = 1 + max(getHeight(z.left),getHeight(z.right));
		y.height = 1 + max(getHeight(y.left),getHeight(y.right));
		
		return y;
	}
	private Node rightRotate(Node z) {	
		Node y = z.left;
		Node t3 = y.right;
		
		y.right = z;
		z.left = t3;
		
		z.height = 1 + max(getHeight(z.left),getHeight(z.right));
		y.height = 1 + max(getHeight(y.left),getHeight(y.right));
		
		return y;
	}
	
	public void insert(int val) {
		root = insert(root,val);
	}
	
	public Node insert(Node node, int val) {
		if(node==null) {
			return new Node(val);
		}
		if(val < node.key)
			node.left = insert(node.left, val);
		else if(val > node.key)
			node.right = insert(node.right, val);
		else
			return node;
		node.height = 1 + max(getHeight(node.left),getHeight(node.right));
		int balance = getBalance(node);
		
		//LL
		if(balance > 1 && val < node.left.key) {
			return rightRotate(node);
		}
		
		//RR
		if(balance < -1 && val > node.right.key) {
			return leftRotate(node);
		}
		
		//LR
		if(balance > 1 && val > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		//RL
		if(balance < -1 && val < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	public void inOrderDisplay() {
		inOrderDisplay(root);
	}
	public void inOrderDisplay(Node node) {
		if(node!=null) {
			inOrderDisplay(node.left);
			System.out.println(node.key + " - " + node.height);
			inOrderDisplay(node.right);
		}
	}
	public static void main(String[] args) {
		
		AVL avl = new AVL(100);
		avl.insert(10);
		avl.insert(20);
		avl.insert(30);
		avl.insert(40);
		avl.insert(50);
		avl.insert(60);
		avl.insert(70);
		avl.insert(80);
		avl.insert(90);
		avl.insert(110);
		avl.insert(120);
		avl.insert(130);
		avl.insert(140);
		avl.insert(150);
		avl.insert(160);
		avl.insert(170);
		avl.insert(180);
		avl.insert(190);
		avl.insert(200);
		avl.inOrderDisplay();
	}
}
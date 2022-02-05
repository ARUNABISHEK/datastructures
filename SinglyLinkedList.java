package com.lineardatastructure;

public class SinglyLinkedList {
	Node head;
	class Node {
		int data;
		Node next;
		Node(int value) {
			data = value;
			next = null;
		}
	}
	
	SinglyLinkedList(){
		head = null;
	}
	
	public void addFront(int value) {
		Node newNode = new Node(value);
		if(head==null) {	//When List is Empty
			head = newNode;
		}
		else {	//When list is not-Empty
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void display() {
		int count = 0;
		Node temp = head;
		while(temp!=null) {
			if(count!=0)
				System.out.print(" --> ");
			System.out.print(temp.data);
			temp = temp.next;
			count++;
		}
	}
	
	public void addEnd(int value) {
		Node newNode = new Node(value);
		Node temp = head;
		if(head==null) {
			addFront(value);
			return;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public void addPostion(int pos,int value) {
		Node newNode = new Node(value);
		Node temp = head;
		if(pos==0)
			addFront(value);
		for(int i=1;i<pos;i++) {
			temp = temp.next;
			if(temp==null) {
				throw new NullPointerException("Index is Outof Range : " + pos);
			}
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void deleteNode(int pos) {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(pos==0) {
			head = head.next;
			return;
		}
		Node temp = head;
		Node prev = null;
		for(int i=1;i<=pos;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	
	public int length() {
		int count = 0;
		Node temp = head;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = head.next;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public void search(int val) {
		Node temp = head;
		int count = 0;
		while(temp!=null) {
			if(temp.data == val) {
				System.out.println("Found at : " + count);
				return;
			}
			temp = temp.next;
			count++;
		}
		System.out.println("Not Found");
	}
	
	public void sort() {
		Node temp = head,nextNode;
		int tempVal;
		while(temp!=null) {
			nextNode = temp.next;
			while(nextNode != null) {
				if(temp.data > nextNode.data) {
					tempVal = temp.data;
					temp.data = nextNode.data;
					nextNode.data = tempVal;
				}
				nextNode = nextNode.next;
			}
			temp = temp.next;
		}
	}
	
	public int get(int index) {
		int val=0,pos;
		Node temp = head;
		if(index==0) {
			return head.data;
		}
		if(index>=length()) {
			throw new IndexOutOfBoundsException("Index is Outof Range : " + index);
		}
		else if(index < 0) {
			throw new IndexOutOfBoundsException("Index must be non negative value : " + index);
		}
		for(pos=0;pos<index;pos++) {
			temp = temp.next;
			val = temp.data;
		}
		return val;
		}
		
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFront(10);
		list.addFront(5);
		list.addEnd(20);
		list.addEnd(25);
		list.addPostion(2, 15);
		list.addEnd(4);
		list.addEnd(2);
		list.addEnd(-3);
		list.deleteNode(1);
		System.out.println("head Value : " + list.head.data);
		System.out.println("Length : " + list.length());
		System.out.print("List : ");
		list.display();
		System.out.println();
		list.reverse();
		System.out.print("Reverse : ");
		list.display();
		System.out.println();
		list.reverse();
//		list.display();
		list.search(25);
		System.out.print("Sorted List : ");
		list.sort();
		list.display();
		System.out.println();
		int value = list.get(5);
		System.out.println("Value : " + value);
	}

}

package com.lineardatastructure;

/*
 * Enqueue: Add an element to the end of the queue
 * Dequeue: Remove an element from the front of the queue
 * IsEmpty: Check if the queue is empty
 * IsFull: Check if the queue is full
 * Peek: Get the value of the front of the queue without removing it
 *   
 */

public class CircularQueue {
	
	int SIZE = 5;
	int[] arr = new int[SIZE];
	int front = -1;
	int rear = -1;
	
	boolean isEmpty() {
		if(front==-1)
			return true;
		return false;
	}
	
	boolean isFull() {
		if(front == 0 && rear == SIZE-1)
			return true;
		else if(front == rear + 1)
			return true;
		return false;
	}
	
	void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full...");
		}
		else {
			if(front==-1)
				front = 0;
			rear = (rear + 1) % SIZE;
			arr[rear] = data; 
			
		}
	}
	int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty...");
			return (-1);
		}
		else {
			int deleteValue = arr[front];
			if(front==rear) {
				front = -1;
				rear = -1;
			}
			else {
				front = (front + 1) % SIZE;
			}
			return deleteValue;
		}
	}
	
	void display() {
		int i;
		if(isEmpty()) {
			System.out.println("Queue is empty...");
		}
		else {
			for(i=front;i!=rear;i=(i + 1) % SIZE) 
				System.out.println(arr[i]);
			System.out.println(arr[i]);
		}
	}
	
	int peek() {
		return arr[front];
		
	}
	public static void main(String[] args) {
		
		CircularQueue cq = new CircularQueue();
		cq.enQueue(10);
		cq.enQueue(20);
		cq.enQueue(30);
		cq.enQueue(40);
		cq.enQueue(50);
		cq.deQueue();
		cq.deQueue();
		cq.enQueue(60);
		cq.enQueue(70);
		cq.display();
		System.out.println("Front : " + cq.peek());
	}

}
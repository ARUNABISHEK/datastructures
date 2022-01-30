package com.lineardatastructure;

/*
 * Enqueue: Add an element to the end of the queue
 * Dequeue: Remove an element from the front of the queue
 * IsEmpty: Check if the queue is empty
 * IsFull: Check if the queue is full
 * Peek: Get the value of the front of the queue without removing it
 *   
 */
public class Queue {
	
	int front = -1;
	int rear = -1;
	int size = 5;
	int[] arr = new int[size];
	
	boolean isEmpty() {
		if(front==-1 && rear ==-1)
			return true;
		return false;		
	}
	
	boolean isFull() {
		if(rear == size-1)
			return true;
		return false;	
	}
	
	void enqueue(int data) {
		if(isFull()) {
			System.out.println("Queue is Full....Data added not possible");
		}
		else {
			if(front==-1) 
				front = 0;
			arr[++rear] = data;
		}
	}
	
	
	void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty....");
		}
		else {
			int deleteValue = arr[front];
			if(front >= rear) {
				front = -1;
				rear = -1;
			}
			else {
				front++;
			}
		}
	}
	
	void display() {
		if(front==-1) {
			front = 0;
		}
		for(int i=front;i<=rear;i++)
			System.out.println(arr[i]);
	}
	
	int peek() {
		return arr[front];
	}
	public static void main(String[] args) {		
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.dequeue();
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		q.enqueue(60);
		System.out.println("Front Element" + q.peek());
	}

}

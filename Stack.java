package com.lineardatastructure;
/*
 * 
 * Basic Operations of Stack:
 * -----------------------------------------------------------------
 * Push: 	Add an element to the top of a stack
 * Pop: 	Remove an element from the top of a stack
 * IsEmpty: Check if the stack is empty
 * IsFull: 	Check if the stack is full
 * Peek: 	Get the value of the top element without removing it
 * 
*/
public class Stack {
	
	private int top = -1;
	private int size = 5;
	int[] arr = new int[size];
	
//Check Stack is empty
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;	
	}
	
//check Stack is full
	public boolean isFull() {
		if(top==(size-1))
			return true;
		return false;
	}

//Adding the element
	public void push(int data) {
		if(isFull())
			System.out.println("Stack is full...Do not perform push operation...");
		else
			arr[++top] = data;
	}
//Removing the element
	public void pop() {
		if(isEmpty())
			System.out.println("Stack dose not contain any data...");
		else {
			//int deleteValue = arr[top];
			top--;
		}
	}
//Display the stack
	public void display() {
		for(int i=0;i<=top;i++)
			System.out.println(arr[i]);
	}

//Display top element
	int peek() {
		return arr[top];
		//System.out.println("Lost element is : " + arr[top]);
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.pop();
		s.display();
		System.out.println("Top Element : " + s.peek());
	}
}

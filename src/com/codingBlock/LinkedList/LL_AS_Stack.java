package com.codingBlock.LinkedList;


public class LL_AS_Stack {
	
	private LinkedList stack;
	
	
	public int size(){
		return this.stack.size();
	}
	public LL_AS_Stack() {
		this.stack = new LinkedList();
	}
	public boolean isEmpty(){
		return this.stack.isEmpty();
	}
	public void push(int data){
		this.stack.addFirst(data);
	}
	public int top() throws Exception{
		return this.stack.getFirst();
	}
	public int pop() throws Exception{
		return this.stack.removeFirst();
	}
	public void display(){
		this.stack.display();
	}

}

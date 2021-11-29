package com.codingBlock.queues;

import com.codingBlock.Stack.DynamicStack;

public class QUSDnqueueEfficient {
	private DynamicStack primary;
	private DynamicStack secondary;
	
	public QUSDnqueueEfficient() throws Exception{
		this.primary = new DynamicStack();
		this.secondary = new DynamicStack();
	}
	
	public boolean isEmpty(){
		return this.primary.isEmpty();
	}
	public int size(){
		return this.primary.size();
	}
	
	
	//o(n)
	public void enqueue(int data) throws Exception{
		while(primary.size() != 0){
			secondary.push(primary.pop());
		}
		primary.push(data);
		while(secondary.size() != 0){
			primary.push(secondary.pop());
		}
	}
	
	
	//o(1)
	public int dequeue() throws Exception{
		return this.primary.pop();
	}
	
	//o(1)
	public int Front() throws Exception{
		int rv = primary.top();
		return rv;
	}
	
	//o(1)
	public void display() throws Exception{
		primary.display();
	}
	
}

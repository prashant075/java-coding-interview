package com.codingBlock.Stack;

import com.codingBlock.queues.QueuesUsingLL;

public class SUQPushEfficient {
	private QueuesUsingLL primary;
	private QueuesUsingLL secondary;
	
	public SUQPushEfficient() {
		this.primary = new QueuesUsingLL();
		this.secondary = new QueuesUsingLL();
	}
	
	public int size(){
		return this.primary.size();
	}
	public boolean isEmpty(){
		return this.primary.isEmpty();
	}
	
	public void push(int data){
		this.primary.enqueue(data);
	}
	
	public int pop(){
		while(this.primary.size() != 1){
			secondary.enqueue(this.primary.getdequeue());
		}
		int rv  =this.primary.getdequeue();
		while(this.secondary.size()!=0){
			this.primary.enqueue(this.secondary.getdequeue());
		}
		return rv;
	}
	
	public int top(){
		while(this.primary.size() != 1){
			secondary.enqueue(this.primary.getdequeue());
		}
		int rv  =this.primary.getdequeue();
		this.secondary.enqueue(rv);
		while(this.secondary.size()!=0){
			this.primary.enqueue(this.secondary.getdequeue());
		}
		return rv;
		
	}
	public void display(){
		reverseQueue(this.primary);
		this.primary.display();
		reverseQueue(this.primary);
	}
	
	private static void reverseQueue(QueuesUsingLL queue){
		
		if(queue.isEmpty()){
			return;
		}
		int element= queue.getdequeue();
		reverseQueue(queue);
		queue.enqueue(element);
	}
	

}

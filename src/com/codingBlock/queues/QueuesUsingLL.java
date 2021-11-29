package com.codingBlock.queues;

import java.util.LinkedList;

public class QueuesUsingLL {
	
	LinkedList<Integer> queue;
	
	public QueuesUsingLL(){
		queue = new LinkedList<>();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public int size(){
		return queue.size();
	}
	
	public void enqueue(int data){
		queue.addLast(data);
	}
	
	public void dequeue(){
		queue.removeFirst();
	}
	
	public int getdequeue(){
		return queue.removeFirst();
	}
	
	public int getFront(){
		return queue.getFirst();
	}
	public void display(){
		while(!this.queue.isEmpty()){
			System.out.println(this.queue.getFirst());
			this.queue.remove();
		}
	}
	
	public static void main(String[] args){
		QueuesUsingLL queue = new QueuesUsingLL();
		for(int i=1;i<=6;i++){
			queue.enqueue(i);
		}
		
		queue.dequeue();
		queue.dequeue();
		
		queue.enqueue(8);
		while(!queue.isEmpty()){
			System.out.println(queue.getFront());
			queue.dequeue();
		}
		
	}

}

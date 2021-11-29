package com.codingBlock.queues;

public class CircularArrayQueue {
	private int[] arr;
	private int cs;
	private int ms;
	private int front;
	private int rear;
	
	public static int DEFAULT_CAPACITY =10;
	
	CircularArrayQueue(){
		this(DEFAULT_CAPACITY);
	}

	CircularArrayQueue(int CAPACITY) {
		this.arr = new int[CAPACITY];
		this.cs =0;
		this.ms = CAPACITY;
		this.front =0;
		this.rear=CAPACITY -1;
	}
	
	public boolean isFull(){
		return this.cs == this.ms;
		
	}
	public boolean isEmpty(){
		return this.cs ==0;
		
	}
	public void enqueue(int data){
		if(!this.isFull()){
			this.rear =(this.rear+1)%this.arr.length;
			this.arr[this.rear] =data;
			this.cs++;
		}
	}
	
	public void dequeue(){
		if(!this.isEmpty()){
			this.front=(this.front+1)%this.arr.length;
			this.cs--;
		}
	}
	
	public int getFront(){
		return this.arr[this.front];
	}
	
	public static void main(String[] args){
		CircularArrayQueue queue = new CircularArrayQueue();
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

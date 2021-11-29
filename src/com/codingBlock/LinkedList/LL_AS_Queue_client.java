package com.codingBlock.LinkedList;

public class LL_AS_Queue_client {
	
	public static void main(String[] args) throws Exception{
		LL_AS_Queue queue = new LL_AS_Queue();
		queue.enqueue(10);
		queue.display();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		System.out.println(queue.dequeue());
		queue.display();
		System.out.println(queue.size()); 
	}

}

package com.codingBlock.queues;

public class QUSDnqueueEfficientClient {
	public static void main(String[] args) throws Exception{
	QUSDnqueueEfficient queue = new QUSDnqueueEfficient();
	
	for(int i =1; i< 5 ; i++){
		queue.enqueue(i*10);
	}
	queue.display();
	
	System.out.println(queue.dequeue());
	
	queue.display();
	}
}

package com.codingBlock.queues;

public class ReverseQueue {
	
	public static void main(String[] args){
		
		QueuesUsingLL queue = new QueuesUsingLL();
		for(int i=1;i<=6;i++){
			queue.enqueue(i);
		}
		reverseQueue(queue); 
		while(!queue.isEmpty()){
			System.out.println(queue.getFront());
			queue.dequeue();
		}
	}
	
	public static void reverseQueue(QueuesUsingLL queue){
		
		if(queue.isEmpty()){
			return;
		}
		int element= queue.getdequeue();
		reverseQueue(queue);
		queue.enqueue(element);
	}

}
